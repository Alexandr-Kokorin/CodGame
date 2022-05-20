package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level5 {
    public int[][] level = {{2, 2, 2, 2, 1,1}, {2, 10, 1,1}, {1,1}, {1}, {1}, {1}, {1}, {1}, {1}, {2,1,1}, {2,1,1}, {2,1,1}, {2,1,1}, {2,1,1}, {2,1,1,100}};
    public ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int x = 15;
    public int y = 10;
    public int px = 250;
    public int py = 100;
    public int lim = 1;
    public int lims = 1;
    public boolean isc = false;
    public boolean isd = false;
    public boolean ist = true;

    public Level5(){
        list = new ArrayList<>();
        list.add("5_1.png");
        listnum = new ArrayList<>();
        listnum.add(150);
    }
}
