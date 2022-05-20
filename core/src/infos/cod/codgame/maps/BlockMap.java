package infos.cod.codgame.maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class BlockMap {

    public Texture texture, texturet, texture2, cod, codnot, codred, codgreen,star,t2,redact,bg,ship,sand,black,blue,red,bgs;
    public Rectangle rectangle;

    BlockMap() {
        texture = new Texture("dirtc.png");
        texturet = new Texture("dirtgc.png");
        texture2 = new Texture("block2c.png");
        t2 = new Texture("2c.png");
        redact = new Texture("redactc.png");
        codred = new Texture("codredc.png");
        codgreen = new Texture("codgreenc.png");
        cod = new Texture("codc.png");
        codnot = new Texture("codnot.png");
        star = new Texture("star.png");
        ship = new Texture("shipc.png");
        bg = new Texture("bg.png");
        sand = new Texture("sandc.png");
        black = new Texture("black.png");
        blue = new Texture("blue.png");
        red = new Texture("red.png");
        bgs = new Texture("bgs.png");
        bgs.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        black.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        blue.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        red.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        texturet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        texture2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        redact.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        codred.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        codgreen.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        cod.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        codnot.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        star.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        ship.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sand.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        rectangle = new Rectangle(0, 0, 50, 50);
    }

    BlockMap(float x, float y, float width, float height) {
        rectangle = new Rectangle(x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
        texturet.dispose();
        texture2.dispose();
        t2.dispose();
        redact.dispose();
        codgreen.dispose();
        codred.dispose();
        cod.dispose();
        codnot.dispose();
        star.dispose();
        ship.dispose();
        bg.dispose();
        sand.dispose();
        black.dispose();
        blue.dispose();
        red.dispose();
    }

}
