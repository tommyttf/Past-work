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
 * Music String Player Java Application
 * Designer: Michael FUNG Ping Fu
 * Date    : 24 Mar 2015
 *  
 * Implement a Music String Player.  You have to work on this class.
 * 
 */

import javax.swing.JOptionPane;

/**
 * Music String Player Application.
 */
public class MusicStringPlayer {
    
    /** declare field(s) here for storing a song String */
    private String str = null;

    /**
     * MusicStringPlayer Constructor
     * @param song is a music String
     */
    public MusicStringPlayer(String song){
        str = song;
    }

    /**
     * Method...
     * Play a song according to the music string.
     * You may make use of the AdvancedPlayer from the jLayer library
     */
    public void play(){
        int i;
        MP3Player mp3;
        for(i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            switch(c){
                case 'D':
                    mp3 = new MP3Player("D.mp3");
                    mp3.play();
                    break;
                case 'R':
                    mp3 = new MP3Player("R.mp3");
                    mp3.play();
                    break;
                case 'M':
                    mp3 = new MP3Player("M.mp3");
                    mp3.play();
                    break;
                case 'F':
                    mp3 = new MP3Player("F.mp3");
                    mp3.play();
                    break;
                case 'S':
                    mp3 = new MP3Player("S.mp3");
                    mp3.play();
                    break;
                case 'L':
                    mp3 = new MP3Player("L.mp3");
                    mp3.play();
                    break;
                case 'T':
                    mp3 = new MP3Player("T.mp3");
                    mp3.play();
                    break;
            }
        }
    }

    
    /**
     * Error reporting
     * @param e is an Exception object reference
     */
    public static void errorReport(Exception e)
    {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, e.toString());
    }
}
