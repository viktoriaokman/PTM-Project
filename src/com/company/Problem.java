package com.company;

import java.io.InputStream;

public class Problem implements IProblem {
    private String problem;
    int _size = 0;
    public Problem(InputStream inFromClient) {
        problem = PTMUtils.convertStreamToString(inFromClient);
    }


    public Point[][] toPoints()
    {
        Point[][] p = new Point[_size][_size];



        return p;
    }

    public String GetProblemContent() {
            return problem;
    }

    @Override
    public int GetSize() {
        return _size;
    }
}
