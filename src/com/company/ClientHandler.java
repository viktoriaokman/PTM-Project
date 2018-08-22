package com.company;

import java.io.*;

public class ClientHandler implements IClientHandler {

    ICacheManager cacheManager;
    /*PipeGameSolver solver;*/
    ISolver solver;
    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        // Convert input to Problem
        PrintWriter out = new PrintWriter(outToClient, true);

        BufferedReader problemin = new BufferedReader(new InputStreamReader(inFromClient));
        Problem problemFromUser = new Problem(problemin);

        ISolution solution;
        if (cacheManager.isSolutionStored(problemFromUser)) {
            solution = cacheManager.load(problemFromUser);
        } else {
            solution = solver.solve(problemFromUser);
            cacheManager.save(problemFromUser,solution);
        }

        try {
            /*outToClient.write(solution.toOutPutStreamAsBytes());
            outToClient.flush();*/
            // while solution is not empty
            for (int i = 0;i < solution.numberOfLineInSolution(); i ++)
            {
                out.println(solution.GetContent());
            }
                //out.println(sol);


            out.println("done");
            // OP 1
            //out.close();
            //inFromClient.close();
            //outToClient.close();

        } catch (Exception e) {
            //e.getMessage();
        }
    }

    public ClientHandler(ICacheManager cacheManager, PipeGameSolver solver) {
        setCacheManager(cacheManager);
        setSolver(solver);
    }

    public ClientHandler()
    {
        setCacheManager(new FileCacheManager());
        setSolver(new PipeGameSolver());
    }
    public void setCacheManager(ICacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void setSolver(PipeGameSolver solver) {
        this.solver = solver;
    }
}
