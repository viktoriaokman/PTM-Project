package com.company;

public abstract class Server implements IServer{
    public int port;
    public ClientHandler ch;
    public boolean stopListen = false;

    public Server(int port, ClientHandler ch) {
        this.port = port;
        this.ch = ch;
    }

    public void start(ClientHandler ch) {
        stopListen = false;
    }

    public void stop() {
        stopListen = true;
    }
}