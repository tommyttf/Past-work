package sound;

/**
 * CSCI1530 Java Programming Assignment
 *
 * --- Declaration ---
 *
 * I declare that the assignment here submitted is original except for source
 * material explicitly acknowledged. I also acknowledge that I am aware of
 * University policy and regulations on honesty in academic work, and of the
 * disciplinary guidelines and procedures applicable to breaches of such policy
 * and regulations, as contained in the website
 *
 *     http://www.cuhk.edu.hk/policy/academichonesty/
 *
 * Assignment 5
 * Student Name : Tsang Ting Fung
 * Student ID   : 1155030464
 * Email Address: tommyttf0521@hotmail.com
 *
 * Music String Player Java Application Main Class
 * Designer: Michael FUNG Ping Fu
 * Date    : 24 Mar 2015
 *
 * The Main class of Music String Player.  You have to work on this class.
 *
 */

import java.net.URL;
import javax.swing.JOptionPane;

public class Main {
    /**
     * The starting point of the music string player application
     * @param args is Command Line Arguments array (unused in this application)
     */
    public static void main(String[] args) throws Exception
    {
        // repeatedly showInputDialog to get userInput
        while (true)
        {
            String userInput;
            userInput = JOptionPane.showInputDialog("<html>Input a song, e.g. DRMFSLT<p>OR say:Hello, CSCI1530 Assignment due on 8 Apr 2015<p>OR http://www.cse.cuhk.edu.hk/csci1530/asgdemo/Cantonese0-9.mp3</html>", "http://www.cse.cuhk.edu.hk/csci1530/asgdemo/Cantonese0-9.mp3");

            if (userInput == null)
                break;

            // check the userInput
            // then create different objects to handle and to play the userInput
            // for different cases
            
            if(userInput.startsWith("http://")){
                MP3Player mp3 = new MP3Player(new URL(userInput));
                mp3.play();
            }
            else if(userInput.startsWith("say:")){
                GoogleVoice voice = new GoogleVoice(userInput.substring(4));
                voice.play();
            }
            else{
                int i;
                String song = null;
                for (i = 0; i < userInput.length(); i++){
                    if(userInput.charAt(i) == 'D'||userInput.charAt(i) == 'R'||userInput.charAt(i) == 'M'||userInput.charAt(i) == 'F'||userInput.charAt(i) == 'S'||userInput.charAt(i) == 'L'||userInput.charAt(i) == 'T'){
                        song = song + userInput.charAt(i);
                    }
                }
                if (song != null) {
                    new MusicStringPlayer(song).play();
                } 
            }
        }
    }

}
