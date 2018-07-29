package com.company;

import java.io.InputStream;

// TODO : Convert all string imp to generics
public class Problem<T> implements IProblem {
    //private String _problemContent;
    //private String _delimiter;
    T problem;
    int _size = 0;
    /*public Problem(InputStream inFromClient) {
        problem = (T) PTMUtils.convertStreamToString(inFromClient);
        //_delimiter = "#Problem:";
    }*/

    public Problem (T problem)
    {
        this.problem = problem;
    }

    public String ProblemAsString() {
        try
        {
            return PTMUtils.convertStreamToString((InputStream)problem);
        }
        catch (Exception e)
        {
            //?
        }
        return "";
    }

    @Override
    public int GetSize() {
        return _size;
    }
}
