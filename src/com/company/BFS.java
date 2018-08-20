package com.company;

import java.util.LinkedList;
import java.util.List;

public class BFS  implements ISearcher{
    int _nodesEvaluated = 0;
    Solution bfs_solution;

    @Override
    public Solution search(ISearchable problem) {
        bfs_solution = new Solution();
        State<Point> source = problem.getInitialState();
        State<Point> destination = problem.getGoalState();

        // TODO : improve - make sure this has only unique states!!
        LinkedList<State> queue = new LinkedList<State>();
        queue.add(source);
        source.state.visited = true;
        while (!queue.isEmpty())
        {
            State<Point> element = queue.remove();

            // Moshe adding from DFS
            if (element.state.content.equals(destination.state.content)) {
                bfs_solution.add_solutionContent(element);
                _nodesEvaluated++;
                return bfs_solution;
            }

            List<State> neighbours= problem.getAllPossibleStates(element);
            for (int i = 0; i < neighbours.size(); i++) {
                State<Point> n=neighbours.get(i);
                if(n!=null && !n.state.visited)
                {
                    n.setCameFrom(element); // M
                    _nodesEvaluated++;
                    if (n.state.content.equals(destination.state.content))
                    {
                        bfs_solution.add_solutionContent(n);
                        return bfs_solution;
                        /*State<Point> current = n;
                        while (current != null)
                        {
                            bfs_solution.add_solutionContent(current);
                            current = current.getParent();
                        }
                        return bfs_solution;*/
                    }
                    queue.add(n);
                    n.state.visited=true;
                    queue.addAll(problem.getAllPossibleStates(n));
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
