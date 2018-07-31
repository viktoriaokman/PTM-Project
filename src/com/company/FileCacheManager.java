package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCacheManager extends CacheManager {

    FileWriter fileWriter;

    public FileCacheManager() {
        try {
            fileWriter = new FileWriter("solutions.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param problemAsID    - saved as key in solutions.txt
     * @param solutionToSave - saves as plain text, format ahead if needed!
     */
    @Override
    public void save(IProblem problemAsID, ISolution solutionToSave) {
        String line = String.format("#Problem:%1$s #Solution:%2$s ",problemAsID.GetProblemContent(),solutionToSave.GetContent());
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write(line); // Make sure this is with delimiters or something..
        printWriter.close();
        super.save(problemAsID, solutionToSave); //dictionary.put()
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
