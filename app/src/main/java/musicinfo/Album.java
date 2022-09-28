package  musicinfo;

class Album extends MusicItem {
    public int releaseYear;


    public Album(String name, String info, int releaseYear){
        super(name, info);
        this.releaseYear = releaseYear;


    }
}
