package com.base.assets;

public class Entity {
    private int xPos;
    private int yPos;
    private int step;
    private int alpha;
    private int delta;

    public Entity(int xPos, int yPos, int step, int alpha, int delta) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.step = step;
        this.alpha = alpha;
        this.delta = delta;
    }

    public void move() {
        xPos -= step * (int) Math.cos(Math.toRadians(alpha));
        yPos -= step * (int) Math.sin(Math.toRadians(alpha));
    }

    public void rotateClockwise() {
        alpha += delta;
    }

    public void rotateCounterClockwise() {
        alpha -= delta;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
}
