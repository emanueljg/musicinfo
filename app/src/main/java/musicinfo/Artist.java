package musicinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

class Artist extends MusicItem {

    public int birthYear;
    public ArrayList<Album> albums = new ArrayList<Album>();
    public HashMap<Album, String> albumInstruments = new HashMap<Album, String>();


    public Artist(String name, String info, int birthYear){
        super(name, info);
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

    public void addAlbum(int i) {
        Album album = (Album) getFromRegistry(Album.class, i);
        albums.add(album);
    }

    public void removeAlbum(int i) {
        albums.remove(i);
    }

    public void setInstrument(Album album, String instruments){
        albumInstruments.put(album, instruments);
    }

}
