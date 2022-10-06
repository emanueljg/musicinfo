package musicinfo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

class Artist extends MusicItem {

    public int birthYear;
    public ArrayList<Album> albums = new ArrayList<Album>();
    public HashMap<Album, String> albumInstruments = new HashMap<Album, String>();


    public Artist(String name, int birthYear){
        super(name);
        this.birthYear = birthYear;
        register(Artist.class, this);
    }

    /*public int myOwnIndex() {
        return getRegistryOf(Artist.class).indexOf(this);
    }

    public void addBand(int i, int year) {
        Band band = (Band) getFromRegistry(Band.class, i);
        band.addArtist(myOwnIndex(), year);        
    }

    public void removeBand(int i, int year) {
        Band band = (Band) getFromRegistry(Band.class, i);
        band.removeArtist(myOwnIndex(), year);
    }*/

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void removeAlbum(int i) {
        Album album = albums.remove(i);
        albumInstruments.remove(album);
    }

    public void setInstrument(Album album, String instruments){
        albumInstruments.put(album, instruments);
    }

    public void show(){
        System.out.println(this.name + " (" + this.birthYear + ")");
        LocalDate myObj = LocalDate.now();
        int Year = myObj.getYear();
        System.out.println("Age: " + (Year - birthYear) +" years old");

        System.out.println("\n" + this.name + " is a member of the following bands:");
        int artistCounter = 1;
        for (MusicItem musicItem : MusicItem.getRegistryOf(Band.class)) {
            Band band = (Band) musicItem;
            if (band.artists.contains(this)) {
                System.out.println("(" + artistCounter + ") " + band.name);
                artistCounter++;
            }
        }
        System.out.println("\n" + "About:\n" + this.info);
        }



    }





