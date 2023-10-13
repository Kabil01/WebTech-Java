import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounterApp {
    private int clickCount = 0;
    private JFrame frame;
    private JButton clickButton;
    private JTextField clickCountField;

    public ClickCounterApp() {
        frame = new JFrame("Click Counter App");
        clickButton = new JButton("Click Me");
        clickCountField = new JTextField(10);
        clickCountField.setEditable(false);

        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                clickCountField.setText(Integer.toString(clickCount));
            }
        });

        JPanel panel = new JPanel();
        panel.add(clickButton);
        panel.add(new JLabel("Click Count:"));
        panel.add(clickCountField);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClickCounterApp();
            }
        });
    }
}

