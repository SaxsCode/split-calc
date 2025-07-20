import javax.swing.*;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main implements ActionListener {

    JFrame frame;
    List<Object> pressedButtons;
    JTextField display;

    public static void main(String[] args) {
        Main calculator = new Main();

        calculator.pressedButtons = new ArrayList<>();

        calculator.setFrame();
        calculator.addDisplay();
        calculator.addButtons();
    }
 
    private void setFrame()
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(300,300);
        frame.setVisible(true);

        this.frame = frame;
    }

    private void addDisplay() {
        display = new JTextField(16);
        display.setEditable(false);
        this.frame.add(display);
    }

    private void addButtons() {
        List<JButton> buttons = this.getButtons();

        for (JButton button : buttons) {
            button.addActionListener(this);
            this.frame.add(button);
        }
    }

    private List<JButton> getButtons() {

        List<JButton> buttons = new ArrayList<>();

        for (int number = 0; number < 10; number++) {
            buttons.add(new JButton(Integer.toString(number)));
        }

        String[] operators = { "=" ,"+", "-", "/", "*", "C" };

        for (String operator : operators) {
            buttons.add(new JButton(operator));
        }

        return buttons;

    }

    public void actionPerformed(ActionEvent event) {
        JButton sourceButton = (JButton) event.getSource();
        String buttonValue = sourceButton.getText();

        if(buttonValue.equals("C")) {
            this.pressedButtons.clear();
        }

        storePressedButton(buttonValue);
        display.setText(display.getText() + buttonValue);

    }

    private void storePressedButton(String buttonValue)
    {
        try {
            storeNumber(buttonValue);
        } catch (Exception exception) {
            storeOperator(buttonValue);
        }
    }

    private void storeNumber(String buttonValue) {
        int buttonNumber = Integer.parseInt(buttonValue);
        this.pressedButtons.add(buttonNumber);
    }

    private void storeOperator(String buttonValue) {
        this.pressedButtons.add(buttonValue);
    }

}

