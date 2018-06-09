package com.company;

import java.io.InputStream;
import java.io.OutputStream;
public interface IClientHandler {
    void handleClient(InputStream inFromClient, OutputStream outToClient);
}