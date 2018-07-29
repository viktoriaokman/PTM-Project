package com.company;

public class Point<T> {
    int x;
    int y;
    T content;
    TypeOfPoint typeOfPoint;

    public Point(int x,int y,T content,TypeOfPoint typeOfPoint)
    {
        this.x = x;
        this.y = y;
        this.typeOfPoint = typeOfPoint;
        this.content = content;
    }

    public TypeOfPoint GetPointType()
    {
        return typeOfPoint;
    }

}

enum TypeOfPoint
{
    Start,End,Wall,Common;
}
