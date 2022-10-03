package musicinfo;

import static java.util.Map.entry;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.*;

public class App {
    public static String type = "(band|artist|album)";
    public static String name = "([ a-zA-Z0-9.]+?)";
    public static String n = "(\\d+)";
    public static Map<String, Class<? extends MusicItem>> strToTypes = Map.of(
        "band", Band.class,
        "artist", Artist.class,
        "album", Album.class
    );

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) { 
            String input = in.nextLine();
            for (Map.Entry<String, Consumer<Matcher>> cmd : cmds.entrySet()) {
                Matcher m = Pattern.compile(cmd.getKey()).matcher(input);
                if (m.matches()) { 
                    cmd.getValue().accept(m);
                    break;
                }
            }
        }
    }

    public static Map<String, Consumer<Matcher>> cmds = Map.ofEntries(
        entry("help", m -> { return; }),
        entry("save " + name, m -> MusicItem.serialize(m.group(1))),
        entry("load " + name, m -> MusicItem.deserialize(m.group(1))),

        entry("list " + type, m -> {
            Class<? extends MusicItem> type = strToTypes.get(m.group(1));
            MusicItem.enumerate(MusicItem.getRegistryOf(type));
        }),

        entry(String.format("new band %s %s", name, n, n), m -> 
            new Band(m.group(1), "", toInt(m.group(2)))
        ),

        entry(String.format("new artist %s %s", name, n), m ->
            new Artist(m.group(1), "", toInt(m.group(2)))
        ),

        entry(String.format("new album %s %s", name, n), m ->
            new Album(m.group(1), "", toInt(m.group(2)))
        ),

        entry(String.format("delete band %s", n), m ->
            MusicItem.unregister(Band.class, toInt(m.group(1)))
        ),

        entry(String.format("delete artist %s", n), m -> {
            Artist artist = (Artist) MusicItem.unregister(Artist.class, toInt(m.group(1)));
            for (MusicItem musicItem : MusicItem.getRegistryOf(Band.class)) {
                Band band = (Band) musicItem;
                band.artists.remove(artist);
                band.artistHistories.remove(artist);
                band.artistInstruments.remove(artist);
            }
        }),

        entry(String.format("delete album %s", n), m -> {
            Album album = (Album) MusicItem.unregister(Album.class, toInt(m.group(1)));
            for (MusicItem musicItem : MusicItem.getRegistryOf(Band.class)) {
                Band band = (Band) musicItem;
                band.albums.remove(album);
            } 
            for (MusicItem musicItem : MusicItem.getRegistryOf(Artist.class)) {
                Artist artist = (Artist) musicItem;
                artist.albums.remove(album);
                artist.albumInstruments.remove(album);
            }
        }),

        entry(String.format("set %s %s info %s", type, n, name), m -> {
            Class<? extends MusicItem> type = strToTypes.get(m.group(1));
            MusicItem.getFromRegistry(type, toInt(m.group(2))).info = m.group(3);
        }),

        entry(String.format("artist %s join %s in %s", n, n, n), m -> {
            Artist artist = (Artist) MusicItem.getFromRegistry(Artist.class, toInt(m.group(1)));
            Band band = (Band) MusicItem.getFromRegistry(Band.class, toInt(m.group(2)));
            int year = toInt(m.group(3));
            band.addArtist(artist, year);
        }),

        entry(String.format("show band %s", n), m -> {
            Band band = (Band) MusicItem.getFromRegistry(Band.class, toInt(m.group(1)));
            band.show();
        })
    );
}

