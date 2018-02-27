package com.komputer;

public class Fan{
    boolean turnedOn;

    Fan(){
        turnedOn = true;
    }

    public void fanSwitch(){
        turnedOn = !turnedOn;
    }
}
