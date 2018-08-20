package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class GBFS implements ISearcher{
    int _nodesEvaluated = 0;
    Solution gbfs_solution;
    State<Point> destination;
    State<Point> source;

    @Override
    public Solution search(ISearchable problem) {
        gbfs_solution = new Solution();

        destination = problem.getGoalState();
        source = problem.getInitialState();
        Stack<State> graph=new  Stack<State>();
        graph.add(source);
        source.state.visited=true;
        while (!graph.isEmpty())
        {
            State<Point> node=graph.pop();
            if (node.state.content.equals(destination.state.content)) {
                gbfs_solution.add_solutionContent(node);
                _nodesEvaluated++;
                return gbfs_solution;
            }
            ArrayList<State<Point>> neighbours=problem.getAllPossibleStates(node);
            for (int i = 0; i < neighbours.size(); i++) {

                State<Point> n = neighbours.get(0);
                // Get "best" option out of current neighbours
                for (int index=0;index<neighbours.size();index++)
                {
                    if (neighbours.get(index).value <= n.value && !neighbours.get(index).state.visited)
                        n = neighbours.get(index);
                }
                //State<Point> n = neighbours.get(neighbours.indexOf(neighbours.stream().mapToDouble(v -> (double)v.value).min()));
                if(n!=null && !n.state.visited)
                {
                    n.setCameFrom(node);
                    _nodesEvaluated++;
                    if (n.state.content.equals(destination.state.content))
                    {
                        gbfs_solution.add_solutionContent(n);

                        /*State current = n;
                        while (current != null)
                        {
                            gbfs_solution.add_solutionContent(current);
                            current = current.getParent();
                        }*/
                        return gbfs_solution;
                    }
                    graph.add(n);
                    n.state.visited=true;
                    graph.addAll(problem.getAllPossibleStates(n));
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
