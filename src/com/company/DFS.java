package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class DFS implements ISearcher {
    int _nodesEvaluated = 0;
    Solution dfs_solution;
    State<Point> destination;
    State<Point> source;

    @Override
    public Solution search(ISearchable problem) {
        dfs_solution = new Solution(problem.getSize());

        destination = problem.getGoalState();
        source = problem.getInitialState();
        Stack<State> graph=new  Stack<State>();
        graph.add(source);
        source.state.visited=true;
        while (!graph.isEmpty())
        {
            State<Point> node=graph.pop();
            if (node.state.content.equals(destination.state.content)) {
                dfs_solution.add_solutionContent(node);
                _nodesEvaluated++;
                return dfs_solution;
            }
            ArrayList<State> neighbours=problem.getAllPossibleStates(node);
            //State<Point> lastParent = node;
            for (int i = 0; i < neighbours.size(); i++) {
                State<Point> n=neighbours.get(i);
                if(n!=null && !n.state.visited)
                {
                    n.setCameFrom(node);
                    //lastParent = n;
                    _nodesEvaluated++;
                    if (n.state.content.equals(destination.state.content))
                    {
                        dfs_solution.add_solutionContent(n);

                        /*State current = n;
                        while (current != null)
                        {
                            dfs_solution.add_solutionContent(current);
                            current = current.getParent();
                        }*/
                        return dfs_solution;
                    }
                    graph.add(n);
                    n.state.visited=true;
                    //neighbours.addAll(problem.getAllPossibleStates(n));
                    graph.addAll(problem.getAllPossibleStates(n));

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