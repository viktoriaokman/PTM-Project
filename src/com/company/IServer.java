package com.company;

public interface IServer {
    void start(ClientHandler ch);
    void stop();
}
