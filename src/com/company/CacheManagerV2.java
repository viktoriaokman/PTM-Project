package com.company;

public abstract class CacheManagerV2 { // My way - SINGLE solution\problem
    private String _problem;

    public void save(String problem) {
        _problem = problem;
    }

    public String load() {
        return _problem;
    }

    public boolean isSolutionStored(String problem) {
        return _problem.isEmpty();
    }
}
