package com.company;

import java.util.Stack;

public class Solution implements ISolution {
    String _delimiter = "";
    Stack<State> _solutionContent;

    public Solution()
    {
        this._solutionContent = new Stack<>();
    }
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
        Stack<State> backup = (Stack<State>)_solutionContent.clone();
        try {
            while (!_solutionContent.isEmpty())
            {
                State current = _solutionContent.pop();
                Point a = (Point)current.state;
                out =  a.content + out;
                while (current.getParent() != null)
                {
                    current = current.getParent();
                    a = (Point)current.state;
                    out =  a.content + out;
                }
            }
        } catch (ClassCastException e) {
            return null;
        }
        _solutionContent = backup;
        return out;
    }


    @Override
    public byte[] toOutPutStreamAsBytes() {
        return PTMUtils.convertStringToBytes(GetContent());
    }
}
