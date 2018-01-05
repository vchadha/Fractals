package com.base.main;

import com.base.assets.Entity;
import com.base.assets.Line;
import com.base.utilities.Util;

import java.util.ArrayList;
import java.util.HashMap;

class PathManager {
    private static Entity entity;
    private static int iteration;
    private static int currIter;
    private static ArrayList<String> axioms;
    static ArrayList<Line> lines;

    static {
        entity = new Entity(Util.DEFAULT_ENTITY_POSITION.x, Util.DEFAULT_ENTITY_POSITION.y,
                Util.ENTITY_STEP, Util.ENTITY_ANGLE, Util.ENTITY_DELTA);
        axioms = new ArrayList<>();
        lines = new ArrayList<>();
        currIter = 0;
    }

    static void updateEntity(String axiom, String iteration_Str, int startAngle, int delta) {
        entity.setAlpha(startAngle);
        entity.setDelta(delta);

        iteration = Integer.parseInt(iteration_Str);
        axioms.add(axiom);

        move(axiom);
    }

    static void next(HashMap productions) {
        if (currIter >= iteration)
            return;

        reset();
        currIter++;

        if (currIter < axioms.size()) {
            if (axioms.get(currIter) != null) {
                move(axioms.get(currIter));
                return;
            }
        }

        String axiom = updateAxiom(axioms.get(currIter - 1), productions);
        axioms.add(axiom);
        move(axiom);
    }

    static void previous() {
        if (currIter <= 0)
            return;

        reset();

        currIter--;
        move(axioms.get(currIter));
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

    static void reset() {
        lines.clear();
        entity.setXPos(Util.DISPLAY_DIMENSION.width / 2);
        entity.setYPos(Util.DISPLAY_DIMENSION.height / 2);
        entity.setAlpha(90);
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
