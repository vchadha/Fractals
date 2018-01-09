package com.base.main;

import com.base.utilities.Util;

import java.io.File;

public class Main {
    private static Display display = new Display("Fractals");

    public static void main (String[] args) {
        File dir = new File("res/");
        deleteImages(dir);

        display.init(Util.DISPLAY_DIMENSION);
    }

    public static void deleteImages(File dir) {
        for(File file: dir.listFiles())
            if (!file.isDirectory())
                file.delete();
    }
}
