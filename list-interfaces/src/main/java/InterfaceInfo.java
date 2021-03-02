import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Collections;
import java.net.SocketException;
import java.net.UnknownHostException;

public class InterfaceInfo {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        NetworkInterface ni;
        while (interfaces.hasMoreElements()) {
            ni = interfaces.nextElement();
            System.out.println("Name: " + ni.getDisplayName());
            Enumeration<InetAddress> ips = ni.getInetAddresses();
            for(InetAddress ia: Collections.list(ips)){
                if (ia instanceof Inet4Address)
                    System.out.println("IPv4-address: " + ia);
                else
                    System.out.println("IPv6-address: " + ia);
            }
            byte[] mac = ni.getHardwareAddress();
            if(mac!= null){
                String[] hex = new String[mac.length];
                for (int i = 0; i < mac.length; i++) {
                    hex[i] = String.format("%02X", mac[i]);
                }
                System.out.println("MAC-address: " + String.join("-", hex));
            }
            System.out.println();
        }
    }
}
