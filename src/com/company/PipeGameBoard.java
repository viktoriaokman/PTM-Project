package com.company;

import java.util.ArrayList;
import java.util.List;

public class PipeGameBoard /*extends SearchableBoard*/ implements ISearchable {
    int size = 0;
    int numOfRows = 0;
    Point<String>[][] board ;
    IProblem _problem;
    public PipeGameBoard(IProblem problem)
    {
        _problem = problem;
        this.size = problem.GetSize();
        this.numOfRows = problem.GetNumOfRows();
        List<String> temp = problem.GetProblemContent();
        String temp2 = "";
        board= new Point [numOfRows][size];


        for (int k = 0; k < numOfRows ; k++)
        {
            for (int l = 0;l<size ;l++)
            {
                board[k][l] = new Point<>(k,l,null,TypeOfPoint.Wall,false,0);
            }
        }


        for (int i = 0; i < numOfRows; i++)
        {
            for (int j = 0; j < size; j++) {
                if (temp.size()>0) {
                    //temp2 = Character.toString(temp.get(0).charAt(0));
                    //temp = temp.substring(1);
                    try {
                        temp2 = Character.toString(temp.get(i).charAt(j));
                    }
                    catch (Exception e)
                    {
                        break;
                    }
                }
                board[i][j].content = temp2;
                if (temp2 != null)
                {
                    if (temp2.length()>0) {
                        temp2 = null;
                        switch (board[i][j].content) {
                            case "s":
                                board[i][j].typeOfPoint = TypeOfPoint.Start;
                                break;
                            case "g":
                                board[i][j].typeOfPoint = TypeOfPoint.End;
                                break;
                        case " ":
                            board[i][j].typeOfPoint = TypeOfPoint.Wall;
                            break;
                            default:
                                board[i][j].typeOfPoint = TypeOfPoint.Common;
                                break;
                        }
                    }
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
        if (!checkIfWall(x-1,y))
        {
            if (!board[x-1][y].visited)
                return board[x-1][y];
        }

        return  null;
    }

    public Point<String> getDown(int x, int y)
    {
        if (!checkIfWall(x+1,y))
        {
            if (!board[x+1][y].visited)
                return board[x+1][y];
        }

        return  null;
    }

    public Point<String> getLeft(int x, int y)
    {
        if (!checkIfWall(x,y-1))
        {
            if (!board[x][y-1].visited)
                return board[x][y-1];
        }

        return  null;
    }
    public Point<String> getRight(int x, int y)
    {
        if (!checkIfWall(x,y+1))
        {
            if (!board[x][y+1].visited)
                return board[x][y+1];
        }

        return  null;
    }

    public ArrayList<Point> getAllAdj(Point<String> state)
    {

        int x =state.x;
        int y=state.y;

        ArrayList<Point> t = new ArrayList<Point>();
        Point<String> point;

        switch (state.content) {
            case "s":
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
                break;
            case "g":
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
                break;
            case "-":
                point = getRight(x,y);
                if (point!= null)
                    t.add(point);
                point = getLeft(x,y);
                if (point!= null)
                    t.add(point);
                break;
            case "|":
                point = getUp(x,y);
                if (point!= null)
                    t.add(point);
                point = getDown(x,y);
                if (point!= null)
                    t.add(point);
                break;
            case "L":
                point = getUp(x,y);
                if (point!= null)
                    t.add(point);
                point = getRight(x,y);
                if (point!= null)
                    t.add(point);
                break;
            case "F":
                point = getRight(x,y);
                if (point!= null)
                    t.add(point);
                point = getDown(x,y);
                if (point!= null)
                    t.add(point);
                break;
            case "J":
                point = getUp(x,y);
                if (point!= null)
                    t.add(point);
                point = getLeft(x,y);
                if (point!= null)
                    t.add(point);
                break;
            case "7":
                point = getLeft(x,y);
                if (point!= null)
                    t.add(point);
                point = getDown(x,y);
                if (point!= null)
                    t.add(point);
                break;

        }
        /*point = getRight(x,y);
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
            t.add(point);*/
        return t;
    }



    public Point<String> getStart()
    {
        for (int i = 0; i < numOfRows ; i++)
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
        for (int i = 0; i < numOfRows ; i++)
        {
            for (int j = 0; j < size ; j++)
            {
                if (board[i][j].GetPointType() == TypeOfPoint.End)
                    return board[i][j];
            }
        }
        return null;
    }

    @Override
    public State getInitialState() {
        return new State(getStart());
    }

    @Override
    public State getGoalState() {
        return new State(getEnd());
    }

    @Override
    public ArrayList<State<Point>> getAllPossibleStates(State s) {
        State<Point> Current = s;
        ArrayList<State<Point>> list = new ArrayList<>();
        ArrayList<Point> allPoint = getAllAdj(Current.state);

        for (int i = 0 ; i < allPoint.size();i++)
        {
            State<Point> SP = new State<Point>(allPoint.get(i).Clone());
            State<Point> initial = new State<>(SP.state.Clone()).Clone();
            if (Point.PointsConnected(Current.state,SP.state) && !SP.state.visited)
            {
                SP.setCameFrom(Current);
                board[Current.state.x][Current.state.y].visited = true;
                //SP.state.visited = true;
                State<Point> pointToAdd = SP.Clone();
                list.add(pointToAdd);
            }
            // Turn next point
            SP.state = (Point.TurnPoint(SP.state.Clone())).Clone();


               while (!SP.state.content.equals(initial.state.content))
               {
                   // Check if next turned point can connect
                   if (Point.PointsConnected(Current.state,SP.state) && !SP.state.visited)
                   {
                       SP.setCameFrom(Current);
                       board[Current.state.x][Current.state.y].visited = true;
                       State<Point> pointToAdd = SP.Clone();
                       list.add(pointToAdd);

                       //list.add(new State<Point>(SP.state.Clone()).Clone());
                   }
                   SP.state = (Point.TurnPoint(SP.state.Clone())).Clone();
               }
        }
        return list;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getNumOfRows() {
        return numOfRows;
    }

    @Override
    public ISearchable clone() {
        return new PipeGameBoard(_problem);
    }
}
