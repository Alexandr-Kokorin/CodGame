package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level9 {
    public int[][] level = {{2}, {2}, {2}, {2}, {2}, {2}, {2,0,0,0,0,2,4,4,4,4}, {2,0,0,0,2,4,4,4,2,4,4}, {2,0,0,2,4,4,0,0,0,2,4,4,4,4}, {2,0,2,4,0,0,0,0,0,0,2,4,4,4,4,4,4}, {2,0,0,0,0,0,0,2,10}, {2,0,0,0,0,0,0,2,100}, {2}, {2}, {2}};
    ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int x = 15;
    public int y = 20;
    public int px = 200;
    public int py = 100;
    public int lim = 4;
    public int lims = 2;
    public boolean isc = true;
    public boolean isd = true;
    public boolean ist = false;

    public Level9(){
        list = new ArrayList<>();
        list.add("9_1.png");
        listnum = new ArrayList<>();
        listnum.add(150);
    }
}
