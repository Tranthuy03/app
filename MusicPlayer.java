/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;


import java.io.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

/**
 *
 * @author asus
 */
public class MusicPlayer {

    static MusicPlayer player = new MusicPlayer();
    static Clip clip;

    public static MusicPlayer getInstance() {
        return player;
    }

    private MusicPlayer() {
    }

    public static void loadMusic(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(ais);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load music" + e.getMessage());
        }
    }
}
