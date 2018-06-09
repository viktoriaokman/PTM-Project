package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCacheManager extends CacheManager {
    /**
     * @param problemAsID    - saved as file name
     * @param solutionToSave - saves as plain text, format ahead if needed!
     */
    @Override
    public void save(IProblem problemAsID, ISolution solutionToSave) {
        try {
            FileWriter fileWriter = new FileWriter(problemAsID.GetName() + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(solutionToSave.GetContent()); // Make sure this is with delimiters or something..
            printWriter.close();
            super.save(problemAsID, solutionToSave);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * load problem from memory if exists
     *
     * @param problemAsID - file\problem name as identifier
     * @return - solution as String in same format it was saved or blank ("") if solution wasn't found
     */
    @Override
    public ISolution load(IProblem problemAsID) throws NullPointerException {
        if (isSolutionStored(problemAsID))
            return super.load(problemAsID);
        return null;
    }
}
