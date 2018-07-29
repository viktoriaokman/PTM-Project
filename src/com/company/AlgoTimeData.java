package com.company;

public class AlgoTimeData {
    ISearcher AlgoName;
    long AlgoTime;
    int SizeOfBoard;

    public AlgoTimeData(ISearcher algoName,long algoTime,int sizeOfBoard)
    {
        this.AlgoName = algoName;
        this.AlgoTime = algoTime;
        this.SizeOfBoard = sizeOfBoard;
    }
}
