package main;

import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme; // Changed to a more universal dark theme
import main.UI.CalculatorFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    UIManager.put("Button.arc", 25); // Even more rounded buttons for a softer look
    UIManager.put("Button.innerFocusWidth", 3); // Slightly broader focus for clarity
    UIManager.put("Component.focusWidth", 3); // Uniform focus width for all components
    UIManager.put("ProgressBar.arc", 25); // More rounded progress bars for consistency
    UIManager.put("TextComponent.arc", 20); // Increased rounding for text fields for harmony

    UIManager.put("Button.background", new Color(68, 68, 68)); // Slightly darker button background
    UIManager.put("Button.foreground", new Color(220, 220, 220)); // Soft white for button text
    UIManager.put("Panel.background", new Color(38, 38, 38)); // Darker panel background for depth
    UIManager.put("TextField.background", new Color(45, 45, 45)); // Darker text field background
    UIManager.put("TextField.foreground", new Color(225, 225, 225)); // Brighter text for contrast
    UIManager.put("TextField.caretForeground", new Color(255, 255, 255)); // Bright white caret for visibility

    UIManager.put("ScrollBar.thumb", new Color(80, 80, 80)); // Custom scrollbar thumb color
    UIManager.put("ScrollBar.width", 15); // Increased scrollbar width for ease of use
    UIManager.put("Menu.selectionBackground", new Color(58, 58, 58)); // Menu selection background
    UIManager.put("MenuItem.selectionBackground", new Color(58, 58, 58)); // MenuItem selection background
    UIManager.put("OptionPane.background", new Color(43, 43, 43)); // OptionPane background
    UIManager.put("OptionPane.foreground", Color.WHITE); // OptionPane text color

    FlatDarkFlatIJTheme.setup(); // More universal dark theme for wider appeal
    SwingUtilities.invokeLater(CalculatorFrame::new);
  }
}
