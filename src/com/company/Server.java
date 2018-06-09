package com.company;

/// Use INTERFACE FOR ISERVER!!
public abstract class Server {
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