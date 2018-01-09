package com.base.main;

import com.base.assets.Entity;
import com.base.assets.Line;
import com.base.utilities.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class PathManager {
    private static Entity entity;
    private static int iteration;
    private static int currIter;
    private static int angle;
    //TODO: do i need these bools?
    private static boolean imgExists;
    private static boolean started;
    private static String currAxiom;
    static ArrayList<Line> lines;
    static ArrayList<com.base.assets.Image> images;

    static {
        entity = new Entity(Util.DEFAULT_ENTITY_POSITION.x, Util.DEFAULT_ENTITY_POSITION.y,
                Util.ENTITY_STEP, Util.ENTITY_ANGLE, Util.ENTITY_DELTA);
        currAxiom = "";
        lines = new ArrayList<>();
        images = new ArrayList<>();
        currIter = 0;
        imgExists = false;
        started = false;
    }

    static void updateEntity(String axiom, String iteration_Str, int startAngle, int delta) {
        angle = startAngle;
        entity.setAlpha(startAngle);
        entity.setDelta(delta);

        iteration = Integer.parseInt(iteration_Str);
        currAxiom = axiom;

        move(axiom);

        started = true;
    }

    static void next(HashMap productions) {
        if (currIter >= iteration)
            return;

        started = true;
        resetEntity();
        currIter++;

        File img = new File("res/AXIOM_" + currIter + ".png");
        if (!img.exists()) {
            currAxiom = updateAxiom(currAxiom, productions);
            move(currAxiom);
            imgExists = false;
            return;
        }

        imgExists = true;
    }

    static void previous() {
        if (currIter <= 0)
            return;

        resetEntity();

        currIter--;
        imgExists = true;
        started = true;
    }

    static void reset() {
        currAxiom = "";
        currIter = 0;

        resetEntity();
    }

    static int getCurrIter() {
        return currIter;
    }

    static int getXDist() {
        return entity.getXDist();
    }

    static int getYDist() {
        return entity.getYDist();
    }

    static int getXMin() {
        return entity.getXMin();
    }

    static int getYMin() {
        return entity.getYMin();
    }

    static boolean hasImage() {
        return imgExists;
    }

    static boolean hasStarted() {
        return started;
    }

    private static void move(String axiom) {
        char cmd;
        for (int i = 0; i < axiom.length(); i++) {
            cmd = axiom.charAt(i);
            if (cmd == 'f') {
                //Move entity
                entity.move();
            } else if (cmd == 'F') {
                //Move and add line
                int oldX = entity.getXPos();
                int oldY = entity.getYPos();
                entity.move();
                lines.add(new Line(oldX, oldY, entity.getXPos(), entity.getYPos()));
            } else if (cmd == '+') {
                //Rotate CC
                entity.rotateCounterClockwise();
            } else {
                //Rotate C
                entity.rotateClockwise();
            }
        }
    }

    private static void resetEntity() {
        lines.clear();

        entity.setXPos(Util.DEFAULT_ENTITY_POSITION.x);
        entity.setYPos(Util.DEFAULT_ENTITY_POSITION.y);
        entity.setAlpha(angle);
        entity.resetDist();
    }

    private static String updateAxiom(String axiom, HashMap productions) {
        StringBuilder builder = new StringBuilder();

        char cmd;
        for (int i = 0; i < axiom.length(); i++) {
            cmd = axiom.charAt(i);
            if (cmd == 'F') {
                builder.append(productions.get("F"));
            } else if (cmd == 'f') {
                builder.append(productions.get("f"));
            } else if (cmd == '+') {
                builder.append(productions.get("+"));
            } else {
                builder.append(productions.get("-"));
            }
        }

        return builder.toString();
    }
}
