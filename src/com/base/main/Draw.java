package com.base.main;

import com.base.assets.Line;

import java.awt.Color;
import java.awt.Graphics;

public class Draw extends Display {

    protected static void draw(Graphics g) {
        g.setColor(Color.RED);

        for (Line line : PathManager.lines) {
            g.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
        }
    }
}
