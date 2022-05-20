package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level3 {
    public int[][] level = {{2, 2, 2, 2, 2, 1, 1}, {2, 2, 2, 1, 1}, {2, 1, 1}, {1, 1}, {1}, {1}, {1}, {1}, {1}, {1, 1}, {2, 1, 1}, {2, 2, 2, 1, 1}, {2, 2, 2, 2, 1, 1,10}, {2, 2, 2, 1, 1}, {2, 1, 1}, {1, 1}, {1}, {1}, {1}, {1, 100}};
    public int x = 20;
    public ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int y = 10;
    public int px = 300;
    public int py = 100;
    public int lim = 5;
    public int lims = 1;
    public boolean isc = true;
    public boolean isd = true;
    public boolean ist = false;

    public Level3(){
        list = new ArrayList<>();
        list.add("3_1.png");
        listnum = new ArrayList<>();
        listnum.add(150);
    }
}
