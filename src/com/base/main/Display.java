package com.base.main;

import com.base.utilities.FractalDocumentFilter;
import com.base.utilities.IntegerDocumentFilter;
import com.base.utilities.Util;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

//TODO: have dynamic resizing using shifts
public class Display extends JFrame implements ActionListener, MouseListener {
    private String displayName;
    private JPanel panel;

    private HashMap<String, String> productions;

    private JTextField axiom;
    private JTextField iteration;

    private JTextField production_F;
    private JTextField production_f;
    private JTextField production_Plus;
    private JTextField production_Minus;

    private JTextField startAngle;
    private JTextField delta;

    private JCheckBox hideButtons;

    private JButton start;
    private JButton reset;
    private JButton next;
    private JButton previous;
    private JButton editEntity;

    Display() {}

    Display(String displayName) {
        this.displayName = displayName;
        panel = new JPanel();

        productions = new HashMap<>();

        axiom = new JTextField("F f + -");
        iteration = new JTextField("5", 1);

        production_F = new JTextField("Production F");
        production_f = new JTextField("Production f");
        production_Plus = new JTextField("Production +");
        production_Minus = new JTextField("Production -");

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

    void init(Dimension dimension) {
        this.setTitle(displayName);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

        panel.add(axiom);
        panel.add(iteration);

        panel.add(production_F);
        panel.add(production_f);
        panel.add(production_Minus);
        panel.add(production_Plus);

        panel.add(startAngle);
        panel.add(delta);

        panel.add(hideButtons);

        panel.add(start);
        panel.add(next);
        panel.add(previous);
        panel.add(editEntity);
        panel.add(reset);

        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();

        initializeFields();

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

        reset.setBackground(Color.WHITE);
        reset.setSize(Util.STANDARD_BUTTON_DIMENSION);
        reset.setLocation(Util.RESET_BUTTON_POSITION);
        reset.addActionListener(this);
        reset.setVisible(true);
    }

    private void setDocuments() {
        ((AbstractDocument) axiom.getDocument()).setDocumentFilter(new FractalDocumentFilter());
        ((AbstractDocument) iteration.getDocument()).setDocumentFilter(new IntegerDocumentFilter());

        ((AbstractDocument) production_F.getDocument()).setDocumentFilter(new FractalDocumentFilter());
        ((AbstractDocument) production_f.getDocument()).setDocumentFilter(new FractalDocumentFilter());
        ((AbstractDocument) production_Plus.getDocument()).setDocumentFilter(new FractalDocumentFilter());
        ((AbstractDocument) production_Minus.getDocument()).setDocumentFilter(new FractalDocumentFilter());

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

        if (editEntity.getText().equals("Hide Entity"))
            hideEntity(isVisible);

        editEntity.setVisible(isVisible);
    }

    private void hideEntity(boolean isVisible) {
        startAngle.setVisible(isVisible);
        delta.setVisible(isVisible);
    }

    private void updateProductions() {
        if (production_F.getText().equals("Production F")) {
            productions.put("F", "F");
        } else {
            productions.put("F", production_F.getText());
        }

        if (production_f.getText().equals("Production f")) {
            productions.put("f", "f");
        } else {
            productions.put("f", production_f.getText());
        }

        if (production_Minus.getText().equals("Production -")) {
            productions.put("-", "-");
        } else {
            productions.put("-", production_Minus.getText());
        }

        if (production_Plus.getText().equals("Production +")) {
            productions.put("+", "+");
        } else {
            productions.put("+", production_Plus.getText());
        }
    }

    private void setDisabled(boolean isDisabled) {
        production_F.setEnabled(!isDisabled);
        production_f.setEnabled(!isDisabled);
        production_Plus.setEnabled(!isDisabled);
        production_Minus.setEnabled(!isDisabled);

        startAngle.setEnabled(!isDisabled);
        delta.setEnabled(!isDisabled);

        iteration.setEnabled(!isDisabled);
        axiom.setEnabled(!isDisabled);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Draw.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            int startAngleVal;
            int deltaVal;

            setDisabled(true);

            start.setVisible(false);
            next.setVisible(true);
            previous.setVisible(true);

            updateProductions();

            if (startAngle.getText().equals("Start Angle: " + Util.ENTITY_ANGLE)) {
                startAngleVal = Util.ENTITY_ANGLE;
            } else {
                startAngleVal = Integer.parseInt(startAngle.getText());
            }

            if (delta.getText().equals("Delta Angle: " + Util.ENTITY_DELTA)) {
                deltaVal = Util.ENTITY_DELTA;
            } else {
                deltaVal = Integer.parseInt(delta.getText());
            }

            PathManager.reset();
            PathManager.updateEntity(axiom.getText(), iteration.getText(), startAngleVal, deltaVal);
        }

        if (e.getSource() == next) {
            PathManager.next(productions);
        }

        if (e.getSource() == previous) {
            PathManager.previous();
        }

        if (e.getSource() == reset) {
            PathManager.reset();
            setDisabled(false);

            if (!start.isVisible()) {
                next.setVisible(false);
                previous.setVisible(false);
                start.setVisible(true);
            }
        }

        if (e.getSource() == hideButtons) {
            if (axiom.isVisible()) {
                hideFields(false);
            } else {
                hideFields(true);
            }
        }

        if (e.getSource() == editEntity) {
            if (editEntity.getText().equals("Edit Entity")) {
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
