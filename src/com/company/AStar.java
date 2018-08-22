package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class AStar implements ISearcher
{
    int _nodesEvaluated = 0;
    @Override
    public Solution search(ISearchable problem) {
        Solution astar_solution = new Solution(problem.getSize(),problem.getNumOfRows());
        State destination= problem.getGoalState();
        State source = problem.getInitialState();
        LinkedList<State> openList = new LinkedList<>();
        LinkedList<State> closedList = new LinkedList<>();

        openList.push(source);

        while (!openList.isEmpty())
        {
            State current = openList.pop();

            if (current==destination)
            {
                astar_solution.add_solutionContent(current);
                _nodesEvaluated++;
                return astar_solution;
            }

            ArrayList<State> successors = problem.getAllPossibleStates(current);
            for(State node_successor : successors)
            {
                //find node_successor on the OPEN list
                int oFound = openList.indexOf(node_successor);

                //if node_successor is on the OPEN list but the existing one is as good
                //or better then discard this successor and continue

                if (oFound>0)
                {
                    State existing_node = openList.get(oFound);
                    if (existing_node.value <= current.value)
                    {
                        continue;
                    }
                }


                //find node_successor on the CLOSED list
                int cFound = closedList.indexOf(node_successor);

                //if node_successor is on the CLOSED list
                //but the existing one is as good
                //or better then discard this successor and continue;
                if (cFound>0)
                {
                    State existing_node = openList.get(cFound);
                    if (existing_node.value <= current.value)
                    {
                        continue;
                    }
                }

                //Remove occurences of node_successor from OPEN and CLOSED
                if (oFound!=-1)
                    openList.remove(oFound);
                if (cFound!=-1) {
                    closedList.remove(cFound);
                }

                //Set the parent of node_successor to node_current;
                //--> already set while we were getting successors

                //Set h to be the estimated distance to node_goal
                //(Using heuristic function)
                //--> already set while we were getting successors

                //Add node_successor to the OPEN list
                openList.push(node_successor);
            }
            closedList.push(current);
        }
        for(State s : closedList)
        {
            astar_solution.add_solutionContent(s);
        }
        return astar_solution;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return _nodesEvaluated;
    }
}
