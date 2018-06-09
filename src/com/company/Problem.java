package com.company;

import java.io.IOException;
import java.io.InputStream;

public class Problem implements IProblem{
    private String _problemName;
    private String _problemContent;
    private String _delimiter;

    // TODO: Check from igor if can use IOUtils
    public Problem(InputStream inFromClient) {
        try {
            inFromClient.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mock! not finished!!
    private Problem FromInputStream(InputStream problem)
    {
        // ??
        //return new Problem();
    }

    @Override
    public String GetName() {
        //string.parse(problem._problemContent,_delimiter)
        return this._problemName;
    }
}
