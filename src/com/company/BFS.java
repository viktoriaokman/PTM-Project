package com.company;

import java.util.LinkedList;
import java.util.List;

public class BFS  implements ISearcher{
    int _nodesEvaluated = 0;
    Solution bfs_solution;

    @Override
    public Solution search(ISearchable problem) {
        bfs_solution = new Solution();
        State source = problem.getInitialState();
        State destination = problem.getGoalState();

        LinkedList<State> queue = new LinkedList<State>();
        queue.add(source);
        source.visited = true;
        while (!queue.isEmpty())
        {
            State element = queue.remove();
            List<State> neighbours= problem.getAllPossibleStates(element);
            for (int i = 0; i < neighbours.size(); i++) {
                State n=neighbours.get(i);
                if(n!=null && !n.visited)
                {
                    _nodesEvaluated++;
                    if (n == destination)
                    {
                        State current = destination;
                        while (current != null)
                        {
                            bfs_solution.add_solutionContent(current);
                            current.getParent();
                        }
                        return bfs_solution;
                    }
                    queue.add(n);
                    n.visited=true;
                }
            }
        }
        return bfs_solution;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return _nodesEvaluated;
    }
}
