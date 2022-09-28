package  musicinfo;
import java.util.*;

class Band extends MusicItem {
    public int bandStart;
    public int bandEnd;
    public ArrayList<Artist> artists;
    public HashMap<String, Artist> artistInstruments;
    public LinkedHashMap<Artist, Integer> artistHistories;
    public ArrayList<Album> albums;

    public Band(String name, String info) {
        super(name, info);
    }

    public ArrayList<Integer> getArtistHistory(Artist artist) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (Map.Entry<Artist, Integer> i : artistHistories.entrySet()) {
            if (i.getKey().equals(artist)) {
                values.add(i.getValue());
            }
        }
        return values;
    }
}
