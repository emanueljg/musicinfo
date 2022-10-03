package musicinfo;
import java.util.*;

class Band extends MusicItem {
    public int bandStart;
    public int bandEnd = 0;
    public ArrayList<Artist> artists = new ArrayList<>();
    public HashMap<Artist, String> artistInstruments = new HashMap<>();
    public LinkedHashMap<Artist, ArrayList<Integer>> artistHistories = new LinkedHashMap<>();
    public ArrayList<Album> albums = new ArrayList<>();

    public Band(String name, String info, int bandStart) {
        super(name, info);
        this.bandStart = bandStart;
        register(Band.class, this);
    }

    public void setInstrument(Artist artist, String instruments){
        artistInstruments.put(artist, instruments);
    }

    public ArrayList<Integer> getArtistHistory(Artist artist) {
        if (!artistHistories.containsKey(artist)) {
            artistHistories.put(artist, new ArrayList<Integer>());
        }
        return artistHistories.get(artist);
    }

    public void addArtist(Artist artist, int year) {
        artists.add(artist);
        getArtistHistory(artist).add(year);
    }

    public void removeArtist(int i, int year) {
        Artist removed = artists.remove(i);
        getArtistHistory(removed).add(year);
    }

    public void show(){
            System.out.println(this.name + " (" + this.bandStart + " - " + this.bandEnd + ")");
            System.out.println( "\nMembers:");
            int indexMembers = 0;
            for (Artist value : artists) {
                 System.out.println("(" + indexMembers + ") " + value.name);
                 indexMembers++;
            }
            System.out.println("\nInstruments:");
            int indexInstruments = 0;
            for (Map.Entry<Artist, String> entry : artistInstruments.entrySet()) {
            System.out.print("(" + indexInstruments + ") ");
            System.out.println(entry.getKey() + " - " + entry.getValue());
            }
                System.out.println("\n" + "About:\n" + this.info);
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void removeAlbum(int i) {
        albums.remove(i);
    }


}
