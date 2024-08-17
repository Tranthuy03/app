/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import java.io.Serializable;
  public class InstrumentMusic extends Song implements Serializable {
        private String instrument;
        private String artist;

    public InstrumentMusic(String instrument, String artist, String title, String filePath, int year, String author, String genre) {
        super(title, filePath, year, author, genre);
        this.instrument = instrument;
        this.artist = artist;
        setType(1);
    }

        

        public String getInstrument() {
            return instrument;
        }

        public void setInstrument(String instrument) {
            this.instrument = instrument;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }
   

        

        


    }


       


       
    
