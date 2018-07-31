package com.company;

import java.util.ArrayList;
import java.util.LinkedList;


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
        LinkedList<State> tempRoute = new LinkedList<State>();
        LinkedList<State> bestRoute = new LinkedList<State>();
        tempRoute.add(source);
        while (currentIter < maxIters)
        {
            ArrayList<State> adjNodes = problem.getAllPossibleStates(currentNode);
            for (State adjNode : adjNodes)
            {
                if (adjNode.getTotalDistance() <= currentNode.getTotalDistance()){
                    currentNode = adjNode;
                    currentIter = 0;
                    tempRoute.add(adjNode);
                }
                else {
                    currentIter++;
                }
                _nodesEvaluated++;
            }
            if(bestRoute.isEmpty() || tempRoute.getLast().getTotalDistance() <= bestRoute.getLast().getTotalDistance())
            {
                bestRoute.clear();
                bestRoute =(LinkedList<State>) tempRoute.clone();
                tempRoute.clear();
                tempRoute.add(source);
            }
        }
        for (int i = 0; i <= bestRoute.size(); i++)
        {
            HC_solution.add_solutionContent(bestRoute.get(i));
        }
        return HC_solution;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return _nodesEvaluated;
    }
}
