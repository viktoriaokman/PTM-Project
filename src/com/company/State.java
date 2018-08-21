package com.company;

public class State<T> {
    T state;
    State parent;
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

    public State Clone()
    {
        return new State(this.state,this.value);
    }

    public double getTotalDistance() {
        double distance = 0;
        if (this.getParent() != null)
        {
            distance ++;
            this.getParent().getTotalDistance();
        }
        return distance;
    }
}
