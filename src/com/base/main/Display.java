package com.base.main;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame implements ActionListener, MouseListener {
    private String displayName;
    private static JPanel panel;

    protected static JTextField axiom;
    protected static JTextField iteration;

    protected static JTextField production_F;
    protected static JTextField production_f;
    protected static JTextField production_Plus;
    protected static JTextField production_Minus;

    protected static JTextField startXPos;
    protected static JTextField startYPos;
    protected static JTextField step;
    protected static JTextField startAngle;
    protected static JTextField delta;

    protected static JCheckBox hideButtons;

    protected static JButton start;
    protected static JButton reset;
    protected static JButton next;
    protected static JButton previous;
    protected static JButton editEntity;

    public Display() {}

    public Display(String displayName) {
        this.displayName = displayName;
        panel = new JPanel();

        axiom = new JTextField("F f - +");
        iteration = new JTextField("1", 1);

        production_F = new JTextField("Production F");
        production_f = new JTextField("Production f");
        production_Plus = new JTextField("Production +");
        production_Minus = new JTextField("Production -");

        startXPos = new JTextField("Start X Position: " + Util.DEFAULT_ENTITY_POSITION.x);
        startYPos = new JTextField("Start Y Position: " + Util.DEFAULT_ENTITY_POSITION.y);
        step = new JTextField("Step Amt: " + Util.ENTITY_STEP);
        startAngle = new JTextField("Start Angle: " + Util.ENTITY_ANGLE);
        delta = new JTextField("Delta Angle: " + Util.ENTITY_DELTA);

        setDocuments();

        hideButtons = new JCheckBox("Hide Overlay");

        start = new JButton("Start");
        reset = new JButton("Reset");
        next = new JButton(">");
        previous = new JButton("<");
        editEntity = new JButton("Edit Entity");
    }

    public void init(Dimension dimension) {
        this.setTitle(displayName);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

        initializeFields();

        panel.add(axiom);
        panel.add(iteration);

        panel.add(production_F);
        panel.add(production_f);
        panel.add(production_Minus);
        panel.add(production_Plus);

        panel.add(startXPos);
        panel.add(startYPos);
        panel.add(step);
        panel.add(startAngle);
        panel.add(delta);

        panel.add(hideButtons);

        panel.add(start);
        panel.add(next);
        panel.add(previous);
        panel.add(editEntity);

        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void initializeFields() {
        axiom.setBackground(Color.WHITE);
        axiom.setSize(Util.TEXT_DIMENSION);
        axiom.setLocation(Util.AXIOM_TEXT_POSITION);
        axiom.setVisible(true);

        iteration.setBackground(Color.WHITE);
        iteration.setSize(Util.TEXT_DIMENSION);
        iteration.setLocation(Util.ITERATION_POSITION);
        iteration.setVisible(true);

        production_F.setBackground(Color.WHITE);
        production_F.setSize(Util.TEXT_DIMENSION);
        production_F.setLocation(Util.PRODUCTION_F_UPPER_POSITION);
        production_F.addMouseListener(this);
        production_F.setVisible(true);

        production_f.setBackground(Color.WHITE);
        production_f.setSize(Util.TEXT_DIMENSION);
        production_f.setLocation(Util.PRODUCTION_F_LOWER_POSITION);
        production_f.addMouseListener(this);
        production_f.setVisible(true);

        production_Minus.setBackground(Color.WHITE);
        production_Minus.setSize(Util.TEXT_DIMENSION);
        production_Minus.setLocation(Util.PRODUCTION_MINUS_POSITION);
        production_Minus.addMouseListener(this);
        production_Minus.setVisible(true);

        production_Plus.setBackground(Color.WHITE);
        production_Plus.setSize(Util.TEXT_DIMENSION);
        production_Plus.setLocation(Util.PRODUCTION_PLUS_POSITION);
        production_Plus.addMouseListener(this);
        production_Plus.setVisible(true);

        startXPos.setBackground(Color.WHITE);
        startXPos.setSize(Util.ENTITY_DIMENSION);
        startXPos.setLocation(Util.START_X_POSITION);
        startXPos.addMouseListener(this);
        startXPos.setVisible(false);

        startYPos.setBackground(Color.WHITE);
        startYPos.setSize(Util.ENTITY_DIMENSION);
        startYPos.setLocation(Util.START_Y_POSITION);
        startYPos.addMouseListener(this);
        startYPos.setVisible(false);

        step.setBackground(Color.WHITE);
        step.setSize(Util.ENTITY_DIMENSION);
        step.setLocation(Util.STEP_POSITION);
        step.addMouseListener(this);
        step.setVisible(false);

        startAngle.setBackground(Color.WHITE);
        startAngle.setSize(Util.ENTITY_DIMENSION);
        startAngle.setLocation(Util.START_ANGLE_POSITION);
        startAngle.addMouseListener(this);
        startAngle.setVisible(false);

        delta.setBackground(Color.WHITE);
        delta.setSize(Util.ENTITY_DIMENSION);
        delta.setLocation(Util.DELTA_POSITION);
        delta.addMouseListener(this);
        delta.setVisible(false);

        hideButtons.setBackground(Color.BLACK);
        hideButtons.setForeground(Color.WHITE);
        hideButtons.setSize(Util.TEXT_DIMENSION);
        hideButtons.setLocation(Util.HIDDEN_BUTTON_POSITION);
        hideButtons.addActionListener(this);
        hideButtons.setVisible(true);

        start.setBackground(Color.WHITE);
        start.setSize(Util.STANDARD_BUTTON_DIMENSION);
        start.setLocation(Util.START_BUTTON_POSITION);
        start.addActionListener(this);
        start.setVisible(true);

        next.setBackground(Color.WHITE);
        next.setSize(Util.TRAVERSE_BUTTON_DIMENSION);
        next.setLocation(Util.NEXT_BUTTON_POSITION);
        next.addActionListener(this);
        next.setVisible(false);

        previous.setBackground(Color.WHITE);
        previous.setSize(Util.TRAVERSE_BUTTON_DIMENSION);
        previous.setLocation(Util.PREVIOUS_BUTTON_POSITION);
        previous.addActionListener(this);
        previous.setVisible(false);

        editEntity.setBackground(Color.WHITE);
        editEntity.setSize(Util.STANDARD_BUTTON_DIMENSION);
        editEntity.setLocation(Util.EDIT_BUTTON_POSITION);
        editEntity.addActionListener(this);
        editEntity.setVisible(true);
    }

    private void setDocuments() {
        ((AbstractDocument) axiom.getDocument()).setDocumentFilter(new FractalDocumentFilter());
        ((AbstractDocument) iteration.getDocument()).setDocumentFilter(new IntegerDocumentFilter());

        ((AbstractDocument) production_F.getDocument()).setDocumentFilter(new FractalDocumentFilter());
        ((AbstractDocument) production_f.getDocument()).setDocumentFilter(new FractalDocumentFilter());
        ((AbstractDocument) production_Plus.getDocument()).setDocumentFilter(new FractalDocumentFilter());
        ((AbstractDocument) production_Minus.getDocument()).setDocumentFilter(new FractalDocumentFilter());

        ((AbstractDocument) startXPos.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
        ((AbstractDocument) startYPos.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
        ((AbstractDocument) step.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
        ((AbstractDocument) startAngle.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
        ((AbstractDocument) delta.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
    }

    private void hideFields(boolean isVisible) {
        axiom.setVisible(isVisible);
        iteration.setVisible(isVisible);

        production_F.setVisible(isVisible);
        production_f.setVisible(isVisible);
        production_Plus.setVisible(isVisible);
        production_Minus.setVisible(isVisible);

        if (editEntity.getText() == "Hide Entity")
            hideEntity(isVisible);

        editEntity.setVisible(isVisible);
    }

    private void hideEntity(boolean isVisible) {
        startXPos.setVisible(isVisible);
        startYPos.setVisible(isVisible);
        step.setVisible(isVisible);
        startAngle.setVisible(isVisible);
        delta.setVisible(isVisible);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Draw.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            start.setVisible(false);
            next.setVisible(true);
            previous.setVisible(true);

            //TODO: probably should move to method and call from here, next, and prev
            PathManager.reset();
            PathManager.updateEntity(axiom.getText());
        }

        if (e.getSource() == hideButtons) {
            if (axiom.isVisible()) {
                hideFields(false);
            } else {
                hideFields(true);
            }
        }

        if (e.getSource() == next) {}

        if (e.getSource() == previous) {}

        if (e.getSource() == editEntity) {
            if (editEntity.getText() == "Edit Entity") {
                editEntity.setText("Hide Entity");
                hideEntity(true);
            } else {
                editEntity.setText("Edit Entity");
                hideEntity(false);
            }
        }

        revalidate();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == production_F)
            production_F.setText("");
        else if (e.getSource() == production_f)
            production_f.setText("");
        else if (e.getSource() == production_Plus)
            production_Plus.setText("");
        else if (e.getSource() == production_Minus)
            production_Minus.setText("");
        else if (e.getSource() == startXPos)
            startXPos.setText("");
        else if (e.getSource() == startYPos)
            startYPos.setText("");
        else if (e.getSource() == step)
            step.setText("");
        else if (e.getSource() == startAngle)
            startAngle.setText("");
        else if (e.getSource() == delta)
            delta.setText("");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
