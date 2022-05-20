package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import infos.cod.codgame.levels.Level;

public class DialogWindow extends State {

    private int g,k,h,r;
    private Texture bg;
    private ArrayList<Texture> list;

    public DialogWindow(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        camera.position.set(400,240,0);
        bg = new Texture("bg.png");
        list = new ArrayList<>();
        for (int i = 0; i < Level.list.size(); i++) {
            Texture t = new Texture(Level.list.get(i));
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            list.add(t);
        }
        g = 0;
        k = 1;
        h = 100;
        r = 0;
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched() && g > 10 && k >= list.size()) {
            gsm.push(new PlayGame(gsm));
        }
        if (Gdx.input.isTouched() && g > 10 && k < list.size()) {
            k++;
            g = 0;
            r = r -(Level.listnum.get(k-1)-h);
            h = h / 100;
        }
        if (r < 0){
            camera.translate(0, -4);
            r = r + 4;
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        if (g > 11) g = 11;
        g++;
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg,0,camera.position.y-270);
        sb.draw(bg,512,camera.position.y-270);
        int l = 0;
        for (int i = 0; i < k; i++) {
            l = l + Level.listnum.get(i) + 30;
            sb.draw(list.get(i),50,460-l);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).dispose();
        }
    }
}
