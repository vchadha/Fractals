package com.base.main;

import java.util.ArrayList;

public class PathManager {
    //Should entity be static?
    private static Entity entity;
    public static ArrayList<Line> lines;

    static {
        entity = new Entity(Util.DISPLAY_DIMENSION.width / 2, Util.DISPLAY_DIMENSION.height / 2, 50, 90, 90);
        lines = new ArrayList<>();
    }

    public static void updateEntity(String axiom) {
        //TODO: make better lol also change all these to ints not floats
        char cmd;
        for (int i = 0; i < axiom.length(); i++) {
            cmd = axiom.charAt(i);
            if (cmd == 'f') {
                //Move entity
                entity.move();
            } else if (cmd == 'F') {
                //Move and add line
                int oldX = (int) entity.getxPos();
                int oldY = (int) entity.getyPos();
                entity.move();
                lines.add(new Line(oldX, oldY, (int) entity.getxPos(), (int) entity.getyPos()));
            } else if (cmd == '+') {
                //Rotate CC
                entity.rotateCounterClockwise();
            } else {
                //Rotate C
                entity.rotateClockwise();
            }
        }
    }

    public static void reset() {
        lines.clear();
        entity.setxPos(Util.DISPLAY_DIMENSION.width / 2);
        entity.setyPos(Util.DISPLAY_DIMENSION.height / 2);
        entity.setAlpha(90);
    }

    private void addLine(int startX, int startY, int endX, int endY) {
        lines.add(new Line(startX, startY, endX, endY));
    }
}
