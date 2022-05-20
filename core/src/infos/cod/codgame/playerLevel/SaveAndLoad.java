package infos.cod.codgame.playerLevel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import infos.cod.codgame.levels.Level;
import infos.cod.codgame.maps.Map;
import infos.cod.codgame.states.CreateLevel;

public class SaveAndLoad {

    private int mas[][];
    private int x,y,px,py,vhod,com,isc,isd,ist;

    public void save(){
        try {
            FileHandle file = Gdx.files.local(CreateLevel.name+".txt");
            file.writeString("x:"+ CreateLevel.x + "\n", false);
            file.writeString("y:"+ CreateLevel.y + "\n", true);
            file.writeString("px:"+ CreateLevel.px + "\n", true);
            file.writeString("py:"+ CreateLevel.py + "\n", true);
            file.writeString("vhod:"+ CreateLevel.vhod + "\n", true);
            file.writeString("com:"+ CreateLevel.com + "\n", true);
            file.writeString("isc:"+ CreateLevel.isc + "\n", true);
            file.writeString("isd:"+ CreateLevel.isd + "\n", true);
            file.writeString("ist:"+ CreateLevel.ist + "\n", true);
            for (int i = 0; i < CreateLevel.x; i++) {
                for (int j = 0; j < CreateLevel.y; j++) {
                    file.writeString(i + "_" + j + ":" + Map.map[i][j] + "\n", true);
                }
            }
            FileHandle level = Gdx.files.local("levels.txt");
            level.writeString(CreateLevel.name+".txt" + "\n", true);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public void load(String name){
        FileHandle file = Gdx.files.local(name);
        String s = file.readString();
        int g = 0;
        int l = s.indexOf("\n",g);
        String ss = s.substring(g,l);
        g = l+1;
        int k = ss.indexOf(":");
        x = Integer.parseInt(ss.substring(k+1));

        l = s.indexOf("\n",g);
        ss = s.substring(g,l);
        g = l+1;
        k = ss.indexOf(":");
        y = Integer.parseInt(ss.substring(k+1));

        l = s.indexOf("\n",g);
        ss = s.substring(g,l);
        g = l+1;
        k = ss.indexOf(":");
        px = Integer.parseInt(ss.substring(k+1));

        l = s.indexOf("\n",g);
        ss = s.substring(g,l);
        g = l+1;
        k = ss.indexOf(":");
        py = Integer.parseInt(ss.substring(k+1));

        l = s.indexOf("\n",g);
        ss = s.substring(g,l);
        g = l+1;
        k = ss.indexOf(":");
        vhod = Integer.parseInt(ss.substring(k+1));

        l = s.indexOf("\n",g);
        ss = s.substring(g,l);
        g = l+1;
        k = ss.indexOf(":");
        com = Integer.parseInt(ss.substring(k+1));

        l = s.indexOf("\n",g);
        ss = s.substring(g,l);
        g = l+1;
        k = ss.indexOf(":");
        isc = Integer.parseInt(ss.substring(k+1));

        l = s.indexOf("\n",g);
        ss = s.substring(g,l);
        g = l+1;
        k = ss.indexOf(":");
        isd = Integer.parseInt(ss.substring(k+1));

        l = s.indexOf("\n",g);
        ss = s.substring(g,l);
        g = l+1;
        k = ss.indexOf(":");
        ist = Integer.parseInt(ss.substring(k+1));

        mas = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    l = s.indexOf("\n",g);
                    ss = s.substring(g,l);
                    g = l+1;
                    k = ss.indexOf(":");
                    mas[i][j] = Integer.parseInt(ss.substring(k+1));
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        Level level = new Level(x,y,px,py,vhod,com,isc,isd,ist,mas);
    }
}
