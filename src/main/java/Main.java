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

        JFrame contentPane = frame.getContentPane();
        List<JButton> buttons = getButtons(frame);

        for (JButton button : buttons) {
            button.addActionListener(new PageActionListener(value));
            contentPane.add(button);
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

    private class ButtonActionListener implements ActionListener {
        private int value;

        public ButtonActionListener(int value) {
            this.value = value;
        }

        public void actionPerformed(ActionEvent e) {
            JButton chosenButton = e.getSource();
            int value = chosenButton.getText();
        }
    }

}

