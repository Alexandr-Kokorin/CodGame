package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level7 {
    public int[][] level = {{2, 2, 2, 2,2, 2,1}, {2, 2, 2, 2,2, 2,1}, {2, 2, 2, 2,2, 2,1}, {2, 2, 2, 2,2, 2,1}, {2, 2, 2, 2,2, 2}, {2, 2, 2, 2,2}, {2, 2, 2, 2,0,0,1,1}, {2, 2, 2,0,0,2,2,2,1,1}, {2, 2,0,0,2,2,2,2,2,2,1,1}, {2, 2,0,0,2,2,2,2,2,2,1,1}, {2, 2,0,0,0,2,2,2,2,2,1,1,10}, {2,2,2,2,0,0,1,9,0,0,1,1}, {2,2,9,0,0,0,1,9,0,0,0,1}, {2,2,9,0,0,0,1,9}, {2,2,2,2,10,0,1,9}, {2,2,9,0,0,0,8}, {2,2,9,0,0,0,8}, {2,2,9,0,0,0,8}, {2,2,9,0,0,0,8}, {2,2,9,0,0,0,8,0,1}, {2, 2, 2, 2,2, 2,2,1,1}, {2, 2, 2, 2,2, 2,1,1}, {2, 2, 2, 2,2, 2,1}, {2, 2, 2, 2,2, 2,1}, {2, 2, 2, 2,2, 2,1,100}};
    public ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int x = 25;
    public int y = 16;
    public int px = 100;
    public int py = 400;
    public int lim = 4;
    public int lims = 3;
    public boolean isc = true;
    public boolean isd = true;
    public boolean ist = false;

    public Level7(){
        list = new ArrayList<>();
        list.add("7_1.png");
        listnum = new ArrayList<>();
        listnum.add(150);
    }
}
