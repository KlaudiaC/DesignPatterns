package com.komputer;
import java.util.LinkedList;
import java.util.Scanner;

public class TextEditor{
    private Command command;
    private String undo;
    private String redo;
    private LinkedList<String> commands;
    private Scanner scan;
    private int allExecutions;

    public TextEditor(){
        undo = "";
        redo = "";
        commands = new LinkedList<>();
        scan = new Scanner(System.in);
        allExecutions = 0;
    }

    public void action(){
        boolean turnOff = false;

        while(!turnOff){
            String text = scan.next();

            switch(text){
                case "write":
                    // command = new Write(text);
                    command = new WriteDecorator(text, allExecutions);
                    command.execute(commands);
                    undo = command.toString();
                    allExecutions = command.getExecutionsNumber();
                    break;

                case "delete":
                    // command = new Delete();
                    command = new DeleteDecorator(allExecutions);
                    if(!commands.isEmpty()){
                        command.execute(commands);
                        undo = command.toString();
                        allExecutions = command.getExecutionsNumber();
                    }
                    break;

                case "undo":
                    if(!undo.equals("")){
                        if(undo.equals("write"))
                            // command = new Write(undo);
                            command = new WriteDecorator(text, allExecutions);
                        else
                            // command = new Delete();
                            command = new DeleteDecorator(allExecutions);
                        command.undo(commands);
                        redo = command.toString();
                        allExecutions = command.getExecutionsNumber();
                    }
                    break;

                case "redo":
                    if(!redo.equals("")){
                        if(redo.equals("write"))
                            // command = new Write(redo);
                            command = new WriteDecorator(text, allExecutions);
                        else
                            // command = new Delete();
                            command = new DeleteDecorator(allExecutions);
                        command.undo(commands);
                        undo = command.toString();
                        allExecutions = command.getExecutionsNumber();
                    }
                    break;

                case "exit":
                    turnOff = true;
                    System.out.println(allExecutions);
                    break;
            }
        }
    }
}
