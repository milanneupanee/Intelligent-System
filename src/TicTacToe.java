/*
* Library used in the code
* */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToe extends JFrame {
    private JButton[][] buttons;//9 buttons for the nine boxes.
    private char currentPlayer;//X and O will be the two player here.
    private boolean gameEnded;//It returns 1 if game ended else 0.
/*
* Constructor of tictactoe
* */
    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        currentPlayer = (new Random().nextInt(2) == 0) ? 'X' : 'O';
        /*
        * It will create the random value 0 and 1. If 1 is generated then X will be selected
        * else 0 will be selected
        **/
        gameEnded = false;
        /*
        * It will create the 9 Button in the grid.
        * */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.PLAIN, 50));
                button.addActionListener(new ButtonClickListener(i, j));
                buttons[i][j] = button;
                add(button);
            }
        }

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }
/*
* This function write the 0 and X on the button and also change the turn accordingly
* */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            if (!gameEnded && buttonClicked.getText().isEmpty()) {
                buttonClicked.setText(String.valueOf(currentPlayer));
                if (checkWin(currentPlayer)) {
                    JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (checkDraw()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    private boolean checkWin(char player) {
        /*
        * It will check the possible winning pattern in the row
        * */
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(player)) &&
                    buttons[i][1].getText().equals(String.valueOf(player)) &&
                    buttons[i][2].getText().equals(String.valueOf(player))) {
                return true;
            }
        }

        /*
         * It will check the possible winning pattern in the column
         * */
        for (int j = 0; j < 3; j++) {
            if (buttons[0][j].getText().equals(String.valueOf(player)) &&
                    buttons[1][j].getText().equals(String.valueOf(player)) &&
                    buttons[2][j].getText().equals(String.valueOf(player))) {
                return true;
            }
        }

        /*
         * It will check the possible winning pattern in the diagonal
         * */
        if (buttons[0][0].getText().equals(String.valueOf(player)) &&
                buttons[1][1].getText().equals(String.valueOf(player)) &&
                buttons[2][2].getText().equals(String.valueOf(player))) {
            return true;
        }

        if (buttons[0][2].getText().equals(String.valueOf(player)) &&
                buttons[1][1].getText().equals(String.valueOf(player)) &&
                buttons[2][0].getText().equals(String.valueOf(player))) {
            return true;
        }

        return false;
    }
    /*
     * It will check the possible draw pattern in the game and also if the all field is filled up to be a draw.
     * */
    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
/*
* main function
* */
    public static void main(String[] args) {
        new TicTacToe();
    }
}
