package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.levels.Level;

public class GameMenu extends State {

    Level level;
    private Texture bg,bglevel,close;
    private Button ext,left,right;
    private ArrayList<Button> mas;
    private Vector3 touchPos;
    public static int num,save,lm;
    private int g;
    public static Preferences Prefs = Gdx.app.getPreferences("save");

    public GameMenu(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        touchPos = new Vector3();
        mas = new ArrayList<>();
        bg = new Texture("bg.png");
        bglevel = new Texture("bglevelg.png");
        close = new Texture("level_closee.png");
        bglevel.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        close.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        ext = new Button("exte.png",10,420,50,50);
        left = new Button("leftbg.png",20,195,50,50);
        right = new Button("rightbg.png",730,195,50,50);
        Button level1 = new Button("level1e.png", 130, 295, 75, 75);
        Button level2 = new Button("level2e.png", 246, 295, 75, 75);
        Button level3 = new Button("level3e.png", 362, 295, 75, 75);
        Button level4 = new Button("level4e.png", 478, 295, 75, 75);
        Button level5 = new Button("level5e.png", 594, 295, 75, 75);
        Button level6 = new Button("level6e.png", 130, 182, 75, 75);
        Button level7 = new Button("level7e.png", 246, 182, 75, 75);
        Button level8 = new Button("level8e.png", 362, 182, 75, 75);
        Button level9 = new Button("level9e.png", 478, 182, 75, 75);
        Button level10 = new Button("levelse.png", 594, 182, 75, 75);
        /*Button level11 = new Button("level11e.png", 130, 69, 75, 75);
        Button level12 = new Button("level12e.png", 246, 69, 75, 75);
        Button level13 = new Button("level13e.png", 362, 69, 75, 75);
        Button level14 = new Button("level14e.png", 478, 69, 75, 75);
        Button level15 = new Button("level15e.png", 594, 69, 75, 75);*/
        mas.add(level1);
        mas.add(level2);
        mas.add(level3);
        mas.add(level4);
        mas.add(level5);
        mas.add(level6);
        mas.add(level7);
        mas.add(level8);
        mas.add(level9);
        mas.add(level10);
        /*mas.add(level11);
        mas.add(level12);
        mas.add(level13);
        mas.add(level14);
        mas.add(level15);*/
        g = 0;
        lm = mas.size();
        save = Prefs.getInteger("save");
        if (save == 0) {
            Prefs.putInteger("save",10);
            Prefs.flush();
            save = 10;
        }
        save = 10;
        if (save > mas.size()){
            save = mas.size();
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched() && g > 5) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            for (int i = 0; i < save; i++) {
                if (mas.get(i).rectangle.contains(touchPos.x, touchPos.y)) {
                    num = i + 1;
                    level = new Level(num);
                    gsm.push(new DialogWindow(gsm));
                }
            }
            if (ext.rectangle.contains(touchPos.x, touchPos.y)) {
                gsm.push(new StartMenu(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        g++;
        if (g > 6) g = 6;
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg,0,-30);
        sb.draw(bg,512,-30);
        sb.draw(bglevel,300,400,200,50);
        for (int i = 0; i < save; i++) {
            sb.draw(mas.get(i).texture, mas.get(i).rectangle.x, mas.get(i).rectangle.y, mas.get(i).rectangle.width, mas.get(i).rectangle.height);
        }
        for (int i = save; i < mas.size(); i++) {
            sb.draw(close, mas.get(i).rectangle.x, mas.get(i).rectangle.y, mas.get(i).rectangle.width, mas.get(i).rectangle.height);
        }
        sb.draw(ext.texture,ext.rectangle.x,ext.rectangle.y,ext.rectangle.width,ext.rectangle.height);
        sb.draw(left.texture,left.rectangle.x,left.rectangle.y,left.rectangle.width,left.rectangle.height);
        sb.draw(right.texture,right.rectangle.x,right.rectangle.y,right.rectangle.width,right.rectangle.height);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        bglevel.dispose();
        close.dispose();
        for (int i = 0; i < mas.size(); i++) {
            mas.get(i).dispose();
        }
        ext.dispose();
        left.dispose();
        right.dispose();
    }
}
