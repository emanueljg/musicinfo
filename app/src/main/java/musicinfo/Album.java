package musicinfo;

import java.util.ArrayList;

class Album extends MusicItem {
    public int releaseYear;


    public Album(String name, int releaseYear){
        super(name);
        this.releaseYear = releaseYear;
        register(Album.class, this);
    }
}
