package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level4 {
    public int[][] level = {{2, 2, 2, 2, 2, 2, 1, 1,0,10}, {2, 2, 2, 2, 2, 2, 1, 1}, {2, 2, 2, 2, 1, 1}, {2, 2, 2, 2, 1, 1}, {2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1, 1, 100, 100}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1, 1, 100, 100}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {2, 2, 2, 2, 1, 1}, {2, 2, 2, 2, 1, 1}, {2, 2, 2, 2, 2, 2, 1, 1}, {2, 2, 2, 2, 2, 2, 1, 1,0,10}};
    ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int x = 20;
    public int y = 20;
    public int px = 485;
    public int py = 100;
    public int lim = 5;
    public int lims = 2;
    public boolean isc = true;
    public boolean isd = true;
    public boolean ist = false;

    public Level4(){
        list = new ArrayList<>();
        list.add("4_1.png");
        listnum = new ArrayList<>();
        listnum.add(150);
    }
}
