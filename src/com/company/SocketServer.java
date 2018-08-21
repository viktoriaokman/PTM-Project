package com.company;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Server implements IServer{
    boolean closeServer = false;
    public SocketServer(int port) {
        super(port);
        //isRunning = false;
    }

    @Override
    public void start(ClientHandler ch) {
        //if (!isRunning) {
            super.start(ch); // stopListen = false;
            //runServer();
            new Thread(()->runServer()).start();
        //}

    }

    private void runServer(){
        ServerSocket server = null;
        try {


            while (!closeServer) {
                //isRunning = true;
                try {
                    // Check connection is made
                    server = new ServerSocket(port);
                    server.setSoTimeout(3000);

                    Socket clientSocket = server.accept();
                    InputStream in = clientSocket.getInputStream();
                    OutputStream out = clientSocket.getOutputStream();

                    ch.handleClient(in, out);
                // op 2
                 /*   clientSocket.getOutputStream().close();
                clientSocket.getInputStream().close();

                clientSocket.close();*/
                }
                catch ( Exception ex) {
                    //isRunning = false;
                    ex.getMessage();
                }
            }
        } catch (Exception e) {
        }

        try {
            //server.close();
        }
        catch (Exception e) {

        }
    }
    @Override
    public void stop() {
        super.stop();
        closeServer = true;
    }
}