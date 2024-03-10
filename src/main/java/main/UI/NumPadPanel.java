package main.UI;

import net.miginfocom.swing.MigLayout;
import main.common.Constants;

import javax.swing.*;

public class NumPadPanel extends JPanel {

  private NumPadListener listener = (String text, String action) -> {
  };

  public NumPadPanel() {
    setLayout(new MigLayout("fill, gap 0, insets 0"));
  }

  public void init() {
    // Special functions at the top
    add(getButton("AC", "clear"), "grow, span 1");// Clear button
    add(getButton("C", "delete"), "grow, span 1");// Delete button
    add(getButton('/', " / "), "grow, span 1"); // Division operator
    add(getButton('x', " * "), "grow, span 1"); // Multiplication operator
    add(getButton('^', " ^ "), "grow, span 1"); // Power operator
    add(getButton('\u221A', " \u221A "), "grow, span 1, wrap"); // Square root operator

    // Numeric buttons and additional operators
    add(getButton("7", "7"), "grow, span 1"); // Number 7
    add(getButton("8", "8"), "grow, span 1"); // Number 8
    add(getButton("9", "9"), "grow, span 1"); // Number 9
    add(getButton("ln", " ln "), "grow, span 1"); // Natural logarithm function
    add(getButton('+', " + "), "grow, span 1");// Addition operator
    add(getButton("sin", " sin "), "grow, span 1, wrap"); // Sine function

    // Numeric buttons
    add(getButton("4", "4"), "grow, span 1"); // Number 4
    add(getButton("5", "5"), "grow, span 1"); // Number 5
    add(getButton("6", "6"), "grow, span 1"); // Number 6
    add(getButton("log", " log "), "grow, span 1");// Base 10 logarithm function
    add(getButton('-', " - "), "grow, span 1");// Subtraction operator
    add(getButton("cos", " cos "), "grow, span 1, wrap"); // Cosine function


    // Numeric buttons and parentheses
    add(getButton("1", "1"), "grow, span 1"); // Number 1
    add(getButton("2", "2"), "grow, span 1"); // Number 2
    add(getButton("3", "3"), "grow, span 1"); // Number 3
    add(getButton("(", "("), "grow, span 1"); // Open parenthesis operator
    add(getButton(")", ")"), "grow, span 1"); // Close parenthesis operator
    add(getButton("tan", " tan "), "grow, span 1, wrap"); // Tangent function

    // Bottom row with zero, decimal point, and equal button spanning two rows
    add(getButton("0", "0"), "grow, span 2"); // Number 0 (spanning two columns for a wider button)
    add(getButton(".", "."), "grow, span 1"); // Decimal point
    add(getButton('=', "equal"), "grow, span 2"); // Equal button (spanning two columns)
  }


  public void setNumPadListener(NumPadListener listener) {
    this.listener = listener;
  }

  private JButton getButton(char text, String action) {
    return getButton(charToString(text), action);
  }

  private JButton getButton(String text, String action) {
    JButton button = new JButton(text);
    button.setFont(Constants.DEFAULT_FONT);
    button.addActionListener(e -> listener.onButtonClick(text, action));
    return button;
  }

  private String charToString(char character) {
    return Character.toString(character);
  }

  @FunctionalInterface
  public interface NumPadListener {
    void onButtonClick(String text, String action);
  }
}