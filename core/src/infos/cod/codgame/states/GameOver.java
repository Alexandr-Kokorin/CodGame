package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.levels.Level;
import infos.cod.codgame.playerLevel.SaveAndLoad;

public class GameOver extends State {

    private Level level;
    private SaveAndLoad saveAndLoad;
    private Texture bg;
    private Vector3 touchPos;
    private Button com1, com2;
    private int g;

    public GameOver(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        touchPos = new Vector3();
        saveAndLoad = new SaveAndLoad();
        bg = new Texture("gameover.jpg");
        bg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        com1 = new Button("menu2.png", 175, 200, 100, 50);
        com2 = new Button("restart2.png", 300, 200, 100, 50);
        g = 0;
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched() && g > 5) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (com1.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 0) {
                gsm.push(new GameMenu(gsm));
            } else if (com1.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 1) {
                gsm.push(new PlayerLevels(gsm));
            }
            if (com2.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 0) {
                level = new Level(GameMenu.num);
                gsm.push(new PlayGame(gsm));
            } else if (com2.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 1) {
                saveAndLoad.load(PlayerLevels.name);
                gsm.push(new PlayGame(gsm));
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
        sb.draw(bg,0,0,800,480);
        sb.draw(com1.texture, com1.rectangle.x, com1.rectangle.y);
        sb.draw(com2.texture, com2.rectangle.x, com2.rectangle.y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        com1.dispose();
        com2.dispose();
    }
}
