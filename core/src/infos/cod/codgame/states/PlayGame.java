package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.levels.Level;
import infos.cod.codgame.maps.BankBlock;
import infos.cod.codgame.maps.Map;
import infos.cod.codgame.maps.RenderMap;
import infos.cod.codgame.person.Collisions;
import infos.cod.codgame.person.PersonMove;
import infos.cod.codgame.person.Person;
import infos.cod.codgame.playerLevel.SaveAndLoad;

public class PlayGame extends State {

    private RenderMap rendermap;
    private Person person;
    private Collisions collisions;
    private PersonMove personmove;
    private Vector3 touchPos;
    private Button codmod,menu,right,left,levels,restart,continye,next,startmenu;
    private Texture bg,paus,win;
    private int v, g;
    private Level level;
    private BitmapFont Font;
    private SaveAndLoad saveAndLoad;
    public static int f;

    public PlayGame(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        camera.zoom = 0.75f;
        camera.position.set(Person.x, Person.y, 0);
        if (Person.x - 300 < 0) camera.position.set(301, camera.position.y, 0);
        if (Person.x + 300 > Map.x * BankBlock.block.rectangle.width)
            camera.position.set(Map.x * BankBlock.block.rectangle.width - 301, camera.position.y, 0);
        if (Person.y - 180 < 0) camera.position.set(camera.position.x, 181, 0);
        if (Person.y + 180 > Map.y * BankBlock.block.rectangle.height)
            camera.position.set(camera.position.x, Map.y * BankBlock.block.rectangle.height - 181, 0);
        rendermap = new RenderMap();
        touchPos = new Vector3();
        personmove = new PersonMove();
        person = new Person(Person.x, Person.y + 2);
        collisions = new Collisions();
        saveAndLoad = new SaveAndLoad();
        Font = new BitmapFont();
        Font.setColor(Color.WHITE);
        Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        codmod = new Button("maps2ec.png", camera.position.x + 256, camera.position.y + 136, 37, 37);
        menu = new Button("esc4e.png", camera.position.x - 293, camera.position.y + 136, 37, 37);
        right = new Button("rightbg.png", camera.position.x + 220, camera.position.y - 150, 50, 50);
        left = new Button("leftbg.png", camera.position.x + 150, camera.position.y - 150, 50, 50);
        levels = new Button("menue.png",camera.position.x - 122,camera.position.y,112,75);
        restart = new Button("restarte.png",camera.position.x + 10,camera.position.y,112,75);
        startmenu = new Button("startmenu.png",camera.position.x - 122,camera.position.y - 95,112,75);
        continye = new Button("conte.png",camera.position.x + 10,camera.position.y - 95,112,75);
        next = new Button("nexte.png",camera.position.x + 10,camera.position.y - 95,112,75);
        bg = new Texture("bgcom.png");
        paus = new Texture("paus.png");
        win = new Texture("win.png");
        g = 0;
        v = 1;
        f = 0;
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched() && g > 5) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (f == 0) {
                if (person.rectangle.x < touchPos.x) v = 1;
                if (person.rectangle.x > touchPos.x) v = (-1);
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        if (f == 0) {
            personmove.Move(touchPos.x, touchPos.y, person, right, left);
            if (person.speedX > 0) v = 1;
            if (person.speedX < 0) v = (-1);
            person.update(dt);
            collisions.update(person, camera, gsm);
            if (codmod.rectangle.contains(touchPos.x, touchPos.y) && Level.col < Level.lim) {
                Level.col++;
                gsm.push(new CodGame(gsm));
            }
            if (menu.rectangle.contains(touchPos.x, touchPos.y) && CreateLevel.cmod == 0) {
                f = 1;
            } else if (menu.rectangle.contains(touchPos.x, touchPos.y) && CreateLevel.cmod == 1){
                Map.rewrite(CreateLevel.mapd);
                gsm.push(new CreateLevel(gsm));
            }
            touchPos.x = 0;
            touchPos.y = 0;
            codmod.rectangle.x = camera.position.x + 256;
            codmod.rectangle.y = camera.position.y + 136;
            menu.rectangle.x = camera.position.x - 293;
            menu.rectangle.y = camera.position.y + 136;
            right.rectangle.x = camera.position.x + 220;
            right.rectangle.y = camera.position.y - 150;
            left.rectangle.x = camera.position.x + 150;
            left.rectangle.y = camera.position.y - 150;
        }
        if (f == 1) {
            if (levels.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 0) {
                BankBlock.block.dispose();
                gsm.push(new GameMenu(gsm));
            } else if (levels.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 1) {
                BankBlock.block.dispose();
                gsm.push(new PlayerLevels(gsm));
            }
            if (restart.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 0) {
                BankBlock.block.dispose();
                level = new Level(GameMenu.num);
                gsm.push(new PlayGame(gsm));
            } else if (restart.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 1) {
                BankBlock.block.dispose();
                saveAndLoad.load(PlayerLevels.name);
                gsm.push(new PlayGame(gsm));
            }
            if (startmenu.rectangle.contains(touchPos.x, touchPos.y)) {
                BankBlock.block.dispose();
                gsm.push(new StartMenu(gsm));
            }
            if (continye.rectangle.contains(touchPos.x, touchPos.y)) {
                gsm.push(new PlayGame(gsm));
            }
            levels.rectangle.x = camera.position.x - 122;
            levels.rectangle.y = camera.position.y;
            restart.rectangle.x = camera.position.x + 10;
            restart.rectangle.y = camera.position.y;
            startmenu.rectangle.x = camera.position.x - 122;
            startmenu.rectangle.y = camera.position.y - 95;
            continye.rectangle.x = camera.position.x + 10;
            continye.rectangle.y = camera.position.y - 95;
        }
        if (f == 2) {
            if (levels.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 0) {
                BankBlock.block.dispose();
                gsm.push(new GameMenu(gsm));
            } else if (levels.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 1) {
                BankBlock.block.dispose();
                gsm.push(new PlayerLevels(gsm));
            }
            if (restart.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 0) {
                BankBlock.block.dispose();
                level = new Level(GameMenu.num);
                gsm.push(new PlayGame(gsm));
            } else if (restart.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 1) {
                BankBlock.block.dispose();
                saveAndLoad.load(PlayerLevels.name);
                gsm.push(new PlayGame(gsm));
            }
            if (startmenu.rectangle.contains(touchPos.x, touchPos.y)) {
                BankBlock.block.dispose();
                gsm.push(new StartMenu(gsm));
            }
            if (next.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 0) {
                if (GameMenu.num < GameMenu.lm) {
                    BankBlock.block.dispose();
                    GameMenu.num++;
                    level = new Level(GameMenu.num);
                    gsm.push(new DialogWindow(gsm));
                } else {
                    BankBlock.block.dispose();
                    gsm.push(new GameMenu(gsm));
                }
            } else if (next.rectangle.contains(touchPos.x, touchPos.y) && PlayerLevels.pl == 1) {
                BankBlock.block.dispose();
                gsm.push(new PlayerLevels(gsm));
            }
            levels.rectangle.x = camera.position.x - 122;
            levels.rectangle.y = camera.position.y;
            restart.rectangle.x = camera.position.x + 10;
            restart.rectangle.y = camera.position.y;
            startmenu.rectangle.x = camera.position.x - 122;
            startmenu.rectangle.y = camera.position.y - 95;
            next.rectangle.x = camera.position.x + 10;
            next.rectangle.y = camera.position.y - 95;
        }
        g++;
        if (g > 6) g = 6;
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        rendermap.render(sb, camera.position.x, camera.position.y);
        sb.begin();
        if (v == 1) sb.draw(person.Animationr.getFrame(), person.rectangle.x+1, person.rectangle.y);
        if (v == -1) sb.draw(person.Animationl.getFrame(), person.rectangle.x-6, person.rectangle.y);
        sb.draw(right.texture,right.rectangle.x,right.rectangle.y,right.rectangle.width,right.rectangle.height);
        sb.draw(left.texture, left.rectangle.x, left.rectangle.y,left.rectangle.width,left.rectangle.height);
        sb.draw(menu.texture,menu.rectangle.x,menu.rectangle.y,menu.rectangle.width,menu.rectangle.height);
        sb.draw(codmod.texture, codmod.rectangle.x, codmod.rectangle.y,codmod.rectangle.width+6,codmod.rectangle.height+6);
        Font.draw(sb,String.valueOf(Level.lim-Level.col),camera.position.x+286,camera.position.y+175);
        if (f == 1) {
            sb.draw(bg,camera.position.x-300,camera.position.y-180,600,360);
            sb.draw(paus,camera.position.x - 75,camera.position.y + 85,150,75);
            sb.draw(levels.texture,levels.rectangle.x,levels.rectangle.y,levels.rectangle.width,levels.rectangle.height);
            sb.draw(restart.texture,restart.rectangle.x,restart.rectangle.y,restart.rectangle.width,restart.rectangle.height);
            sb.draw(startmenu.texture,startmenu.rectangle.x,startmenu.rectangle.y,startmenu.rectangle.width,startmenu.rectangle.height);
            sb.draw(continye.texture,continye.rectangle.x,continye.rectangle.y,continye.rectangle.width,continye.rectangle.height);
        }
        if (f == 2) {
            sb.draw(bg,camera.position.x-300,camera.position.y-180,600,360);
            sb.draw(win,camera.position.x - 75,camera.position.y + 85,150,75);
            sb.draw(levels.texture,levels.rectangle.x,levels.rectangle.y,levels.rectangle.width,levels.rectangle.height);
            sb.draw(restart.texture,restart.rectangle.x,restart.rectangle.y,restart.rectangle.width,restart.rectangle.height);
            sb.draw(startmenu.texture,startmenu.rectangle.x,startmenu.rectangle.y,startmenu.rectangle.width,startmenu.rectangle.height);
            sb.draw(next.texture,next.rectangle.x,next.rectangle.y,next.rectangle.width,next.rectangle.height);
        }
        sb.end();
        if (person.rectangle.x - 300 > 0 && person.rectangle.x + 300 < Map.x * BankBlock.block.rectangle.width)
            camera.position.set(person.rectangle.x, camera.position.y, 0);
        if (person.rectangle.y - 180 > 0 && person.rectangle.y + 180 < Map.y * BankBlock.block.rectangle.height)
            camera.position.set(camera.position.x, person.rectangle.y, 0);
    }

    @Override
    public void dispose() {
        person.dispose();
        codmod.dispose();
        menu.dispose();
        right.dispose();
        left.dispose();
        levels.dispose();
        restart.dispose();
        continye.dispose();
        next.dispose();
        startmenu.dispose();
        bg.dispose();
        paus.dispose();
        win.dispose();
    }
}