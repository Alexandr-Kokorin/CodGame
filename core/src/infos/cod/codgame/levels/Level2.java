package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level2 {
    public int[][] level = {{2, 2, 2, 2, 1,1}, {2, 2, 1,1}, {1,1}, {1}, {1}, {1}, {1}, {1,1,0,0,0,0,0,2}, {1,2,2,2,2,2,2,2}, {1,2,2,2,2,2,2,2}, {1,1,0,0,0,0,0,2}, {1}, {1,10}, {1}, {1,100}};
    ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int x = 15;
    public int y = 10;
    public int px = 250;
    public int py = 100;
    public int lim = 2;
    public int lims = 1;
    public boolean isc = false;
    public boolean isd = true;
    public boolean ist = false;

    public Level2(){
        list = new ArrayList<>();
        list.add("2_1.png");
        listnum = new ArrayList<>();
        listnum.add(150);
    }
}
