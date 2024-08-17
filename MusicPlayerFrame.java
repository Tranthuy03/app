/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;


import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author asus
 */
public class MusicPlayerFrame extends javax.swing.JFrame {
    
    private Clip clip;
    private boolean isDragging = false;
    private boolean isPlaying = false;
    private boolean isLooping = false;
    private long clipTimePosition = 0;
    
    static MusicPlayer player = MusicPlayer.getInstance();
    static String filePath;
 
  
    
    public MusicPlayerFrame(Song song) {
        initComponents();


        try {
            File audioFile = new File(song.getFilePath());
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);

            // Đặt giá trị tối đa của slider
            slider1.setMaximum((int) (clip.getMicrosecondLength() / 1000));

            // Cập nhật vị trí slider mỗi giây
            Timer timer = new Timer(1000, e -> {
                if (!isDragging) {
                    slider1.setValue((int) (clip.getMicrosecondPosition() / 1000));
                }
            });
            timer.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        


//        // Hành động thay đổi giá trị slider
//        slider1.addChangeListener(e -> {
//            if (clip != null && !isDragging) {
//                clip.setMicrosecondPosition(slider1.getValue() * 1000);
//            }
//        });
//
//        // Xử lý sự kiện kéo slider
//        slider1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                isDragging = true;
//            }
//            
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                isDragging = false;
//                if (clip != null) {
//                    clip.setMicrosecondPosition(slider1.getValue() * 1000);
//                }
//            }
//        });

        // Thêm chức năng nhảy đến đoạn khác trong bài nhạc
//        slider1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (clip != null) {
//                    int mouseX = e.getX();
//                    int sliderValue = (int) ((mouseX / (double) slider1.getWidth()) * slider1.getMaximum());
//                    slider1.setValue(sliderValue);
//                    clip.setMicrosecondPosition(slider1.getValue() * 1000);
//                }
//            }
//        });
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        slider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        PauseAndPlayBotton = new javax.swing.JButton();
        LoopButtom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        slider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider1StateChanged(evt);
            }
        });
        slider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slider1MouseDragged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(slider1, gridBagConstraints);

        jLabel1.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jLabel1, gridBagConstraints);

        PauseAndPlayBotton.setText("play");
        PauseAndPlayBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseAndPlayBottonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 18, 18);
        getContentPane().add(PauseAndPlayBotton, gridBagConstraints);

        LoopButtom.setText("loop");
        LoopButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoopButtomActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 18, 18);
        getContentPane().add(LoopButtom, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void slider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider1MouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_slider1MouseDragged

    private void slider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider1StateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_slider1StateChanged

    private void PauseAndPlayBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseAndPlayBottonActionPerformed
       // Đây là phương thức cho sự kiện nhấn nút
    if (clip != null) {
        if (isPlaying) {
            // Nếu đang phát, dừng lại
            clipTimePosition = clip.getMicrosecondPosition(); // Lưu vị trí hiện tại
            clip.stop(); // Dừng âm thanh
            isPlaying = false; // Đặt trạng thái không phát
            PauseAndPlayBotton.setText("▶︎"); // Thay đổi văn bản của nút để hiển thị trạng thái Play
        } else {
            // Nếu đang dừng, phát tiếp
            clip.setMicrosecondPosition(clipTimePosition); // Đặt lại vị trí hiện tại
            clip.start(); // Bắt đầu phát âm thanh
            isPlaying = true; // Đặt trạng thái là đang phát
            PauseAndPlayBotton.setText("❚❚"); // Thay đổi văn bản của nút để hiển thị trạng thái Pause
        }
    }
    }//GEN-LAST:event_PauseAndPlayBottonActionPerformed

    private void LoopButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoopButtomActionPerformed
        if (clip != null) {
            if (!isLooping) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                LoopButtom.setText("Stop Looping");
            } else {
                clip.loop(0);
                LoopButtom.setText("↻");
            }
            isLooping = !isLooping;
        }
    }//GEN-LAST:event_LoopButtomActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoopButtom;
    private javax.swing.JButton PauseAndPlayBotton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider slider1;
    // End of variables declaration//GEN-END:variables
}
