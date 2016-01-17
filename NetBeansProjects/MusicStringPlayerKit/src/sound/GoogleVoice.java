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
 * Music String Player
 * Designer: Michael FUNG Ping Fu
 * Date    : 24 Mar 2015
 *
 * Implement a speech synthesis tool using Google online services
 *
 */

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class GoogleVoice {
    private static String GoogleTranslateURL = "http://translate.google.com/translate_tts?tl=en&q=";
    private String queryString;
    
    public GoogleVoice(String words)
    {
        queryString = words.replace(' ', '+');
    }
    
    public void play()
    {
        try {
            URL link = new URL(GoogleTranslateURL + queryString);

            // imports and exception handling statements...
            URLConnection connection = link.openConnection();

            // simulate a browser to make a proper identification to Google 
            connection.setRequestProperty("User-Agent", "Mozilla/4.0" + 
                        "(compatible; MSIE 6.0; Windows NT 5.1; .NET CLR 1.0.3705; " + 
                        ".NET CLR 1.1.4322; .NET CLR 1.2.30703)");
            connection.setReadTimeout(3000);                          // give Google 3 sec
            connection.connect(); 

            InputStream mp3Stream = connection.getInputStream();
            AdvancedPlayer mp3Player = new AdvancedPlayer(mp3Stream); // jLayer JAR library
            mp3Player.play();                                         // from JavaZOOM
        }
        catch (Exception e)
        {
            MusicStringPlayer.errorReport(e);
        }
    }
}
