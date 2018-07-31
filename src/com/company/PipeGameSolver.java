package com.company;

public class PipeGameSolver implements ISolver{

    ISearcher searcher;
    ISearchable searchable;

    @Override
    public ISolution solve(IProblem problem) {
        PipeGameBoard gameToSolve = new PipeGameBoard(problem);
        BenchmarkAlgos benchmarkAlgos = new BenchmarkAlgos();
        searcher = benchmarkAlgos.GetBestAlgo(problem.GetSize(),gameToSolve);
        Solution s = searcher.search(gameToSolve);
        return s;
    }

    @Override
    public IProblem createProblem() {

        return null;
    }
}
