package com.komputer;

public interface BoardBuilder{
    void createBoard();
    void fillBoard(char col, int x, int y, int prior);
    void makeBorders();
    void chooseColor(int x, int y, boolean hor);
    void showBoard();
}
