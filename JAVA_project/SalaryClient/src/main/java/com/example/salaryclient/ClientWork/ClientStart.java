package com.example.salaryclient.ClientWork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientStart {
    public Object sendMessage;
    private Socket clientSocket;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private String message;

    public ClientStart(String ipAddress, String port) {
        try {
            clientSocket = new Socket(ipAddress, Integer.parseInt(port));
            outStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inStream = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("получилось");
        } catch (IOException e) {
            System.out.println("Server not found: " + e.getMessage());
            System.exit(0);
        }
    }

    public void sendMessage(String message) {
        try {
            outStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object object){
        try {
            outStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readMessage() throws IOException {
        try {
            message = (String) inStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return message;
    }

    public Object readObject(){
        Object object = new Object();
        try {
            object = inStream.readObject();
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
        }
        return object;
    }
}
