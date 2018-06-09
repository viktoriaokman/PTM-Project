package com.company;

public interface ISolver {
    ISolution solve(IProblem problem);
    String createProblem();
}
