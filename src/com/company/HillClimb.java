package com.company;

import java.util.ArrayList;

public class HillClimb implements ISearcher {
    int _nodesEvaluated = 0;
    Solution HC_solution;
    State destination;
    State source;
    @Override
    public Solution search(ISearchable problem) {
        int maxIters = 100;
        destination = problem.getGoalState();
        source = problem.getInitialState();
        State currentNode = source;
        int currentIter = 0;
        while (currentIter < maxIters)
        {
            ArrayList<State> adjNodes = problem.getAllPossibleStates(currentNode);
            for (State adjNode : adjNodes)
            {

            }
        }


        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return 0;
    }
}
