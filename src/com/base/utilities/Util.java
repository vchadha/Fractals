package com.base.utilities;

import java.awt.Dimension;
import java.awt.Point;

public class Util {
    static final String DOCUMENT_FILTER = "Ff-+";
    static final String DIGITS = "0123456789";

    private static final int PADDING = 20;
    private static final int Y_OFFSET = 30;

    public static final Dimension DISPLAY_DIMENSION = new Dimension(800, 800);
    public static final Dimension STANDARD_BUTTON_DIMENSION = new Dimension(100, 30);
    public static final Dimension TEXT_DIMENSION = new Dimension(100, 20);
    public static final Dimension ENTITY_DIMENSION = new Dimension(130, 20);
    public static final Dimension TRAVERSE_BUTTON_DIMENSION = new Dimension(45, 30);

    public static final Point RESET_BUTTON_POSITION = new Point(DISPLAY_DIMENSION.width -
            (STANDARD_BUTTON_DIMENSION.width + PADDING), PADDING * 2 + TEXT_DIMENSION.height);

    public static final Point EDIT_BUTTON_POSITION = new Point(RESET_BUTTON_POSITION.x, RESET_BUTTON_POSITION.y + PADDING * 2);

    public static final Point START_BUTTON_POSITION = new Point(DISPLAY_DIMENSION.width -
            (STANDARD_BUTTON_DIMENSION.width + PADDING),DISPLAY_DIMENSION.height -
            (PADDING + STANDARD_BUTTON_DIMENSION.height + Y_OFFSET));

    public static final Point NEXT_BUTTON_POSITION = new Point(START_BUTTON_POSITION.x +
            STANDARD_BUTTON_DIMENSION.width - 45, START_BUTTON_POSITION.y);

    public static final Point PREVIOUS_BUTTON_POSITION = new Point(START_BUTTON_POSITION.x, START_BUTTON_POSITION.y);

    public static final Point HIDDEN_BUTTON_POSITION = new Point(DISPLAY_DIMENSION.width -
            (TEXT_DIMENSION.width + PADDING), PADDING);

    public static final Point AXIOM_TEXT_POSITION = new Point(PADDING, DISPLAY_DIMENSION.height -
            (PADDING + TEXT_DIMENSION.height + Y_OFFSET));

    public static final Point ITERATION_POSITION = new Point(AXIOM_TEXT_POSITION.x,
            AXIOM_TEXT_POSITION.y - (PADDING + TEXT_DIMENSION.height));

    public static final Point PRODUCTION_F_UPPER_POSITION = new Point(PADDING, PADDING);
    public static final Point PRODUCTION_F_LOWER_POSITION = new Point(PADDING, PADDING + 30);
    public static final Point PRODUCTION_MINUS_POSITION = new Point(PADDING, PADDING + 60);
    public static final Point PRODUCTION_PLUS_POSITION = new Point(PADDING, PADDING + 90);

    public static final Point START_ANGLE_POSITION = new Point(PRODUCTION_F_UPPER_POSITION.x +
            TEXT_DIMENSION.width + PADDING, PRODUCTION_F_UPPER_POSITION.y);

    public static final Point DELTA_POSITION = new Point(PRODUCTION_F_LOWER_POSITION.x +
            TEXT_DIMENSION.width + PADDING, PRODUCTION_F_LOWER_POSITION.y);

    public static final Point DEFAULT_ENTITY_POSITION = new Point(DISPLAY_DIMENSION.width / 2, DISPLAY_DIMENSION.height / 2);
    public static final int ENTITY_ANGLE = 90;
    public static final int ENTITY_STEP = 20;
    public static final int ENTITY_DELTA = 90;

}
