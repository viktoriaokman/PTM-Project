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


    @Override
    public byte[] toOutPutStreamAsBytes() {
        return PTMUtils.convertStringToBytes(GetContent());
    }
}
