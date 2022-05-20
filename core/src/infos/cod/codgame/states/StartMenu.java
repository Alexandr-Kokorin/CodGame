package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import infos.cod.codgame.button.Button;

public class StartMenu extends State {

    private Texture bg;
    private Button start,create;
    private Vector3 touchPos;
    private int x1,x2,x3;

    public StartMenu(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        bg = new Texture("bg.png");
        start = new Button("komp.png",175,190,200,100);
        create = new Button("create.png",425,190,200,100);
        touchPos = new Vector3();
        FileHandle file = Gdx.files.local("levels.txt");
        file.writeString("", true);
        x1=0;x2=512;x3=1024;
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (start.rectangle.contains(touchPos.x, touchPos.y)) {
                CreateLevel.cmod = 0;
                PlayerLevels.pl = 0;
                gsm.push(new GameMenu(gsm));
            }
            if (create.rectangle.contains(touchPos.x, touchPos.y)) {
                gsm.push(new PlayerLevels(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        x1--;x2--;x3--;
        if (x1 < -512) {
            x1 = x3 + 512;
        }
        if (x2 < -512) {
            x2 = x1 + 512;
        }
        if (x3 < -512) {
            x3 = x2 + 512;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg,x1,-30);
        sb.draw(bg,x2,-30);
        sb.draw(bg,x3,-30);
        sb.draw(start.texture,start.rectangle.x,start.rectangle.y,start.rectangle.width,start.rectangle.height);
        sb.draw(create.texture,create.rectangle.x,create.rectangle.y,create.rectangle.width,create.rectangle.height);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        start.dispose();
        create.dispose();
    }
}
