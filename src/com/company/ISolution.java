package com.company;

public interface ISolution<T> {
    String GetContent();

    byte[] toOutPutStreamAsBytes();

    String GetAllContent();
    public int numberOfLineInSolution();
}
