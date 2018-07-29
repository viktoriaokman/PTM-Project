package com.company;

public class PipeGameSolver implements ISolver{

    ISearcher searcher;
    ISearchable searchable;

    @Override
    public ISolution solve(IProblem problem) {
        PipeGameBoard gameToSolve = new PipeGameBoard(problem.GetSize());
        BenchmarkAlgos benchmarkAlgos = new BenchmarkAlgos();
        ISearcher bestAlgo = benchmarkAlgos.GetBestAlgo(problem.GetSize(),gameToSolve);
        Solution s = bestAlgo.search(gameToSolve);
        return s;
    }

    @Override
    public IProblem createProblem() {
        return null;
    }
}
