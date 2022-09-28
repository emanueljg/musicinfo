package  musicinfo;
import java.util.*;

class Band extends MusicItem{
    public int bandStart;
    public int bandEnd;
    public ArrayList<Artist> artists;
    public HashMap<Integer, Artist> artistJoinYear;
    public HashMap<String, Artist> artistInstruments;
    public ArrayList<Artist> oldArtist;
    public HashMap<Integer, Artist> oldArtistLeaveYears;
    public ArrayList<Album> albums;

    public Band(String name, String info){
        super(name, info);


    }

}
