package com.komputer;
import java.util.LinkedList;

public interface Command{
    void execute(LinkedList<String> commandLines);
    void undo(LinkedList<String> commandLines);
    int getExecutionsNumber();
}
