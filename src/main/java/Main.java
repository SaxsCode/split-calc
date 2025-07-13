import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        generateGUI();
    }
 
    private static void generateGUI()
    {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        List<JButton> buttons = getButtons(frame);

        for (JButton button : buttons) {
            frame.getContentPane().add(button);
        }

        frame.setVisible(true);
    }

    private static List<JButton> getButtons(JFrame frame) {

        List<JButton> buttons = new ArrayList<>();

        for (int number = 0; number < 10; number++) {
            buttons.add(new JButton(Integer.toString(number)));
        }

        return buttons;

    }

}
