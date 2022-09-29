package musicinfo;
import java.util.ArrayList;
import java.util.HashMap;

class Artist extends MusicItem {

    public int birthYear;
    public ArrayList<Album> albums = new ArrayList<Album>();
    public HashMap<Album, String> albumInstruments = new HashMap<Album, String>();


    public Artist(String name, String info){
        super(name, info);

    }

    public void setInstrument(Album album, String instruments){
        albumInstruments.put(album, instruments);
    }


}
