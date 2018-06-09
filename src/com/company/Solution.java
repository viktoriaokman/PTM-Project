package com.company;

public class Solution implements ISolution {
    String _solutionName = "";
    String _solutionContent = "";
    String _delimiter = "";


    /// CHECK LATER
    public Solution(ISolution solutionToSave) {

    }

    public void set_delimiter(String _delimiter) {
        this._delimiter = _delimiter;
    }

    public void set_solutionName(String _solutionName) {
        this._solutionName = _solutionName;
    }

    public void set_solutionContent(String _solutionContent) {
        this._solutionContent = _solutionContent;
    }

    public Solution(String name, String content, String delimiter) {
        if (content != null) set_solutionContent(content);
        if (name != null) set_solutionName(name);
        if (delimiter != null) set_delimiter(delimiter);
    }

    @Override
    public String GetContent() {
        return _solutionContent;
    }

    // TODO: Check from igor if can use IOUtils
    @Override
    public byte[] toOutPutStream() {
        return new byte[0];
    }
}
