/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class SongLyric extends Song implements Serializable{
    private String singer;

    public SongLyric(String singer, String title, String filePath, int year, String author, String genre) {
        super(title, filePath, year, author, genre);
        this.singer = singer;
        setType(0);
    }
    

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

  

    
    
    
    
    

}
