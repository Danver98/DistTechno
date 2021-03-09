package ru.krista.edu.distrib.tech.socket;
import java.io.IOException;
import java.net.Socket;
import java.net.ConnectException;
import java.util.ArrayList;
//Реализовать socket client который просканирует все порты Вашей локальной машины. И выведет список занятых портов
public class PortScanner {
    private static int PORTS_COUNT = 65535;
    private static String LOCAL_HOST = "localhost";

    private static boolean portIsBusy(int port) throws IOException {
        Socket socket;
        try {
            socket = new Socket(LOCAL_HOST, port);
            socket.close();
            return false;
        } catch (ConnectException e) {
            return true;
        }
    }

    public void scanAndPrintBusyPorts(int portsNumber) throws IOException{
        for(int port=1; port <=portsNumber;port++){
            if(portIsBusy(port))
                System.out.println(port);
        }  
    }

    public static void main(String [] args) throws IOException{
        PortScanner scanner = new PortScanner();
        scanner.scanAndPrintBusyPorts(PORTS_COUNT);
    }
}
