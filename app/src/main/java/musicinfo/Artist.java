package musicinfo;
import java.util.ArrayList;
import java.util.HashMap;

class Artist extends MusicItem {

    public static ArrayList<MusicItem> ARTISTS;
    public int birthYear;
    public ArrayList<Album> albums = new ArrayList<Album>();
    public HashMap<Album, String> albumInstruments = new HashMap<Album, String>();


    public Artist(String name, String info, int birthYear){
        super(name, info);
        this.birthYear = birthYear;
        ARTISTS.add(this);
    }

    @Override
    public ArrayList<MusicItem> getItems(){
        return ARTISTS;
    }

    public void addBand(int i, int year) {
        Band.BANDS.get(i).addArtist(this, year);        
    }

    public void setInstrument(Album album, String instruments){
        albumInstruments.put(album, instruments);
    }



    public static void removeArtist(int i) {
        ARTISTS.remove(i);
    }


}
