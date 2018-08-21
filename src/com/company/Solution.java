package com.company;

import java.util.Stack;

public class Solution implements ISolution {
    Stack<State> _solutionContent;
    Stack<State> solutionOut = new Stack<>();
    int size = 0;
    @Override
    public String GetContent() {

        String out = "";
        Stack<State> backup = (Stack<State>)_solutionContent.clone();

        State<Point> currentPoint = _solutionContent.pop();
        while (currentPoint!=null)
        {
            solutionOut.add(currentPoint);
            currentPoint = currentPoint.getParent();
        }

        try {
            int indexCount = 0;
            while (!solutionOut.isEmpty())
            {

// S-G
                State current = solutionOut.pop();
                Point a = (Point)current.state;
                //out = out + a.numOfTurns; IF ELI
                if (!a.content.equals("g"))
                {
                    out = out + a.numOfTurns;

                }
                else if (a.content.equals("g"))
                    out = out + "1";

                indexCount++;
                if (indexCount == size)
                {
                    out = out + "\n";
                    break;
                }
                else
                {
                    out = out + ",";
                }

            }
        } catch (ClassCastException e) {
            return null;
        }
        _solutionContent = backup;
        out = out.substring(0,out.length()-1);
        return out;
    }

    public Solution(int size)
    {
        this.size = size;
        this._solutionContent = new Stack<>();
    }
    public void add_solutionContent(State content) {
        _solutionContent.push(content);
    }

    /**
     *
     * @return
     */
    /*@Override
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
*/

    @Override
    public byte[] toOutPutStreamAsBytes() {
        return PTMUtils.convertStringToBytes(GetContent());
    }
}
