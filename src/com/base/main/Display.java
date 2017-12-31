package com.base.main;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Display extends JFrame implements ActionListener, KeyListener {
    //TODO: axiom input, start button, iterator bar, add production button, production is panel with 2 elements - replace and string to replace?
    private String displayName;
    private static JPanel panel;
    private static JTextField axiom;
    private static JButton start;

    public Display() {}

    public Display(String displayName) {
        this.displayName = displayName;
        panel = new JPanel();
        //TODO: figure out how this works
        axiom = new JTextField("F f - +");
        ((AbstractDocument) axiom.getDocument()).setDocumentFilter(new FractalDocumentFilter());

        start = new JButton("Start");
    }

    public void init(Dimension dimension) {
        this.setTitle(displayName);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

        axiom.setBackground(Color.WHITE);
        axiom.setSize(Util.AXIOM_TEXT_DIMENSION);
        axiom.setLocation(Util.AXIOM_TEXT_POSITION);
        axiom.setVisible(true);

        start.setBackground(Color.WHITE);
        start.setSize(Util.START_BUTTON_DIMENSION);
        start.setLocation(Util.START_BUTTON_POSITION);
        start.addActionListener(this);
        start.setVisible(true);

        panel.add(axiom);
        panel.add(start);

        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Draw.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            //Get text from panels and pass as parameters
            //Draw.addLine
            //Entity.move
        }

        revalidate();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        e.consume();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        e.consume();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        e.consume();
    }
}
