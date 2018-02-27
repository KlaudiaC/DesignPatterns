package com.komputer;
import java.util.LinkedList;

public class Delete implements Command{
    public String text;

    public Delete(){
        text = "";
    }

    @Override
    public void execute(LinkedList<String> commandLines){
        if(!commandLines.isEmpty())
            text = commandLines.removeLast();
    }

    @Override
    public void undo(LinkedList<String> commandLines){
        commandLines.add(text);
    }

    @Override
    public int getExecutionsNumber(){
        return 0;
    }
}
