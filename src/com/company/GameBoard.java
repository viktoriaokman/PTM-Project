package com.company;

import java.util.ArrayList;

public class GameBoard<T> extends SearchableBoard {
    int size = 0;
    Point<T>[][] board ;
    public GameBoard(int boardSize)
    {
        this.size = boardSize;
        board= new Point [size][size];
    }
    public boolean checkIfWall(int x, int y)
    {
        try {
            return board[x][y].GetPointType()== TypeOfPoint.Wall;
        }
        catch (Exception e)
        {
            return true;
        }
    }

    public Point<T> getUp(int x, int y)
    {
        if (!checkIfWall(x,y-1))
        {
            return board[x][y-1];
        }

        return  null;
    }

    public Point<T> getDown(int x, int y)
    {
        if (!checkIfWall(x,y+1))
        {
            return board[x][y+1];
        }

        return  null;
    }

    public Point<T> getLeft(int x, int y)
    {
        if (!checkIfWall(x-1,y))
        {
            return board[x-1][y];
        }

        return  null;
    }
    public Point<T> getRight(int x, int y)
    {
        if (!checkIfWall(x+1,y))
        {
            return board[x+1][y];
        }

        return  null;
    }

    public ArrayList<Point> getAllAdj(int x,int y)
    {
        ArrayList<Point> t = new ArrayList<Point>();
        Point<T> point;
        point = getRight(x,y);
        if (point!= null)
            t.add(point);
        point = getLeft(x,y);
        if (point!= null)
            t.add(point);
        point = getUp(x,y);
        if (point!= null)
            t.add(point);
        point = getDown(x,y);
        if (point!= null)
            t.add(point);
        return t;
    }
    public Point<T> getStart()
    {
        for (int i = 0; i<size ; i++)
        {
            for (int j = 0; j<size ; j++)
            {
                if (board[i][j].GetPointType() == TypeOfPoint.Start)
                    return board[i][j];
            }
        }
        return null;
    }

    public Point<T> getEnd()
    {
        for (int i = 0; i<size ; i++)
        {
            for (int j = 0; j<size ; j++)
            {
                if (board[i][j].GetPointType() == TypeOfPoint.End)
                    return board[i][j];
            }
        }
        return null;
    }
}
