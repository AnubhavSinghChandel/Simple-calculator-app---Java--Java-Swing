import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    // Declaring all the elements that will be used
    // JFrame myFrame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];// Contains all the number buttons
    JButton[] funcButton = new JButton[9];// Contains all the buttons for function
    JButton addButton, subButton, divButton, mulButton; // All the function buttons
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel; // Panel contains all the buttons and textField

    Font myFont = new Font("Be Vietnam", Font.BOLD, 20); // Default font for the calculator

    // storage for numbers and operators to be used
    double num1 = 0, num2 = 0, result = 0;
    char opr;

    Calculator() {
        // Customizing the frame
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null);

        // creating textField
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // creating all the buttons going to used in calc
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        delButton = new JButton("Delete");
        equButton = new JButton("=");
        clrButton = new JButton("AC");
        negButton = new JButton("(-)");

        // adding all the function buttons to the respective array
        funcButton[0] = addButton;
        funcButton[1] = subButton;
        funcButton[2] = mulButton;
        funcButton[3] = divButton;
        funcButton[4] = decButton;
        funcButton[5] = delButton;
        funcButton[6] = equButton;
        funcButton[7] = clrButton;
        funcButton[8] = negButton;

        // settings for all function button
        for (int i = 0; i < 9; i++) {
            funcButton[i].addActionListener(this); // on-click function
            funcButton[i].setFont(myFont); // font
            funcButton[i].setFocusable(false); // removes wierd shadow on button
        }

        // settings for function button
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }

        // setting bounds for negButton, delButton and clrButton as they are not gonna
        // be part of the main grid of buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // adding panel to the frame an d it will contain all the buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        // adding all the above to the frame
        this.add(panel);
        this.add(textField);
        this.add(delButton);
        this.add(negButton);
        this.add(clrButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // iterates from first to last button
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // what decimal button does
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        // function of add button
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            opr = '+';
            textField.setText("");
        }
        // for subtract button
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            opr = '-';
            textField.setText("");
        }
        // for multiplication
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            opr = '*';
            textField.setText("");
        }
        // for division
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            opr = '/';
            textField.setText("");
        }
        // for equal button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (opr) {
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
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        // for clear button
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        // for delete button
        if (e.getSource() == delButton) {
            String str = textField.getText();
            textField.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textField.setText(textField.getText() + str.charAt(i));
            }
        }
        // to input negative numbers
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}