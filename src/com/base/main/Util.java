package com.base.main;

import java.awt.*;

public class Util {
    public static final int PADDING = 20;
    public static final int Y_OFFSET = 30;

    public static final Dimension DISPLAY_DIMENSION = new Dimension(800, 800);

    public static final Dimension START_BUTTON_DIMENSION = new Dimension(75, 30);
    public static final Point START_BUTTON_POSITION = new Point(DISPLAY_DIMENSION.width - (START_BUTTON_DIMENSION.width + PADDING),
            DISPLAY_DIMENSION.height - (PADDING + START_BUTTON_DIMENSION.height + Y_OFFSET));

    public static final Dimension AXIOM_TEXT_DIMENSION = new Dimension(100, 20);
    public static final Point AXIOM_TEXT_POSITION = new Point(PADDING, DISPLAY_DIMENSION.height - (PADDING + AXIOM_TEXT_DIMENSION.height + Y_OFFSET));
}
