package com.company;

public interface ICacheManager {
    public void save(IProblem problemAsID, ISolution solutionToSave);
    public ISolution load(IProblem problemAsID);
    public boolean isSolutionStored(IProblem problem);
}
