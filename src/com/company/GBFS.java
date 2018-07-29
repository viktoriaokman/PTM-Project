package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class GBFS implements ISearcher{
    int _nodesEvaluated = 0;
    Solution gbfs_solution;
    State destination;
    State source;

    @Override
    public Solution search(ISearchable problem) {
        gbfs_solution = new Solution();

        destination = problem.getGoalState();
        source = problem.getInitialState();
        Stack<State> graph=new  Stack<State>();
        graph.add(source);
        source.visited=true;
        while (!graph.isEmpty())
        {
            State node=graph.pop();
            if (node == destination) {
                gbfs_solution.add_solutionContent(node);
                _nodesEvaluated++;
                return gbfs_solution;
            }
            ArrayList<State> neighbours=problem.getAllPossibleStates(node);
            for (int i = 0; i < neighbours.size(); i++) {

                // Get "best" option out of current neineighbours
                State n = neighbours.get(neighbours.indexOf(neighbours.stream().mapToDouble(v -> (double)v.value).min()));
                if(n!=null && !n.visited)
                {
                    n.setCameFrom(node);
                    _nodesEvaluated++;
                    if (n == destination)
                    {
                        State current = destination;
                        while (current != null)
                        {
                            gbfs_solution.add_solutionContent(current);
                            current.getParent();
                        }
                        return gbfs_solution;
                    }
                    graph.add(n);
                    n.visited=true;
                }
            }
        }
        return gbfs_solution;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return _nodesEvaluated;
    }
}
