package com.base.assets;

import com.base.utilities.Util;

public class Entity {
    private int xPos;
    private int yPos;

    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    private int step;
    private int alpha;
    private int delta;

    public Entity(int xPos, int yPos, int step, int alpha, int delta) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.step = step;
        this.alpha = alpha;
        this.delta = delta;

        xMin = xPos;
        xMax = xPos;
        yMin = yPos;
        yMax = yPos;
    }

    public void move() {
        xPos -= step * (int) Math.cos(Math.toRadians(alpha));
        yPos -= step * (int) Math.sin(Math.toRadians(alpha));

        if (xPos < xMin)
            xMin = xPos;

        if (xPos > xMax)
            xMax = xPos;

        if (yPos < yMin)
            yMin = yPos;

        if (yPos > yMax)
            yMax = yPos;
    }

    public void rotateClockwise() {
        alpha += delta;
    }

    public void rotateCounterClockwise() {
        alpha -= delta;
    }

    public void resetDist() {
        xMax = Util.DEFAULT_ENTITY_POSITION.x;
        xMin = Util.DEFAULT_ENTITY_POSITION.x;

        yMax = Util.DEFAULT_ENTITY_POSITION.y;
        yMin = Util.DEFAULT_ENTITY_POSITION.y;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public int getXDist() {
        return xMax - xMin;
    }

    public int getYDist() {
        return yMax - yMin;
    }

    public int getXMin() {
        return xMin;
    }

    public int getYMin() {
        return yMin;
    }
}
