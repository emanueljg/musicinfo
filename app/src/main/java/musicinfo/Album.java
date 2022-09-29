package  musicinfo;

import java.util.ArrayList;

class Album extends MusicItem {
    public static ArrayList<MusicItem> ALBUMS;
    public int releaseYear;


    public Album(String name, String info, int releaseYear){
        super(name, info);
        this.releaseYear = releaseYear;
    }

    @Override
    public ArrayList<MusicItem> getItems(){
        return ALBUMS;
    }

    public void removeAlbum(int i) {
        ALBUMS.remove(i);
    }
}
