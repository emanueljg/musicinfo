package musicinfo;


import java.util.ArrayList;

public abstract class MusicItem {

    public String name;
    public String info;



    public MusicItem(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public abstract ArrayList<MusicItem> getItems();









}
