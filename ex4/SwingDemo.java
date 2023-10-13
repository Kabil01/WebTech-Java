//text
import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Form");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create a label with custom font size for the word "BIG"
        JLabel label = new JLabel("<html>the last word is <span style='font-size: 24pt;'>BIG</span></html>");
        frame.add(label);

        frame.setVisible(true);
    }
}


