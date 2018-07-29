package com.company;

import java.util.ArrayList;

public class SearchableBoard implements ISearchable {
    GameBoard board;

    @Override
    public State getInitialState() {
        return new State(board.getStart());
    }

    @Override
    public State getGoalState() {
        return new State(board.getEnd());
    }

    @Override
    public ArrayList<State<Point>> getAllPossibleStates(State s) {
        State<Point> Current = s;
        ArrayList<State<Point>> list = new ArrayList<>();
        ArrayList<Point> allPoint = board.getAllAdj(Current.state.x,Current.state.y);
        for (int i = 0 ; i < allPoint.size();i++)
        {
            State<Point> SP = new State<Point>(allPoint.get(i));
            list.add(SP);
        }
        return list;
    }
}