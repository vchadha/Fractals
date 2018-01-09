package com.base.main;

import com.base.assets.Image;
import com.base.assets.Line;
import com.base.utilities.Util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Draw extends Display {

    static void draw(Graphics g) throws IOException {
        if (!PathManager.hasStarted())
            return;

        if (PathManager.hasImage()) {
            drawImage(g);
            return;
        }

        writeImage();
        loadImage();
        drawImage(g);
    }

    private static void writeImage() throws IOException {
        int shiftX = PathManager.getXMin() - Util.PADDING;
        int shiftY = PathManager.getYMin() - Util.PADDING;

        BufferedImage bi = new BufferedImage(PathManager.getXDist() + 2 * Util.PADDING,
                PathManager.getYDist() + 2 * Util.PADDING, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bi.createGraphics();

        g2d.setBackground(Color.BLACK);
        g2d.setColor(Color.RED);

        for (Line line : PathManager.lines) {
            g2d.drawLine(line.getStartX() - shiftX, line.getStartY() - shiftY,
                    line.getEndX() - shiftX, line.getEndY() - shiftY);
        }

        ImageIO.write(bi, "PNG", new File("res/AXIOM_" + PathManager.getCurrIter() + turns + ".png"));
    }

    private static void loadImage() {
        ImageIcon imageIcon = new ImageIcon("res/Axiom_" + PathManager.getCurrIter() + turns + ".png");

        float imgWidth = imageIcon.getIconWidth();
        float imgHeight = imageIcon.getIconHeight();
        float ratio;

        if (imgWidth > imgHeight)
            ratio = Util.DISPLAY_DIMENSION.width / imgWidth;
        else
            ratio = Util.DISPLAY_DIMENSION.height / imgHeight;

        imgWidth *= ratio;
        imgHeight *= ratio;

        PathManager.images.add(new Image(imageIcon.getImage(), (Util.DISPLAY_DIMENSION.width - imgWidth) / 2,
                (Util.DISPLAY_DIMENSION.height - imgHeight) / 2, imgWidth, imgHeight));
    }

    private static void drawImage(Graphics g) {
        Image image = PathManager.images.get(PathManager.getCurrIter());
        g.drawImage(image.getImage(), (int) image.getxPos(), (int) image.getyPos(),
                (int) image.getWidth(), (int) image.getHeight(), null);
    }
}
