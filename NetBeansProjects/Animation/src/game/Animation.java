/**
 * CSCI1530 Assignment 4 Animation Game
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
 * Date        : 17/3/2015
 */
package game;

import static game.ButtonTracker.buttonClicked;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Animation {
    public static void main(String[] args) {
        // window creation:
        JFrame window;
        window = new JFrame("Animation");
        window.setSize( 400, 400 );
        window.setLayout( new GridLayout(2, 2) );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        // create a new object for tracking button clicks
        ButtonTracker act = new ButtonTracker();
        
        // create and place the buttons properly
        JButton label1 = new JButton("1");
        label1.addActionListener(act);
        window.add(label1);
        
        JButton label2 = new JButton("2");
        label2.addActionListener(act);
        window.add(label2);
        
        JButton label3 = new JButton("3");
        label3.addActionListener(act);
        window.add(label3);
        
        JButton label4 = new JButton("4");
        label4.addActionListener(act);
        window.add(label4);
        
        window.setVisible(true);
        // read user animation sequence input (for many rounds until user dismisses)
        
        String input = null;
        // pops up an input dialog
        
        do{
            input = JOptionPane.showInputDialog( "Animation Sequence:" );
            if (input == null) // it means the user dismissed the dialog box
                System.exit(0);
            
            for(int i=0;i < input.length();i++){
                if('1' == input.charAt(i)){
                    label1.setBackground(Color.yellow); // set button color to yellow
                    long  now = System.currentTimeMillis();
                    long then = now + 1000;
                    while (System.currentTimeMillis() < then){
                    }// wait for ~1000 milliseconds by checking System.currentTimeMillis() repeatedly
                    label1.setBackground(null); // restore the original color of the button
                    label1.setText("1"); // restore the original text label of the button
                }
                else if('2' == input.charAt(i)){
                    label2.setBackground(Color.yellow); // set button color to yellow
                    long  now = System.currentTimeMillis();
                    long then = now + 1000;
                    while (System.currentTimeMillis() < then){
                    }// wait for ~1000 milliseconds by checking System.currentTimeMillis() repeatedly
                    label2.setBackground(null); // restore the original color of the button
                    label2.setText("2"); // restore the original text label of the button
                }
                else if('3' == input.charAt(i)){
                    label3.setBackground(Color.yellow); // set button color to yellow
                    long  now = System.currentTimeMillis();
                    long then = now + 1000;
                    while (System.currentTimeMillis() < then){
                    }// wait for ~1000 milliseconds by checking System.currentTimeMillis() repeatedly
                    label3.setBackground(null); // restore the original color of the button
                    label3.setText("3"); // restore the original text label of the button
                }
                else if('4' == input.charAt(i)){
                    label4.setBackground(Color.yellow); // set button color to yellow
                    long  now = System.currentTimeMillis();
                    long then = now + 1000;
                    label4.setBackground(Color.yellow); // set button color to yellow
                    while (System.currentTimeMillis() < then){
                    }// wait for ~1000 milliseconds by checking System.currentTimeMillis() repeatedly
                    label4.setBackground(null); // restore the original color of the button
                    label4.setText("4"); // restore the original text label of the button
                }
            }
        }while(input != null);
    }
}