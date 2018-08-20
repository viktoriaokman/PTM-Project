package com.company;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ClientHandler implements IClientHandler {

    ICacheManager cacheManager;
    /*PipeGameSolver solver;*/
    ISolver solver;
    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        // Convert input to Problem
        PrintWriter out =
                new PrintWriter(outToClient, true);

        Problem problemFromUser = new Problem(inFromClient);

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
            out.println(solution.GetContent());
            out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
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
