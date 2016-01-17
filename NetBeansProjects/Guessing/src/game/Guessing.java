/**
 * CSCI1530 Assignment 3 Number Guessing Game
 * 
 * I declare that the assignment here submitted is original
 * except for source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of University policy and
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of such
 * policy and regulations, as contained in the website.
 * 
 * University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/academichonesty/
 * Faculty of Engineering Guidelines to Academic Honesty:
 *   http://www.cse.cuhk.edu.hk/csci1530/ENGG_Discipline.pdf
 * 
 * Student Name: Tsang Ting Fung
 * Student ID  : 1155030464
 * Date        : 25/2/2015
 */
package game;

import java.util.*; 
import javax.swing.JOptionPane;

public class Guessing {

    public static void main(String[] args) {
        int rangeStart = 1 ,rangeEnd = 100 ,n = 7 ,number = 0, answer;
        Random obj = new Random();
        answer = obj.nextInt(101);
        // set initial range = [1,100] ,number of guess = 7 and generate an answer in the range [1,100]
        
        String input = "a";
        // input has to be initialize otherwise line 50 will have error
        
        do{
            if (n == 7){
                input = JOptionPane.showInputDialog("<html>Let\'s start!<p>Guess my number in [" + rangeStart + "," +  rangeEnd + "]<p>" + n + " attempt(s) left<p>");
            }
            else if(n > 0){
                input = JOptionPane.showInputDialog("<html>It\'s near,try again!<p>Guess my number in [" + rangeStart + "," +  rangeEnd + "]<p>" + n + " attempt(s) left<p>");
            }
            else{
                JOptionPane.showMessageDialog(null, "<html>Sorry,game is over!<p>Bye!<p>");
            }
            
            if(n !=0){
                number = Integer.parseInt(input);
                // convert the input string into an integer
            
                while(number > rangeEnd || number< rangeStart){
                    input = JOptionPane.showInputDialog("<html>Where are you kicking? Try again!<p>Guess my number in [" + rangeStart + "," +  rangeEnd + "]<p>" + n + " attempt(s) left<p>");
                    number = Integer.parseInt(input);
                }
                // ensure the input is inside the range
            
                if(number == answer){
                    JOptionPane.showMessageDialog(null, "<html>Bingo! You've got it!<p>Bye!<p>");
                }
                else if(number > answer){
                    rangeEnd = number - 1;
                }
                else{
                    rangeStart = number + 1;
                }
                // updata the range if guess != answer
            }
            
            n--;
            //updata n
        }while(n >= 0 && number != answer);
        // loop until n == 0 or tthe guess number == answer
    }
    
}
