package com.base.main;

import com.base.utilities.Util;

public class Main {
    private static Display display = new Display("Fractals");

    public static void main (String[] args) {
        display.init(Util.DISPLAY_DIMENSION);
    }
}
