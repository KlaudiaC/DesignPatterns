package com.komputer;
import java.util.LinkedList;

public class Write implements Command{
    String text;

    public Write(String t){
        text = t;
    }

    @Override
    public void execute(LinkedList<String> commandLines){
        commandLines.add(text);
    }

    @Override
    public void undo(LinkedList<String> commandLines){
        commandLines.removeLast();
    }

    @Override
    public int getExecutionsNumber(){
        return 0;
    }
}
