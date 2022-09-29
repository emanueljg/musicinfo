package  musicinfo;
import java.util.*;

class Band extends MusicItem {
    public static ArrayList<MusicItem> BANDS;
    public int bandStart;
    public int bandEnd;
    public ArrayList<Artist> artists;
    public HashMap<Artist, String> artistInstruments;
    public LinkedHashMap<Artist, Integer> artistHistories;
    public ArrayList<Album> albums;

    public Band(String name, String info, int bandStart, int bandEnd) {
        super(name, info);
        this.bandStart = bandStart;
        this.bandEnd = bandEnd;
        BANDS.add(this);
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
    public void setInstrument(Artist artist, String instruments){
        artistInstruments.put(artist, instruments);
    }

    public static void removeBand(int i){
        BANDS.remove(i);
    }

    public void addArtist(int i, int year) {
        Artist artist = (Artist) Artist.ARTISTS.get(i);
        artists.add(artist);
        artistHistories.put(artist,year);
    }

    public void removeArtist(int i, int year) {
        Artist removed = artists.remove(i);
        artistHistories.put(removed,year);
    }



    @Override
    public ArrayList<MusicItem> getItems(){
        return BANDS;
    }

}
