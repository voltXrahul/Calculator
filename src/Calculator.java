
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Calculator implements ActionListener {
    JFrame frame;
    ArrayList<String> history;
    JTextField textField;
    JTextArea historyTextField;
    JTextField vision;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[18];
    JButton addButton, subButton, mulButton, divButton;
    JButton decimalButton, equalButton, delButton, clearButton, negativeButton;
    //Scientific
    JButton powerButton, factButton, sqrtButton;
    JButton sinButton, cosButton, tanButton;
    JButton remButton, logButton, fractionButton;
    JButton previouslyClicked;
    JPanel panel;

    Font myfont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;


    Calculator() {
        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(904, 700);
        frame.setLayout(null);

        history = new ArrayList<>();

        textField = new JTextField();
        textField.setBounds(165, 220, 200, 70);
        textField.setFont(myfont);
        textField.setEditable(false);

        historyTextField = new JTextArea();
        historyTextField.setBounds(430, 50, 400, 600);
        historyTextField.setFont(myfont);
        historyTextField.setEditable(false);
        historyTextField.setForeground(Color.WHITE);
        historyTextField.setBackground(Color.DARK_GRAY);


        //History
        vision = new JTextField();
        vision.setBounds(45, 220, 120, 70);
        vision.setEditable(false);

        vision.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        vision.setForeground(Color.DARK_GRAY);


        addButton = new JButton("+");
        addButton.setBackground(new Color(255, 149, 0));
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);

        subButton = new JButton("-");
        subButton.setBackground(new Color(255, 149, 0));
        subButton.setOpaque(true);
        subButton.setBorderPainted(false);

        mulButton = new JButton("*");
        mulButton.setBackground(new Color(255, 149, 0));
        mulButton.setOpaque(true);
        mulButton.setBorderPainted(false);

        divButton = new JButton("/");
        divButton.setBackground(new Color(255, 149, 0));
        divButton.setOpaque(true);
        divButton.setBorderPainted(false);

        decimalButton = new JButton(".");
        decimalButton.setBackground(Color.LIGHT_GRAY);
        decimalButton.setOpaque(true);
        decimalButton.setBorderPainted(false);

        equalButton = new JButton("=");
        equalButton.setBackground(Color.LIGHT_GRAY);
        equalButton.setOpaque(true);
        equalButton.setBorderPainted(false);

//spl buttons
        delButton = new JButton("del");
        delButton.setBackground(new Color(125, 249, 255));
        delButton.setOpaque(true);
        delButton.setBorderPainted(false);

        clearButton = new JButton("clr");
        clearButton.setBackground(new Color(125, 249, 255));
        clearButton.setOpaque(true);
        clearButton.setBorderPainted(false);

        negativeButton = new JButton("+/-");
        negativeButton.setBackground(new Color(125, 249, 255));
        negativeButton.setOpaque(true);
        negativeButton.setBorderPainted(false);


//Scientific methods
        powerButton = new JButton("^");
        powerButton.setBackground(new Color(227, 244, 254));
        powerButton.setOpaque(true);
        powerButton.setBorderPainted(false);

        factButton = new JButton("!");
        factButton.setBackground(new Color(227, 244, 254));
        factButton.setOpaque(true);
        factButton.setBorderPainted(false);

        sqrtButton = new JButton("√");
        sqrtButton.setBackground(new Color(227, 244, 254));
        sqrtButton.setOpaque(true);
        sqrtButton.setBorderPainted(false);

        sinButton = new JButton("sin");
        sinButton.setBackground(new Color(227, 244, 254));
        sinButton.setOpaque(true);
        sinButton.setBorderPainted(false);

        cosButton = new JButton("cos");
        cosButton.setBackground(new Color(227, 244, 254));
        cosButton.setOpaque(true);
        cosButton.setBorderPainted(false);

        tanButton = new JButton("tan");
        tanButton.setBackground(new Color(227, 244, 254));
        tanButton.setOpaque(true);
        tanButton.setBorderPainted(false);

        remButton = new JButton("%");
        remButton.setBackground(new Color(227, 244, 254));
        remButton.setOpaque(true);
        remButton.setBorderPainted(false);

        logButton = new JButton("log");
        logButton.setBackground(new Color(227, 244, 254));
        logButton.setOpaque(true);
        logButton.setBorderPainted(false);

        fractionButton = new JButton("1/x");
        fractionButton.setBackground(new Color(227, 244, 254));
        fractionButton.setOpaque(true);
        fractionButton.setBorderPainted(false);


        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;
        functionButtons[9] = powerButton;
        functionButtons[10] = factButton;
        functionButtons[11] = sqrtButton;
        functionButtons[12] = sinButton;
        functionButtons[13] = cosButton;
        functionButtons[14] = tanButton;
        functionButtons[15] = remButton;
        functionButtons[16] = logButton;
        functionButtons[17] = fractionButton;


        for (int i = 0; i < 18; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.DARK_GRAY);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setBorderPainted(false);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);

        }

        negativeButton.setBounds(45, 610, 105, 50);
        delButton.setBounds(160, 610, 100, 50);
        clearButton.setBounds(270, 610, 100, 50);


        powerButton.setBounds(45, 45, 100, 50);
        factButton.setBounds(155, 45, 100, 50);
        sqrtButton.setBounds(265, 45, 100, 50);
        sinButton.setBounds(45, 100, 100, 50);
        cosButton.setBounds(155, 100, 100, 50);
        tanButton.setBounds(265, 100, 100, 50);
        remButton.setBounds(45, 155, 100, 50);
        logButton.setBounds(155, 155, 100, 50);
        fractionButton.setBounds(265, 155, 100, 50);


        panel = new JPanel();
        panel.setBounds(47, 300, 320, 300);
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
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);
        panel.setBackground(Color.BLACK);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.add(vision);
        frame.add(negativeButton);
        frame.add(powerButton);
        frame.add(factButton);
        frame.add(sqrtButton);
        frame.add(sinButton);
        frame.add(cosButton);
        frame.add(tanButton);
        frame.add(remButton);
        frame.add(logButton);
        frame.add(fractionButton);
        frame.add(historyTextField);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            vision.setText(num1 + " + ");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            vision.setText(num1 + " - ");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            vision.setText(num1 + " * ");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            vision.setText(num1 + " / ");
        }
        if (e.getSource() == equalButton) {

            if (previouslyClicked == equalButton) return;
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
                case '^' -> result = Math.pow(num1, num2);
                case '%' -> result = num1 % num2;
            }
            textField.setText(String.format("%.2f", result));
            vision.setText(vision.getText().concat(num2 + " ="));

            history.add(vision.getText() + " " + String.format("%.2f", result));
            updateHistory();
            num1 = result;
        }
        if (e.getSource() == clearButton) {
            textField.setText("");
            vision.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));// character at index
            }
        }
        if (e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == powerButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
            vision.setText(num1 + " ^ ");
        }
        if (e.getSource() == factButton) {
            double num1 = Double.parseDouble(textField.getText());
            double fact = 1;
            for (double i = 1; i <= num1; i++) {
                fact *= i;
            }
            textField.setText(Double.toString(fact));
            vision.setText(num1 + " ! ");
            history.add(vision.getText() + " = " + String.format("%.2f", result));
            updateHistory();
        }
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(num1);
            textField.setText(String.format("%.3f", result));
            vision.setText(" √" + num1);
            num1 = result;
            history.add(vision.getText() + " = " + String.format("%.2f", result));
            updateHistory();
        }
        if (e.getSource() == sinButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sin(Math.toRadians(num1));
            textField.setText(String.format("%.6f", result));
            vision.setText("sin" + num1);
            num1 = result;
            history.add(vision.getText() + " = " + String.format("%.2f", result));
            updateHistory();
        }

        if (e.getSource() == cosButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.cos(Math.toRadians(num1));
            textField.setText(String.format("%.6f", result));
            vision.setText("cos" + num1);
            num1 = result;
            history.add(vision.getText() + " = " + String.format("%.2f", result));
            updateHistory();
        }

        if (e.getSource() == tanButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.tan(Math.toRadians(num1));
            textField.setText(String.format("%.6f", result));
            vision.setText("tan" + num1);
            num1 = result;
            history.add(vision.getText() + " = " + String.format("%.2f", result));
            updateHistory();
        }
        if (e.getSource() == remButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
            vision.setText(num1 + "%");
        }
        if (e.getSource() == logButton) {
            double num1 = Double.parseDouble(textField.getText());
            double result = Math.log(num1);
            textField.setText(String.format("%.6f", result));
            vision.setText("log" + num1);
            history.add(vision.getText() + " = " + String.format("%.2f", result));
            updateHistory();
        }
        if (e.getSource() == fractionButton) {
            double num1 = Double.parseDouble(textField.getText());
            double result = 1 / num1;
            textField.setText(String.format("%.6f", result));
            vision.setText("1/" + num1);
            history.add(vision.getText() + " = " + String.format("%.2f", result));
            updateHistory();
        }
        previouslyClicked = (JButton) e.getSource();
    }

    private void updateHistory() {
        StringBuilder historyText = new StringBuilder();
        for (String s : history) {
            historyText.append(s).append("\n\n");
        }
        historyTextField.setText(historyText.toString());
    }

}


