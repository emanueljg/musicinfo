package musicinfo;

import java.util.ArrayList;

class Album extends MusicItem {
    public int releaseYear;


    public Album(String name, String info, int releaseYear){
        super(name, info);
        this.releaseYear = releaseYear;
        register(Album.class, this);
    }
}
