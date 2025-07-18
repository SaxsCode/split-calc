import javax.swing.*;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main implements ActionListener {

    public static void main(String[] args) {
        Main calculator = new Main();
        calculator.generateGUI();
    }
 
    private void generateGUI()
    {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        List<JButton> buttons = getButtons(frame);

        for (JButton button : buttons) {
            button.addActionListener(this);
            frame.add(button);
        }
         
        frame.setSize(300,300);
        frame.setVisible(true);
    }


    private List<JButton> getButtons(JFrame frame) {

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

    public void actionPerformed(ActionEvent event) {}
}

