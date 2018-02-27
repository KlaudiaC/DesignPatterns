package com.komputer;
import java.util.Map;

public class BoardBuilding{
    private Map<String, Integer> data;
    private boolean graphic;
    private char color;
    private int x;
    private int y;
    private int priority;
    private BoardBuilder board;

    public BoardBuilding(boolean choose){
        data = new Parser().loadData();
        graphic = choose;

        if(graphic)
            board = new GraphicBoardBuilder();
        else
            board = new AsciiBoardBuilder();
        board.createBoard();

        for(Map.Entry<String, Integer> p: data.entrySet()){
            String key = p.getKey();
            Integer value = p.getValue();

            if(key.equals("color")){
                if(value == 1)
                    color = 'r';
                else if(value == 2)
                    color = 'b';
                else if(value == 3)
                    color = 'g';
            }
            else if(key.equals("x"))
                x = value - 1;
            else if(key.equals("y"))
                y = value - 1;
            else if(key.equals("priority")){
                priority = value;
                board.fillBoard(color, x, y, priority);
            }
        }

        board.makeBorders();
        board.showBoard();
    }
}
