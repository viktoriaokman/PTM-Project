package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class DFS implements ISearcher {
    int _nodesEvaluated = 0;
    Solution dfs_solution;
    State destination;
    State source;

    @Override
    public Solution search(ISearchable problem) {
        dfs_solution = new Solution();

        destination = problem.getGoalState();
        source = problem.getInitialState();
        Stack<State> graph=new  Stack<State>();
        graph.add(source);
        source.visited=true;
        while (!graph.isEmpty())
        {
            State node=graph.pop();
            if (node == destination) {
                dfs_solution.add_solutionContent(node);
                _nodesEvaluated++;
                return dfs_solution;
            }
            ArrayList<State> neighbours=problem.getAllPossibleStates(node);
            for (int i = 0; i < neighbours.size(); i++) {
                State n=neighbours.get(i);
                if(n!=null && !n.visited)
                {
                    n.setCameFrom(node);
                    _nodesEvaluated++;
                    if (n == destination)
                    {
                        State current = destination;
                        while (current != null)
                        {
                            dfs_solution.add_solutionContent(current);
                            current.getParent();
                        }
                        return dfs_solution;
                    }
                    graph.add(n);
                    n.visited=true;
                }
            }
        }
        return dfs_solution;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return _nodesEvaluated;
    }
}