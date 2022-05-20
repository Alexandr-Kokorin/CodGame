package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.button.ButtonLevel;
import infos.cod.codgame.playerLevel.SaveAndLoad;

public class PlayerLevels extends State {

    private Texture bg;
    private Button ext,codmod;
    private ArrayList<ButtonLevel> mas;
    private Vector3 touchPos;
    private int g,t,f;
    private float dy;
    private BitmapFont Font;
    private SaveAndLoad saveAndLoad;
    public static int pl;
    public static String name;

    public PlayerLevels(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        Gdx.input.setInputProcessor(new InputManager());
        touchPos = new Vector3();
        mas = new ArrayList<>();
        saveAndLoad = new SaveAndLoad();
        FileHandle file = Gdx.files.local("levels.txt");
        String s = file.readString();
        f = 0;
        int j = 0,l,k,i=0;
        String ss;
        while (s.indexOf("\n",j) != -1) {
            l = s.indexOf("\n",j);
            ss = s.substring(j,l);
            j = l+1;
            ButtonLevel buttonLevel = new ButtonLevel("plevel.png",200,350-i*75,50,50,ss);
            mas.add(buttonLevel);
            i++;
            f = 1;
        }
        t = 350-i*75;
        bg = new Texture("bg.png");
        ext = new Button("exte.png",10,420,50,50);
        codmod = new Button("plus.png", 740, 420, 50, 50);
        pl = 1;
        Font = new BitmapFont(Gdx.files.internal("comic.fnt"));
        Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched() && g > 5) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (f == 1) {
                for (int i = 0; i < mas.size(); i++) {
                    if (mas.get(i).rectangle.contains(touchPos.x, touchPos.y)) {
                        name = mas.get(i).name;
                        saveAndLoad.load(name);
                        gsm.push(new PlayGame(gsm));
                    }
                }
            }
            if (ext.rectangle.contains(touchPos.x, touchPos.y)) {
                pl = 0;
                gsm.push(new StartMenu(gsm));
            }
            if (codmod.rectangle.contains(touchPos.x, touchPos.y)) {
                pl = 0;
                gsm.push(new CreateLevel(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        if (f == 1 && mas.size() > 5) {
            for (int i = 0; i < mas.size(); i++) {
                mas.get(i).rectangle.y += -dy;
            }
            if (mas.get(0).rectangle.y < 350) {
                for (int i = 0; i < mas.size(); i++) {
                    mas.get(i).rectangle.y = 350 - i * 75;
                }
            }
            if (mas.get(mas.size() - 1).rectangle.y > 100) {
                for (int i = mas.size() - 1; i >= 0; i--) {
                    mas.get(i).rectangle.y = 100 + ((mas.size() - 1) - i) * 75;
                }
            }
        }
        dy = 0;
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
        if (f == 1) {
            for (int i = 0; i < mas.size(); i++) {
                sb.draw(mas.get(i).texture, mas.get(i).rectangle.x, mas.get(i).rectangle.y, mas.get(i).rectangle.width, mas.get(i).rectangle.height);
                Font.draw(sb, mas.get(i).name.substring(0, mas.get(i).name.length() - 4), mas.get(i).rectangle.x + 75, mas.get(i).rectangle.y + 45);
            }
        }
        sb.draw(ext.texture,ext.rectangle.x,ext.rectangle.y,ext.rectangle.width,ext.rectangle.height);
        sb.draw(codmod.texture,codmod.rectangle.x,codmod.rectangle.y,codmod.rectangle.width,codmod.rectangle.height);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        ext.dispose();
        codmod.dispose();
        if (f == 1) {
            for (int i = 0; i < mas.size(); i++) {
                mas.get(i).dispose();
            }
        }
    }

    public class InputManager implements InputProcessor {

        @Override
        public boolean keyDown(int keycode) {
            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return true;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            dy = (float)Gdx.input.getDeltaY();
            return true;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            return false;
        }

    }
}
