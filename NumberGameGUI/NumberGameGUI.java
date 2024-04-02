import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class NumberGameGUI extends JFrame {
    private JTextField txGuess, txHint, txScore;
    private JButton bnNext;
    private Random rNumber;
    private int secretNumber;
    private int score;
    private boolean guessedCorrectly; // Flag to track if the user has guessed correctly in the current round

    public NumberGameGUI() {
        createUI();
        rNumber = new Random();
        nextRound();
    }

    private void createUI() {
        this.setTitle("Number Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Create UI components
        txGuess = new JTextField();
        txHint = new JTextField();
        // text is not editable
        txHint.setEditable(false);
        txScore = new JTextField("0");
        // text is not editable
        txScore.setEditable(false);
        // Next Round button
        bnNext = new JButton("Next Round");

        // The JLabels
        JLabel instruction = new JLabel("Your Guess");
        JLabel hint = new JLabel("Hint");

        // GridLayout of 4 rows, 2 columns
        this.getContentPane().setLayout(new GridLayout(4, 2));

        // Set preferred size for text fields and button
        Dimension textFieldSize = new Dimension(130, 30);
        txGuess.setPreferredSize(textFieldSize);
        txHint.setPreferredSize(textFieldSize);
        txScore.setPreferredSize(textFieldSize);
        bnNext.setPreferredSize(textFieldSize);
        
        // Place all UI components into JFrame
        // First row
        this.add(instruction);
        this.add(txGuess);

        // Second row
        this.add(hint);
        this.add(txHint);

        // Third row
        this.add(new JLabel("Score: "));
        this.add(txScore);

        // Fourth row
        this.add(new JLabel(" "));
        this.add(bnNext);

        this.pack();

        // Add event handler
        addHandlers();
    }

    private void addHandlers() {
        // Create listener for txGuess
        ActionListener txListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkInput();
            }
        };
        txGuess.addActionListener(txListener);

        // Listener for bnNext
        ActionListener bnListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextRound();
            }
        };
        bnNext.addActionListener(bnListener);
    }

    private void checkInput() {
        // Get input String from txGuess
        String input = txGuess.getText();

        // Convert to integer
        int guess = 0;
        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            txHint.setText("Invalid input!");
            return;
        }

        // Check if the guess is the same as secret number
        // Display result
        String hintMesg = "";
        if (guess > secretNumber)
            hintMesg = input + " is too high";
        else if (guess < secretNumber)
            hintMesg = input + " is too low";
        else {
            if (!guessedCorrectly) {
                hintMesg = input + " is correct!";
                // Increase the score
                score++;
                txScore.setText(Integer.toString(score));
                guessedCorrectly = true;
            } else {
                hintMesg = "Correct! Next Round!";
            }
        }

        // Display hint and clear input
        txHint.setText(hintMesg);
        txGuess.setText("");
    }

    private void nextRound() {
        // Clear all values
        txGuess.setText("");
        txHint.setText("");
        // Reset the flag for the next round
        guessedCorrectly = false; 

        // Generate new number for the next round
        secretNumber = rNumber.nextInt(100);
        System.out.println(secretNumber);
    }

    public static void main(String[] argv) {
        new NumberGameGUI().setVisible(true);
    }
}
