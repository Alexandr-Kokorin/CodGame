package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.levels.Level;

public class LevelComplate extends State {

    Level level;
    private Texture bg;
    private Vector3 touchPos;
    private Button com1, com2, com3;
    private int g;

    public LevelComplate(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        touchPos = new Vector3();
        bg = new Texture("bg.png");
        com1 = new Button("menu.png", 125, 190, 150, 100);
        com2 = new Button("restart.png", 325, 190, 150, 100);
        if (Level.comp == 1)
        com3 = new Button("next.png", 525, 190, 150, 100);
        if (Level.comp == 0)
        com3 = new Button("cont.png", 525, 190, 150, 100);
        g = 0;
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched() && g > 5) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (com1.rectangle.contains(touchPos.x, touchPos.y)) {
                gsm.push(new GameMenu(gsm));
            }
            if (com2.rectangle.contains(touchPos.x, touchPos.y)) {
                level = new Level(GameMenu.num);
                gsm.push(new PlayGame(gsm));
            }
            if (com3.rectangle.contains(touchPos.x, touchPos.y)) {
                if (Level.comp == 1) {
                    if (GameMenu.num < GameMenu.lm) {
                        GameMenu.num++;
                        level = new Level(GameMenu.num);
                        gsm.push(new DialogWindow(gsm));
                    } else {
                        gsm.push(new GameMenu(gsm));
                    }
                }
                else gsm.push(new PlayGame(gsm));
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
        sb.draw(com1.texture, com1.rectangle.x, com1.rectangle.y);
        sb.draw(com2.texture, com2.rectangle.x, com2.rectangle.y);
        sb.draw(com3.texture, com3.rectangle.x, com3.rectangle.y);
        sb.end();
    }

    @Override
    public void dispose() {
        com1.dispose();
        com2.dispose();
        com3.dispose();
        bg.dispose();
    }
}
