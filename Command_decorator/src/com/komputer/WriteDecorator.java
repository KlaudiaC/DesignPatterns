package com.komputer;

import java.util.LinkedList;

public class WriteDecorator implements Command{
    private Write write;
    private int executionsNumber;

    public WriteDecorator(String t, int n){
        write = new Write(t);
        executionsNumber = n;
    }

    @Override
    public void execute(LinkedList<String> commandLines){
        write.execute(commandLines);
        executionsNumber++;
    }

    @Override
    public void undo(LinkedList<String> commandLines){
        write.execute(commandLines);
        executionsNumber--;
    }

    public int getExecutionsNumber(){
        return executionsNumber;
    }
}
