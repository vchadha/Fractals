package com.base.assets;

public class Image {
    private java.awt.Image image;
    private float xPos;
    private float yPos;
    private float width;
    private float height;

    public Image(java.awt.Image image, float xPos, float yPos, float width, float height) {
        this.image = image;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public java.awt.Image getImage() {
        return image;
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}

