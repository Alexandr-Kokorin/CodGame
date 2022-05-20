package infos.cod.codgame.levels;

import java.util.ArrayList;

public class Level1 {
    public int[][] level = {{2, 2, 2, 2, 1,1}, {2, 2, 1,1}, {1,1}, {1}, {1}, {1}, {1}, {1}, {1}, {2,2,1,1}, {2,2,1,1,10}, {2,2,1,1}, {2,2,1,1}, {2,2,1,1}, {2,2,1,1,100}};
    public ArrayList<String> list;
    public ArrayList<Integer> listnum;
    public int x = 15;
    public int y = 10;
    public int px = 250;
    public int py = 100;
    public int lim = 2;
    public int lims = 1;
    public boolean isc = true;
    public boolean isd = false;
    public boolean ist = false;

    public Level1(){
        list = new ArrayList<>();
        list.add("1_1.png");
        list.add("1_2.png");
        list.add("1_3.png");
        list.add("1_4.png");
        list.add("1_5.png");
        listnum = new ArrayList<>();
        listnum.add(200);
        listnum.add(200);
        listnum.add(200);
        listnum.add(200);
        listnum.add(150);
    }
}
