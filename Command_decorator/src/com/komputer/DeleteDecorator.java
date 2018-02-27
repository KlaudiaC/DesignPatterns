package com.komputer;

import java.util.LinkedList;

public class DeleteDecorator implements Command{
    private Delete delete;
    private int executionsNumber;

    DeleteDecorator(int n){
        delete = new Delete();
        executionsNumber = n;
    }

    @Override
    public void execute(LinkedList<String> commandLines){
        delete.execute(commandLines);
        executionsNumber++;
    }

    @Override
    public void undo(LinkedList<String> commandLines){
        delete.execute(commandLines);
        executionsNumber--;
    }

    @Override
    public int getExecutionsNumber(){
        return executionsNumber;
    }
}
