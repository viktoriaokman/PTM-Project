package com.company;

import java.util.Stack;

public class Solution implements ISolution {
    String _delimiter = "";
    Stack<State> _solutionContent;

    public void add_solutionContent(State content) {
        _solutionContent.push(content);
    }

    /**
     *
     * @return
     */
    @Override
    public String GetContent() {

        String out = "";
        try {
            while (!_solutionContent.isEmpty())
            {
                out = out + _solutionContent.pop();
            }
        } catch (ClassCastException e) {
            return null;
        }
        return out;
    }
    // TODO: Convert all string imp to generics
    /*public void set_solutionContent(String _solutionContent) {
        this._solutionContent = _solutionContent;
    }*/

    /*public Solution(String content) {
        if (content != null) set_solutionContent(content);
        _delimiter = "#Solution:";
    }*/
   // @Override
    /*public String GetContent() {
        return _solutionContent;
    }*/

    @Override
    public byte[] toOutPutStreamAsBytes() {
        return PTMUtils.convertStringToBytes(GetContent());
    }
}
