package com.company;

public abstract class Server implements IServer{
    public int port;
    public ClientHandler ch;
    public boolean stopListen = false;

    public Server(int port) {
        this.port = port;
    }

    public void start(ClientHandler ch) {
        this.ch = ch;
        stopListen = false;
    }

    public void stop() {
        stopListen = true;
    }
}