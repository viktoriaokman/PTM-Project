package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ClientHandler implements IClientHandler {

    ICacheManager cacheManager;
    ISolver solver;
    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        // Convert input to Problem
        Problem problemFromUser = new Problem(inFromClient);
        ISolution solution;
        if (cacheManager.isSolutionStored(problemFromUser)) {
            solution = cacheManager.load(problemFromUser);
        } else {
            solution = solver.solve(problemFromUser);
            cacheManager.save(problemFromUser,solution);
        }

        try {
            outToClient.write(solution.toOutPutStreamAsBytes());
            outToClient.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientHandler(ICacheManager cacheManager, ISolver solver) {
        setCacheManager(cacheManager);
        setSolver(solver);
    }

    public void setCacheManager(ICacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void setSolver(ISolver solver) {
        this.solver = solver;
    }
}
