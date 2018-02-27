package com.komputer;

public class Main{
    public static void main(String[] args){
        System.out.println("Wersja graficzna:");
        BoardBuilding graphBuilding = new BoardBuilding(true);

        System.out.println("\nWersja ASCII:");
        BoardBuilding asciiBuilding = new BoardBuilding(false);
    }
}
