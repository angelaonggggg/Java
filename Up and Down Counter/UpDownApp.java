import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UpDownApp extends JFrame
{
    // easier to change the values
    private static int MIN = 0;
    private static int MAX = 10;
    private JTextField txCounter;
    private JButton bnUp, bnDown;

    public UpDownApp()
    {
        createUI();
    }

    private void createUI()
    {
        this.setTitle("Up and Down");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // Create UI
        txCounter = new JTextField("0");
        txCounter.setEditable(false);
        txCounter.setHorizontalAlignment(JTextField.CENTER);
        bnUp = new JButton("Up");
        bnDown = new JButton("Down");
        bnDown.setEnabled(false);
        // GridLayout of 3 rows and 1 column
        this.getContentPane().setLayout(new GridLayout(3,1));
        this.add(txCounter);
        this.add(bnUp);
        this.add(bnDown);
        this.pack();
        addHandlers();
    }

    private void addHandlers()
    {
        // up button function
        ActionListener upListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                upCounter();
            }
        };

        bnUp.addActionListener(upListener);

        ActionListener downListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downCounter();
            }
        };

        bnDown.addActionListener(downListener);
    }
    private void upCounter()
    {
        /*Test whether your button work first
        System.out.println("Going up");*/

        // it is a string need to convert to number
        int counter = Integer.parseInt(txCounter.getText());
        counter++;
        // setText take in string not integer
        // need to convert back
        txCounter.setText(String.valueOf(counter));
        if (counter == MAX)
            bnUp.setEnabled(false);
        bnDown.setEnabled(true);
    }

    private void downCounter()
    {
        // System.out.println("Going down");
        // it is a string need to convert to number
        int counter = Integer.parseInt(txCounter.getText());
        counter--;
        // setText take in string not integer
        // need to convert back
        txCounter.setText(String.valueOf(counter));
        if (counter == MIN)
            bnDown.setEnabled(false);
        bnUp.setEnabled(true);
    }

    public static void main(String[] args) {
        new UpDownApp().setVisible(true);
    }
}
