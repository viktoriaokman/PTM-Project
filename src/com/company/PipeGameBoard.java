package com.company;

import java.util.ArrayList;

public class PipeGameBoard extends SearchableBoard {
    int size = 0;
    Point<String>[][] board ;
    public PipeGameBoard(IProblem problem)
    {
        this.size = problem.GetSize();
        String temp = problem.GetProblemContent();
        board= new Point [size][size];

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++) {
                board[i][j].content = Character.toString(temp.charAt(temp.length()));
                switch (board[i][j].content){
                    case "s":
                        board[i][j].typeOfPoint = TypeOfPoint.Start;
                        break;
                    case "g":
                        board[i][j].typeOfPoint = TypeOfPoint.End;
                        break;
                    case "w":
                        board[i][j].typeOfPoint = TypeOfPoint.Wall;
                        break;
                     default:
                         board[i][j].typeOfPoint = TypeOfPoint.Common;
                         break;
                }
            }
        }
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

    public Point<String> getUp(int x, int y)
    {
        if (!checkIfWall(x,y-1))
        {
            return board[x][y-1];
        }

        return  null;
    }

    public Point<String> getDown(int x, int y)
    {
        if (!checkIfWall(x,y+1))
        {
            return board[x][y+1];
        }

        return  null;
    }

    public Point<String> getLeft(int x, int y)
    {
        if (!checkIfWall(x-1,y))
        {
            return board[x-1][y];
        }

        return  null;
    }
    public Point<String> getRight(int x, int y)
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
        Point<String> point;
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
    public Point<String> getStart()
    {
        for (int i = 0; i < size ; i++)
        {
            for (int j = 0; j < size ; j++)
            {
                if (board[i][j].GetPointType() == TypeOfPoint.Start)
                    return board[i][j];
            }
        }
        return null;
    }

    public Point<String> getEnd()
    {
        for (int i = 0; i < size ; i++)
        {
            for (int j = 0; j < size ; j++)
            {
                if (board[i][j].GetPointType() == TypeOfPoint.End)
                    return board[i][j];
            }
        }
        return null;
    }
}
