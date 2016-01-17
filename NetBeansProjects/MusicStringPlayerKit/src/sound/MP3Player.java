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
 * Implement a MP3 Player class
 *
 */

import java.io.*;                                   // for file opening and stream handling
import java.net.URL;
import javazoom.jl.player.advanced.AdvancedPlayer;  // for MP3 stream playing

/**
 * Class MP3Player encapsulates the usage of javazoom jlayer MP3 player
 * @author pffung
 */
public class MP3Player {
    private InputStream mp3Stream;

    /**
     * Default constructor does nothing
     */
    public MP3Player()
    {
        mp3Stream = null;
    }

    /**
     * Constructor with a MP3 filename
     * @param MP3Filename is a (local) MP3 sound file
     */
    public MP3Player(String MP3Filename)
    {
        try {
            mp3Stream = new FileInputStream(MP3Filename);
        }
        catch (Exception e)
        {
            MusicStringPlayer.errorReport(e);
        }
    }

    /**
     * Constructor with a MP3 URL
     * @param MP3Link is an URL to a MP3 sound file
     */
    public MP3Player(URL MP3Link)
    {
        try {
            mp3Stream = MP3Link.openStream();
        }
        catch (Exception e)
        {
            MusicStringPlayer.errorReport(e);
        }
    }

    /**
     * Play a MP3 sound stream.
     */
    public void play()
    {
        if (mp3Stream == null)
            return;
        
        try {
            // with import statement, identifier AdvancedPlayer is understood
            // otherwise, we have to write full class name like this example
            AdvancedPlayer mp3Player = new javazoom.jl.player.advanced.AdvancedPlayer(mp3Stream);
            mp3Player.play();
        }
        catch (Exception e)
        {
            MusicStringPlayer.errorReport(e);
        }
    }
}
