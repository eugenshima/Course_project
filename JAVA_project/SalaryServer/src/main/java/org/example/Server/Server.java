package org.example.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.Server.ServerStart.PORT_WORK;

public class Server implements Runnable {
    protected int serverPort = 8888;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    public Server(int port){
        this.serverPort = port;
    }

    @Override
    public void run(){
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            new Thread(new Worker(clientSocket)).start();
            System.out.println("Client connected.");
        }
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        System.out.println("Stopping Server");
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        System.out.println("Opening server socket...");
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + this.serverPort, e);
        }
    }
}

