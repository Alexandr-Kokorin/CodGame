package infos.cod.codgame.levels;

import java.util.ArrayList;

import infos.cod.codgame.cod.Cods;
import infos.cod.codgame.maps.BankBlock;
import infos.cod.codgame.maps.Map;
import infos.cod.codgame.person.Person;

public class Level {

    Map map;
    Cods cods;
    BankBlock bankblock;
    Person person;
    public static int col, lim, comp;
    public static ArrayList<String> list;
    public static ArrayList<Integer> listnum;
    public static boolean isd,isc,ist;

    public Level(int a) {
        switch (a) {
            case 1:
                Level1 level1 = new Level1();
                map = new Map(level1.x, level1.y, level1.level);
                cods = new Cods(level1.lim);
                lim = level1.lims;
                person = new Person(level1.px,level1.py);
                list = new ArrayList<>(level1.list);
                listnum = new ArrayList<>(level1.listnum);
                isd = level1.isd;
                isc = level1.isc;
                ist = level1.ist;
                break;
            case 2:
                Level2 level2 = new Level2();
                map = new Map(level2.x, level2.y, level2.level);
                cods = new Cods(level2.lim);
                lim = level2.lims;
                person = new Person(level2.px,level2.py);
                list = new ArrayList<>(level2.list);
                listnum = new ArrayList<>(level2.listnum);
                isd = level2.isd;
                isc = level2.isc;
                ist = level2.ist;
                break;
            case 3:
                Level3 level3 = new Level3();
                map = new Map(level3.x, level3.y, level3.level);
                cods = new Cods(level3.lim);
                lim = level3.lims;
                person = new Person(level3.px,level3.py);
                list = new ArrayList<>(level3.list);
                listnum = new ArrayList<>(level3.listnum);
                isd = level3.isd;
                isc = level3.isc;
                ist = level3.ist;
                break;
            case 4:
                Level4 level4 = new Level4();
                map = new Map(level4.x, level4.y, level4.level);
                cods = new Cods(level4.lim);
                lim = level4.lims;
                person = new Person(level4.px,level4.py);
                list = new ArrayList<>(level4.list);
                listnum = new ArrayList<>(level4.listnum);
                isd = level4.isd;
                isc = level4.isc;
                ist = level4.ist;
                break;
            case 5:
                Level5 level5 = new Level5();
                map = new Map(level5.x, level5.y, level5.level);
                cods = new Cods(level5.lim);
                lim = level5.lims;
                person = new Person(level5.px,level5.py);
                list = new ArrayList<>(level5.list);
                listnum = new ArrayList<>(level5.listnum);
                isd = level5.isd;
                isc = level5.isc;
                ist = level5.ist;
                break;
            case 6:
                Level6 level6 = new Level6();
                map = new Map(level6.x, level6.y, level6.level);
                cods = new Cods(level6.lim);
                lim = level6.lims;
                person = new Person(level6.px,level6.py);
                list = new ArrayList<>(level6.list);
                listnum = new ArrayList<>(level6.listnum);
                isd = level6.isd;
                isc = level6.isc;
                ist = level6.ist;
                break;
            case 7:
                Level7 level7 = new Level7();
                map = new Map(level7.x, level7.y, level7.level);
                cods = new Cods(level7.lim);
                lim = level7.lims;
                person = new Person(level7.px,level7.py);
                list = new ArrayList<>(level7.list);
                listnum = new ArrayList<>(level7.listnum);
                isd = level7.isd;
                isc = level7.isc;
                ist = level7.ist;
                break;
            case 8:
                Level8 level8 = new Level8();
                map = new Map(level8.x, level8.y, level8.level);
                cods = new Cods(level8.lim);
                lim = level8.lims;
                person = new Person(level8.px,level8.py);
                list = new ArrayList<>(level8.list);
                listnum = new ArrayList<>(level8.listnum);
                isd = level8.isd;
                isc = level8.isc;
                ist = level8.ist;
                break;
            case 9:
                Level9 level9 = new Level9();
                map = new Map(level9.x, level9.y, level9.level);
                cods = new Cods(level9.lim);
                lim = level9.lims;
                person = new Person(level9.px,level9.py);
                list = new ArrayList<>(level9.list);
                listnum = new ArrayList<>(level9.listnum);
                isd = level9.isd;
                isc = level9.isc;
                ist = level9.ist;
                break;
            case 10:
                Level10 level10 = new Level10();
                map = new Map(level10.x, level10.y, level10.level);
                cods = new Cods(level10.lim);
                lim = level10.lims;
                person = new Person(level10.px,level10.py);
                list = new ArrayList<>(level10.list);
                listnum = new ArrayList<>(level10.listnum);
                isd = level10.isd;
                isc = level10.isc;
                ist = level10.ist;
                break;
        }
        bankblock = new BankBlock();
        col = 0;
    }

    public Level(int px,int py,int vhod,int com,int isc,int isd,int ist){
        cods = new Cods(com);
        lim = vhod;
        person = new Person(px,py);
        if (isc == 1) {Level.isc = true;} else {Level.isc = false;}
        if (isd == 1) {Level.isd = true;} else {Level.isd = false;}
        if (ist == 1) {Level.ist = true;} else {Level.ist = false;}
        col = 0;
    }

    public Level(int x,int y,int px,int py,int vhod,int com,int isc,int isd,int ist,int[][] mas){
        map = new Map(x, y, mas);
        cods = new Cods(com);
        lim = vhod;
        person = new Person(px,py);
        if (isc == 1) {Level.isc = true;} else {Level.isc = false;}
        if (isd == 1) {Level.isd = true;} else {Level.isd = false;}
        if (ist == 1) {Level.ist = true;} else {Level.ist = false;}
        col = 0;
        bankblock = new BankBlock();
    }
}
