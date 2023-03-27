package org.example.Server;

public class ServerStart  {
    public static final int PORT_WORK = 8888;

    public static void main(String[] args) {
        Server server = new Server(PORT_WORK);
        new Thread(server).start();
    }
}