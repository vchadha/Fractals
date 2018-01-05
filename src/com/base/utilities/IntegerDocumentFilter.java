package com.base.utilities;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class IntegerDocumentFilter extends DocumentFilter {
    //TODO: make this better ie. regex or contains or toUpper also fix copy paste exception
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (Util.DIGITS.contains(string))
            super.insertString(fb, offset, string, attr);
        else
            Toolkit.getDefaultToolkit().beep();
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (Util.DIGITS.contains(text))
            super.replace(fb, offset, length, text, attrs);
        else
            Toolkit.getDefaultToolkit().beep();
    }
}
