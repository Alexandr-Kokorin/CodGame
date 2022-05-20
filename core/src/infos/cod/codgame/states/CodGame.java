package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.cod.CodInput;
import infos.cod.codgame.cod.CodMapRender;
import infos.cod.codgame.cod.Cods;
import infos.cod.codgame.levels.Level;
import infos.cod.codgame.maps.BankBlock;
import infos.cod.codgame.maps.Map;

public class CodGame extends State {

    private Vector3 tempUp,tempDown,tempDrag,dr;
    private float g;
    private int f;
    private Texture bgcom,bgcod;
    private Button com1, com2, com3, com4, run, esc;
    private CodMapRender codmaprender;
    private CodInput codinput;
    private BitmapFont Font;

    CodGame(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        camera.position.set(400, 240, 0);
        Gdx.input.setInputProcessor(new InputManager());
        codinput = new CodInput();
        codmaprender = new CodMapRender();
        tempUp = new Vector3();
        tempDown = new Vector3();
        tempDrag = new Vector3();
        dr = new Vector3();
        Cods.reset();
        Font = new BitmapFont();
        Font.setColor(Color.WHITE);
        Font.getData().setScale(1.25f);
        Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        bgcom = new Texture("bgcod.png");
        bgcod = new Texture("bgcodcom.png");
        bgcod.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        if (Level.isd) com1 = new Button("comn1e.png", camera.position.x + 250, camera.position.y + 75, 100, 50);
        else com1 = new Button("closee.png", camera.position.x + 250, camera.position.y + 75, 100, 50);
        if (Level.isc) com2 = new Button("comn2e.png", camera.position.x + 250, camera.position.y + 145, 100, 50);
        else com2 = new Button("closee.png", camera.position.x + 250, camera.position.y + 145, 100, 50);
        if (Level.ist) com4 = new Button("teleporte.png", camera.position.x + 250, camera.position.y + 5, 100, 50);
        else com4 = new Button("closee.png", camera.position.x + 250, camera.position.y + 5, 100, 50);
        com3 = new Button("comn3e.png", camera.position.x + 250, camera.position.y - 105, 100, 50);
        run = new Button("rune.png", camera.position.x + 250, camera.position.y - 175, 100, 50);
        esc = new Button("exte.png",camera.position.x - 390,camera.position.y + 180,50,50);
        g = 0;
        f=0;
    }

    @Override
    protected void handleInput() {
        if (tempDown.x > tempUp.x-3 && tempDown.x < tempUp.x+3 && tempDown.y > tempUp.y-3 && tempDown.y < tempUp.y+3) {
            codinput.Input(camera.position.x, camera.position.y, tempDown.x, tempDown.y, gsm, com1, com2, com3, com4, run, esc);
            tempDown.set(0,0,0);
        }
    }

    @Override
    public void update(float dt) {
        com1.rectangle.x = camera.position.x + 250;
        com1.rectangle.y = camera.position.y + 75;
        com2.rectangle.x = camera.position.x + 250;
        com2.rectangle.y = camera.position.y + 145;
        com4.rectangle.x = camera.position.x + 250;
        com4.rectangle.y = camera.position.y + 5;
        com3.rectangle.x = camera.position.x + 250;
        com3.rectangle.y = camera.position.y - 105;
        run.rectangle.x = camera.position.x + 250;
        run.rectangle.y = camera.position.y - 175;
        esc.rectangle.x = camera.position.x - 390;
        esc.rectangle.y = camera.position.y + 180;
        handleInput();
        g++;
        if (g > 6) g = 6;
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        codmaprender.render(sb, camera.position.x, camera.position.y);
        sb.begin();
        sb.draw(bgcom, camera.position.x + 200, camera.position.y - 240,200,480);
        sb.draw(bgcod,camera.position.x+225,camera.position.y-10,150,240);
        Font.draw(sb,String.valueOf(Cods.x-codinput.com),camera.position.x+296,camera.position.y+225);
        sb.draw(com1.texture, com1.rectangle.x, com1.rectangle.y, com1.rectangle.width, com1.rectangle.height);
        sb.draw(com2.texture, com2.rectangle.x, com2.rectangle.y, com2.rectangle.width, com2.rectangle.height);
        sb.draw(com4.texture, com4.rectangle.x, com4.rectangle.y, com4.rectangle.width, com4.rectangle.height);
        sb.draw(com3.texture, com3.rectangle.x, com3.rectangle.y, com3.rectangle.width, com3.rectangle.height);
        sb.draw(run.texture, run.rectangle.x, run.rectangle.y, run.rectangle.width, run.rectangle.height);
        sb.draw(esc.texture, esc.rectangle.x, esc.rectangle.y, esc.rectangle.width, esc.rectangle.height);
        sb.end();
        if ((camera.position.x+(float)(dr.x*(-0.75))) - 400 > 0 && (camera.position.x+(float)(dr.x*(-0.75))) + 200 < Map.x * BankBlock.block.rectangle.width && f == 1 && tempDrag.x < camera.position.x+200)
            camera.translate((float)(dr.x*(-0.75)), 0, 0);
        if ((camera.position.y+(float)(dr.y*(0.75))) - 240 > 0 && (camera.position.y+(float)(dr.y*(0.75))) + 240 < Map.y * BankBlock.block.rectangle.height && f == 1 && tempDrag.x < camera.position.x+200)
            camera.translate(0, (float)(dr.y*(0.75)), 0);
        dr.set(0,0,0);
    }

    @Override
    public void dispose() {
        bgcom.dispose();
        bgcod.dispose();
        com1.dispose();
        com2.dispose();
        com3.dispose();
        com4.dispose();
        run.dispose();
        esc.dispose();
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
            tempDown.set(screenX,screenY, 0);
            camera.unproject(tempDown);
            f = 1;
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            tempUp.set(screenX,screenY, 0);
            camera.unproject(tempUp);
            f = 0;
            return true;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            dr.set(Gdx.input.getDeltaX(),Gdx.input.getDeltaY(),0);
            tempDrag.set(screenX,screenY,0);
            camera.unproject(tempDrag);
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

