package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Server implements IServer{

    private Boolean isRunning = false; // Used to prevent multiple instances. maybe redundant

    public SocketServer(int port) {
        super(port);
        isRunning = false;
    }

    @Override
    public void start(ClientHandler ch) {
        if (!isRunning) {
            super.start(ch); // stopListen = false;
            //runServer();
            new Thread(()->runServer()).start();
        }

    }

    private void runServer(){
        ServerSocket server = null;
        try {

            server = new ServerSocket(port);
            server.setSoTimeout(3000);
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
                /*clientSocket.getOutputStream().close();
                clientSocket.getInputStream().close();

                clientSocket.close();*/
            }
            catch ( Exception ex) {
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