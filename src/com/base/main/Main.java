package com.base.main;

public class Main {
    private static Display display = new Display("FractalANN");

    public static void main (String[] args) {
        display.init(Util.DISPLAY_DIMENSION);
    }
}
