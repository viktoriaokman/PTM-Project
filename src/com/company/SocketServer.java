package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Server {

    private Boolean isRunning = false; // Used to prevent multiple instances. maybe redundant

    public SocketServer(int port, ClientHandler ch) {
        super(port, ch);
        isRunning = false;
    }

    @Override
    public void start(ClientHandler ch) {
        if (!isRunning) {
            super.start(ch); // stopListen = false;
            runServer();
        }
    }

    private void runServer() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            //e.printStackTrace();
            stopListen = true;
            isRunning = false;
        }
        while (!stopListen) {
            isRunning = true;
            try {
                // Check connection is made
                Socket clientSocket = server.accept();

                ch.handleClient(clientSocket.getInputStream(), clientSocket.getOutputStream());
                clientSocket.getInputStream().close();
                clientSocket.getOutputStream().close();
                clientSocket.close();
            } catch (Exception ex) {
                isRunning = false;
            }
        }
    }

    // why ?
    /*public void StartServer() {
        stopListen = false;
        if (!isRunning)
            runServer();
    }*/

    @Override
    public void stop() {
        super.stop();
        isRunning = false;
    }
}
