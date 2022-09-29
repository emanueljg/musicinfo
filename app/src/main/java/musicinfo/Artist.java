package musicinfo;
import java.util.ArrayList;
import java.util.HashMap;

class Artist extends MusicItem {

    public static ArrayList<MusicItem> ARTISTS;
    public int birthYear;
    public ArrayList<Album> albums = new ArrayList<Album>();
    public HashMap<String, Album> albumInstruments = new HashMap<String, Album>();

    public Artist(String name, String info){
        super(name, info);

    }

    @Override
    public ArrayList<MusicItem> getItems(){
        return ARTISTS;
    }




}
