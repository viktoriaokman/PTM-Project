package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class BenchmarkAlgos {

    int boardSizeToTest = 10;
    int sizeIterator = 10;
    int maxSizeToTest = 100;
    DFS d = new DFS();
    BFS b = new BFS();
    AStar a = new AStar();
    GBFS g = new GBFS();
    HillClimb h = new HillClimb();

    public BenchmarkAlgos()
    {

    }

    public ArrayList<AlgoTimeData> GetAlgoGraph (ISearchable problem)
    {
        ArrayList<AlgoTimeData> graph = new ArrayList<>();
        for (int currentSize = boardSizeToTest;currentSize <= maxSizeToTest;currentSize+=sizeIterator)
        {
            graph.add(new AlgoTimeData(d,TestAlgo(d,currentSize,problem),currentSize));
            graph.add(new AlgoTimeData(b,TestAlgo(b,currentSize,problem),currentSize));
            graph.add(new AlgoTimeData(h,TestAlgo(h,currentSize,problem),currentSize));
            graph.add(new AlgoTimeData(a,TestAlgo(a,currentSize,problem),currentSize));
            graph.add(new AlgoTimeData(g,TestAlgo(g,currentSize,problem),currentSize));
        }
        return graph;
    }
    public ISearcher GetBestAlgo(int sizeOfBoard,ISearchable problem)
    {
        Map<ISearcher,Long> algoTime = new HashMap<ISearcher, Long>();

        algoTime.put(new DFS(),TestAlgo(new DFS(),sizeOfBoard,problem));
        algoTime.put(new BFS(),TestAlgo(new BFS(),sizeOfBoard,problem));
        algoTime.put(new GBFS(),TestAlgo(new GBFS(),sizeOfBoard,problem));
        algoTime.put(new HillClimb(),TestAlgo(new HillClimb(),sizeOfBoard,problem));
        algoTime.put(new AStar(),TestAlgo(new AStar(),sizeOfBoard,problem));

        Map.Entry<ISearcher, Long> min = null;
        for (Map.Entry<ISearcher, Long> entry : algoTime.entrySet()) {
            if (min == null || min.getValue() > entry.getValue()) {
                min = entry;
            }
        }

        return min.getKey();
    }
    public long TestAlgo(ISearcher algoToTest,int sizeOfBoard,ISearchable problem)
    {
        long startTime = System.nanoTime();
        algoToTest.search(problem);
        long stopTime = System.nanoTime();
        return stopTime - startTime;
    }
}
