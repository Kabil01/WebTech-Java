//calculator
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    // Components
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton addButton, subButton, mulButton, divButton, equalsButton, clearButton;
    private JPanel panel;

    // Variables to store operands and operator
    private double num1, num2, result;
    private char operator;

    public SimpleCalculator() {
        // Create the frame
        setTitle("Simple Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            numberButtons[i].addActionListener(this);
        }

        operationButtons = new JButton[4];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;

        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        // Create panel and add components
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divButton);

        // Add components to the frame
        add(textField, BorderLayout.NORTH);
        add(panel);

        // Add action listeners for operation buttons
        for (JButton button : operationButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
        }

        // Add action listeners for equals and clear buttons
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Handle number buttons
        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                textField.setText(textField.getText() + i);
                return;
            }
        }

        // Handle operation buttons
        for (int i = 0; i < 4; i++) {
            if (source == operationButtons[i]) {
                operator = operationButtons[i].getText().charAt(0);
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                return;
            }
        }

        // Handle equals button
        if (source == equalsButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        }

        // Handle clear button
        if (source == clearButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = '\0';
        }
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setVisible(true);
    }
}

