import java.util.*;
import java.swing.*;
import javax.swing.JOptionPane;

public class NumberGame {
    public static void main(String[] args) {
        int max =100;
        int maxAttempts = 5;
        int totalScore = 0;
        int roundsWon = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int randomnum = new Random().nextInt(max) +1 ;
            boolean userCorrect = false;
            int attempts =0;
            
            while (!userCorrect && attempts < maxAttempts) {
                String userInput =JOptionPane.showInputDialog("Guess the Number"+ (attempts +1)+")");
                int user_guess_num = Integer.parseInt(userInput);
                
                if (user_guess_num > randomnum){
                    JOptionPane.showMessageDialog(null, "Too High, try again!!");
                } else  if (user_guess_num < randomnum){
                    JOptionPane.showMessageDialog(null, "Too Low, try again!!");
                } else {
                      JOptionPane.showMessageDialog(null, "Congrats!! You guessed the number");
                      userCorrect = true;
                      totalScore+= maxAttempts -attempts;
                      roundsWon++;
                }
                
                attempts++;
            }
            
            if (!userCorrect) {
                  JOptionPane.showMessageDialog(null, "Oops!,Maximum Attempts Reached.The correct number was: " + randomnum);
            }
            int choice =  JOptionPane.showConfirmDialog(null, "Do you want to play again?","Play Again", JOptionPane.YES_NO_OPTION);
            playAgain =(choice ==JOptionPane.YES_NO_OPTION);
        }
              JOptionPane.showMessageDialog(null, "Game over! Rounds Won:" + roundsWon + "Total Score: " + totalScore);
              System.exit(0);
    }
    
}