package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level6 {
    public int[][] level = {{2, 2, 2, 2, 1,1}, {2, 2, 1,1}, {1,1}, {1}, {1}, {1}, {1}, {1}, {1}, {2,2,2,1,1}, {2,9}, {2,9,0,10}, {2,9}, {2,2,2,1,1}, {2,2,2,1,1}, {2,2,2,1,1,100}, {2,2,2,1,1}, {2,2,2,1,1,10}, {2,2,2,2,1,1}, {2,2,2,2,2,2,1,1}};
    public ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int x = 20;
    public int y = 10;
    public int px = 250;
    public int py = 100;
    public int lim = 8;
    public int lims = 1;
    public boolean isc = true;
    public boolean isd = true;
    public boolean ist = false;

    public Level6(){
        list = new ArrayList<>();
        list.add("6_1.png");
        listnum = new ArrayList<>();
        listnum.add(150);
    }
}
