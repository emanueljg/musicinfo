package musicinfo;
import java.util.ArrayList;
import java.util.HashMap;

class Artist extends MusicItem {

    public int birthYear;
    public ArrayList<Album> albums = new ArrayList<Album>();
    public HashMap<String, Album> albumInstruments = new HashMap<String, Album>();

    public Artist(String name, String info){
        super(name, info);

    }





}
