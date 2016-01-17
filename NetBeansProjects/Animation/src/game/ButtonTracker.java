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


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class ButtonTracker implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent eventObject ) {
        buttonClicked( (JButton)( eventObject.getSource() ) );
    }
    
    public static void buttonClicked(JButton b){
        System.out.println( b.getText() ); // you shall see the clicked text label
        Color c;
        c = b.getBackground();
        // compare c with Color.yellow, see if the clicked button is highlighted or not
        if (c == Color.yellow){
            b.setBackground(Color.red); // show red on Bingo!
            b.setText("Bingo!"); // show Bingo! (text will be restored in main())
        }
    }
}
