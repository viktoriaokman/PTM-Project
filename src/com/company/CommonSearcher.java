package com.company;

import java.util.PriorityQueue;

// TODO : Remove if not needed
public abstract class CommonSearcher implements ISearcher {
    protected PriorityQueue<State> openList;
    private int evaluatedNodes;

    public CommonSearcher() {
        openList = new PriorityQueue<>();
        evaluatedNodes = 0;
    }

    protected State popOpenList() { // TODO : change name to something logical ffs..
        evaluatedNodes++;
        return openList.poll();
    }

    protected void addToOpenList(State state) {
        openList.add(state);
    }
}


