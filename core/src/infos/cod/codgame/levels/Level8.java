package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level8 {
    public int[][] level = {{2, 2, 2, 2, 1,1}, {2, 2, 1,1}, {1,1}, {1}, {1}, {1}, {1,0,0,0,0,2}, {1,0,0,0,2}, {2,2,4,4,4,2}, {100,0,0,0,0,2,2}, {100,0,0,0,0,2,2}, {2,2,4,4,4,2}, {1,0,0,0,2}, {1,0,0,0,0,2}, {1}};
    ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int x = 15;
    public int y = 10;
    public int px = 250;
    public int py = 100;
    public int lim = 3;
    public int lims = 1;
    public boolean isc = true;
    public boolean isd = true;
    public boolean ist = true;

    public Level8(){
        list = new ArrayList<>();
        list.add("8_1.png");
        listnum = new ArrayList<>();
        listnum.add(150);
    }
}
