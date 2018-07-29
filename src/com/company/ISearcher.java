package com.company;

public interface ISearcher {
    public Solution search(ISearchable problem);
    public int getNumberOfNodesEvaluated();

}