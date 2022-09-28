package  musicinfo;
import java.util.*;

class Band {   // D skriver in de sista 5
    public String name;
    public String infoText;
    public int bandStart;
    public int bandEnd;
    public ArrayList<Artist> artists;
    public HashMap<Integer, Artist> artistJoinYear;
    public HashMap<String, Artist> artistInstruments;
    public ArrayList<Artist> oldArtist;
    public HashMap<Integer, Artists> oldArtistLeaveYears;
    public ArrayList<Album> albums;
}
