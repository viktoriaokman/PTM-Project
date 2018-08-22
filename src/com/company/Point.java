package com.company;

public class Point<String> {
    int x;
    int y;
    String content;
    TypeOfPoint typeOfPoint;
    boolean visited = false;
    int numOfTurns = 0;

    public Point(int x,int y,String content,TypeOfPoint typeOfPoint,boolean visited,int numOfTurns)
    {
        this.x = x;
        this.y = y;
        this.typeOfPoint = typeOfPoint;
        this.content = content;
        this.visited = visited;
        this.numOfTurns = numOfTurns;
    }

    public Point Clone()
    {
        return new Point(this.x,this.y,this.content,this.typeOfPoint,this.visited,this.numOfTurns);
    }

    public TypeOfPoint GetPointType()
    {
        return typeOfPoint;
    }

    public static Point TurnPoint(Point p)
    {
        switch (p.content.toString())
        {
            case "L": {
                p.content = "F";
                break;
            }
            case "F": {
                p.content = "7";
                break;
            }
            case "7": {
                p.content = "J";
                break;
            }
            case "J": {
                p.content = "L";
                break;
            }

            case "|": {
                p.content = "-";
                break;
            }
            case "-": {
                p.content = "|";
                break;
            }
        }
        p.numOfTurns++;
        return p;
    }

    public static boolean PointsConnected(Point p1,Point p2)
    {
        if (p1.content.equals("s") || p1.content.equals("t")) {

            // If up NOT to: - , L , J
            if (p2.x < p1.x && !(p2.content.equals("-") || p2.content.equals("L") || p2.content.equals("J") ))
                return true;
            // If right NOT to: L , F , |
            if (p2.y > p1.y && !(p2.content.equals("|") || p2.content.equals("L") || p2.content.equals("F") ))
                return true;
            // If left NOT to: 7 , J , |
            if (p2.y < p1.y && !(p2.content.equals("7") || p2.content.equals("J") || p2.content.equals("|")))
                return true;
            // If down NOT to: F , 7 , -
            if (p2.x>p1.x && !(p2.content.equals("F") || p2.content.equals("7") || p2.content.equals("-") ))
                return true;

            return false;
        }

        if (p1.content.equals("L"))
        {
            if (p2.x < p1.x && !(p2.content.equals("-") || p2.content.equals("L") || p2.content.equals("J") ))
                return true;
            if (p2.y > p1.y && !(p2.content.equals("|") || p2.content.equals("L") || p2.content.equals("F") ))
                return true;
            return false;
            // If up NOT to: - , L , J
            // If right NOT to: L , F , |

        }
        if (p1.content.equals("F"))
        {
            // If right NOT to: L , F , |
            if (p2.y > p1.y && !(p2.content.equals("|") || p2.content.equals("L") || p2.content.equals("F") ))
                return true;
            // If down NOT to: F , 7 , -
            if (p2.x>p1.x && !(p2.content.equals("F") || p2.content.equals("7") || p2.content.equals("-") ))
                return true;


            return false;
        }
        if (p1.content.equals("7"))
        {
            // If down NOT to : F , 7 , -
            if (p2.x>p1.x && !(p2.content.equals("F") || p2.content.equals("7") || p2.content.equals("-") ))
                return true;


            // If left NOT to: 7 , J , |
            if (p2.y < p1.y && !(p2.content.equals("7") || p2.content.equals("J") || p2.content.equals("|")))
                return true;

            return false;
        }
        if (p1.content.equals("J"))
        {
            // If left NOT to: 7 , J , |
            if (p2.y < p1.y && !(p2.content.equals("7") || p2.content.equals("J") || p2.content.equals("|")))
                return true;

            // if up NOT to: - , L , J
            if (p2.x < p1.x && !(p2.content.equals("-") || p2.content.equals("L") || p2.content.equals("J") ))
                return true;

            return false;

        }
        if (p1.content.equals("-"))
        {
            // If right NOT to: L , F , |
            if (p2.y > p1.y && !(p2.content.equals("|") || p2.content.equals("L") || p2.content.equals("F") ))
                return true;

            // If left NOT to: 7 , J , |
            if (p2.y < p1.y && !(p2.content.equals("7") || p2.content.equals("J") || p2.content.equals("|")))
                return true;

            return false;

        }
        if (p1.content.equals("|"))
        {
            // if up NOT to: - , L , J
            if (p2.x < p1.x && !(p2.content.equals("-") || p2.content.equals("L") || p2.content.equals("J") ))
                return true;
            // If down NOT to : F , 7 , -
            if (p2.x>p1.x && !(p2.content.equals("F") || p2.content.equals("7") || p2.content.equals("-") ))
                return true;

            return false;
        }
        return true;
    }
}

enum TypeOfPoint
{
    Start,End,Wall,Common;
}
