package com.company;

import java.util.ArrayList;

public interface ISearchable<T> {
    State getInitialState();
    State getGoalState();
    ArrayList<State> getAllPossibleStates(State<T> s);
    int getSize();
    int getNumOfRows();
    ISearchable<T> clone();
}