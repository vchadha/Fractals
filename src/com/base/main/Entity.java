package com.base.main;

public class Entity {
    private float xPos;
    private float yPos;
    private float step;
    private float alpha;
    private float delta;

    public Entity() { }

    public Entity(float xPos, float yPos, float step, float alpha, float delta) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.step = step;
        this.alpha = alpha;
        this.delta = delta;
    }

    public void move() {
        xPos += step * Math.cos(Math.toRadians(alpha));
        yPos += step * Math.sin(Math.toRadians(alpha));
    }

    public void rotateClockwise() {
        alpha -= delta;
    }

    public void rotateCounterClockwise() {
        alpha += delta;
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public float getStep() {
        return step;
    }

    public void setStep(float step) {
        this.step = step;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getDelta() {
        return delta;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }
}
