package com.company;

public class State<T> {
    T state;
    State parent;
    boolean visited = false;
    double value = 1;

    public State(T state) {
        this.state = state;
    }
    public State(T state, double value) {this.state = state; this.value = value;}
    public void setCameFrom(State n) {
        parent = n;
    }

    public State getParent()
    {
        return parent;
    }

    // TODO : finish this
    public double getTotalDistance() {
        double distance = 0;
        while (this.getParent() != null)
        {

        }
        return value;
    }
}
