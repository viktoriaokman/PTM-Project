package com.company;

public interface ISolver {
    ISolution solve(IProblem problem);
    IProblem createProblem();
}
