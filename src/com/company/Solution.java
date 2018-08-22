package com.company;

import java.util.Stack;

public class Solution implements ISolution {
    Stack<State> _solutionContent;
    Stack<State> solutionOut = new Stack<>();
    int size = 0;
    int numOfRows = 0;
    String finalOut = "";
    String[] solutionlines = new String[]{};
    int replyLine = 0;
    public int numberOfLineInSolution()
    {
        return  solutionlines.length;
    }
    public String GetAllContent()
    {
        Stack<State> backup = (Stack<State>)_solutionContent.clone();
        Stack<State> helper =  new Stack<>();

        State<Point> currentPoint = _solutionContent.pop();
        while (currentPoint!=null)
        {
            helper.add(currentPoint);
            currentPoint = currentPoint.getParent();
        }
        _solutionContent = backup;

        State<Point> current = helper.pop();
        for (int i = 0; i < numOfRows ; i ++) {
            for (int j = 0; j < size; j++) {
                if (current.state.x == i && current.state.y == j) {
                    Point a = (Point)current.state;
                    //out = out + a.numOfTurns; IF ELI
                    if (!a.content.equals("g"))
                    {
                        finalOut = finalOut+ a.numOfTurns;

                    }
                    else if (a.content.equals("g"))
                        finalOut = finalOut+ "1";

                    if (!helper.isEmpty())
                        current = helper.pop();
                }
                else
                {
                    finalOut = finalOut + "0";
                }
                if (j < size-1)
                finalOut += ",";
            }
            if (i < numOfRows-1)
                finalOut+="\n";
        }

        String temp = new String();
        temp = finalOut;
        String[] s = temp.split("\n").clone();
        solutionlines = s.clone();
        //if (s[temp.split("\n").length-1].length()%(size*2 - 1)==0)

       return finalOut;
    }

    @Override
    public String GetContent() {
        String reply = solutionlines[replyLine];
        replyLine++;
        return reply;
    }

    public Solution(int size,int numOfRows)
    {
        this.size = size;
        this.numOfRows = numOfRows;
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
