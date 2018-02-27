package com.komputer;

public class GraphicBoardBuilder implements BoardBuilder{
    public char[][] board;
    private int[][] priorities;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";

    @Override
    public void createBoard(){
        board = new char[8][8];
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                board[i][j] = 'r';

        priorities = new int[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                priorities[i][j] = 0;
    }

    @Override
    public void fillBoard(char color, int x, int y, int priority){
        if(priorities[x][y] < priority){
            priorities[x][y] = priority;
            board[3 * x][3 * y] = color;
            board[3 * x + 1][3 * y] = color;
            board[3 * x][3 * y + 1] = color;
            board[3 * x + 1][3 * y + 1] = color;
        }
    }

    @Override
    public void makeBorders(){
        chooseColor(0, 2, true);
        chooseColor(0, 5, true);
        chooseColor(3, 2, true);
        chooseColor(3, 5, true);
        chooseColor(6, 2, true);
        chooseColor(6, 5, true);
        chooseColor(2, 0, false);
        chooseColor(5, 0, false);
    }

    @Override
    public void chooseColor(int x, int y, boolean vert){
        char col = 'r';

        if(vert){
            if(board[x][y - 1] == 'r')
                col = 'b';
            if(board[x][y + 1] == 'b')
                col = 'g';
            board[x][y] = col;
            board[x + 1][y] = col;
        }
        else{
            for(int i = 0; i < 8; i++){
                if(board[x - 1][y] == 'r')
                    col = 'b';
                if(board[x + 1][y] == 'b')
                    col = 'g';
                board[x][i] = col;
            }
        }
    }

    @Override
    public void showBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                char color = board[i][j];
                if(color == 'r')
                    System.out.print(ANSI_RED +"◼");
                else if(color == 'b')
                    System.out.print(ANSI_BLUE +"◼");
                else
                    System.out.print(ANSI_GREEN +"◼");
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
    }
}
