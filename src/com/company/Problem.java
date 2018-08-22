package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class Problem implements IProblem {
    private String problem;
    private List<String> problemLines;

    int _size = 0;
    int _numOfRows = 1;
    public Problem(InputStream inFromClient) {
        problem = PTMUtils.convertStreamToString(inFromClient);
        _size=problem.length();
    }

    public Problem(BufferedReader inFromClient)
    {
        problemLines = new LinkedList<>();
        try {
            String line;
            while(!(line=inFromClient.readLine()).equals("done")) {
                problemLines.add(line);
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
        _size=problemLines.get(0).length();

        try {
            if (problemLines.size() > 0)
                _numOfRows = problemLines.size();
        }
        catch (Exception e)
        {

        }
    }

    public Point[][] toPoints()
    {
        Point[][] p = new Point[_numOfRows][_size];
        return p;
    }

    public List<String> GetProblemContent() {
            return problemLines;
    }

    @Override
    public int GetSize() {
        return _size;
    }

    @Override
    public int GetNumOfRows() {
        return _numOfRows;
    }
}
