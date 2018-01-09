package com.base.main;

import com.base.utilities.Util;

import java.io.File;

public class Main {
    private static Display display = new Display("Fractals");

    public static void main (String[] args) {
        deleteImages();
        display.init(Util.DISPLAY_DIMENSION);
    }

    //TODO: fix this
    private static void deleteImages() {
        int iter = 0;
        File img = new File("res/AXIOM_" + iter + ".png");

        while (img.exists()) {
            img.delete();
            iter++;

            img = new File("res/AXIOM_" + iter + ".png");
        }
    }
}
