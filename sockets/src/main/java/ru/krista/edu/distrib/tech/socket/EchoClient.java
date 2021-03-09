package ru.krista.edu.distrib.tech.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    static int SURNAME_PORT = 6000;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String args[]){
        System.out.println("Enter message for server (default: 'hello server'):\n");
        Scanner sc = new Scanner(System.in);
        String msg = "hello server";
        if (sc.hasNextLine()){
            msg = sc.nextLine();
        }
        sc.close();
        EchoClient client = new EchoClient();
        int port = SURNAME_PORT;
        try{
        client.startConnection("localhost", port);
        System.out.println(client.sendMessage(msg));
        client.stopConnection();
        } catch (IOException e){

        } 
    }
}