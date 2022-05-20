package infos.cod.codgame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.levels.Level;
import infos.cod.codgame.maps.BankBlock;
import infos.cod.codgame.maps.Map;
import infos.cod.codgame.playerLevel.PlayerInput;
import infos.cod.codgame.playerLevel.PlayerMapRender;
import infos.cod.codgame.playerLevel.SaveAndLoad;

public class CreateLevel extends State {

    private Vector3 tempUp,tempDown,tempDrag,dr;
    private int f,d;
    private Texture bgcom,bgb,pole,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,blockyes;
    private Button block1,block2,block3,block4,block8,block9,block10,block100,plus1,plus2,minus1,minus2,next,back,person,check1,check2,check3,test,create;
    private PlayerMapRender playermaprender;
    private PlayerInput playerinput;
    private Map map;
    private BankBlock bankblock;
    private BitmapFont Font;
    private Level level;
    private SaveAndLoad saveAndLoad;
    private float bx,by;
    public static int mapd[][];
    public static int x,y,px,py,vhod,com,isc,isd,ist,cmod,flag;
    public static String name;

    public CreateLevel(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 480);
        camera.position.set(400, 240, 0);
        Gdx.input.setInputProcessor(new InputManager());
        if (x == 0) map = new Map(13, 10);
        if (x == 0) bankblock = new BankBlock();
        playerinput = new PlayerInput();
        playermaprender = new PlayerMapRender();
        tempUp = new Vector3();
        tempDown = new Vector3();
        tempDrag = new Vector3();
        dr = new Vector3();
        Font = new BitmapFont();
        saveAndLoad = new SaveAndLoad();
        Font.setColor(Color.WHITE);
        Font.getData().setScale(2);
        Font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        bgcom = new Texture("bgcod.png");
        bgb = new Texture("bgcom.png");
        pole = new Texture("pole.png");
        t1 = new Texture("t1.png");
        t2 = new Texture("t2.png");
        t3 = new Texture("t3.png");
        t4 = new Texture("t4.png");
        t5 = new Texture("t5.png");
        t6 = new Texture("t6.png");
        t7 = new Texture("t7.png");
        t8 = new Texture("t8.png");
        t9 = new Texture("t9.png");
        t10 = new Texture("t10.png");
        blockyes = new Texture("blockyes.png");
        blockyes.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        pole.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t4.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t5.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t6.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t7.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t8.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t9.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        t10.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        block1 = new Button("dirtgc.png",camera.position.x+240,camera.position.y+165,50,50);
        block2 = new Button("2c.png",camera.position.x+310,camera.position.y+165,50,50);
        block3 = new Button("redactc.png",camera.position.x+240,camera.position.y+100,50,50);
        block4 = new Button("sandc.png",camera.position.x+310,camera.position.y+100,50,50);
        block8 = new Button("codnot.png",camera.position.x+240,camera.position.y+35,50,50);
        block9 = new Button("shipc.png",camera.position.x+310,camera.position.y+35,50,50);
        block10 = new Button("star.png",camera.position.x+240,camera.position.y-30,50,50);
        block100 = new Button("block2c.png",camera.position.x+310,camera.position.y-30,50,50);
        plus1 = new Button("plus.png",camera.position.x + 10,camera.position.y + 25,50,50);
        plus2 = new Button("plus.png",camera.position.x + 10,camera.position.y-85,50,50);
        minus1 = new Button("minus.png",camera.position.x - 160,camera.position.y + 25,50,50);
        minus2 = new Button("minus.png",camera.position.x - 160,camera.position.y-85,50,50);
        back = new Button("back.png",camera.position.x-160,camera.position.y-200,100,75);
        next = new Button("nextc.png",camera.position.x - 40,camera.position.y-200,100,75);
        person = new Button("person.png",camera.position.x + 276,camera.position.y - 126,48,69);
        if (isc == 0) {check1 = new Button("check.png",camera.position.x ,camera.position.y + 60,50,50);}
        else {check1 = new Button("checkyes.png",camera.position.x ,camera.position.y + 60,50,50);}
        if (isd == 0) {check2 = new Button("check.png",camera.position.x ,camera.position.y - 15,50,50);}
        else {check2 = new Button("checkyes.png",camera.position.x ,camera.position.y - 15,50,50);}
        if (ist == 0) {check3 = new Button("check.png",camera.position.x ,camera.position.y - 90,50,50);}
        else {check3 = new Button("checkyes.png",camera.position.x ,camera.position.y - 90,50,50);}
        test = new Button("test.png",camera.position.x - 100,camera.position.y - 200,100,75);
        create = new Button("createc.png",camera.position.x + 20,camera.position.y - 200,100,75);
        f=0;
        d=0;
        bx = 0;
        by = 0;
        if (flag == 0) flag = 0;
        if (x == 0) x = 15;
        if (y == 0) y = 10;
        if (px == 0) px = -50;
        if (py == 0) py = 0;
        if (vhod == 0) vhod = 1;
        if (com == 0) com = 1;
        if (isc == 0) isc = 0;
        if (isd == 0) isd = 0;
        if (ist == 0) ist = 0;
        if (name == null) {
            MyTextInputListener listener = new MyTextInputListener();
            Gdx.input.getTextInput(listener, "Введите название уровня", "", "Название уровня");
        }
    }

    @Override
    protected void handleInput() {
        if (d == 1) {
            BankBlock.block.dispose();
            flag = 0;
            x = 0;
            y = 0;
            px = 0;
            py = 0;
            vhod = 0;
            com = 0;
            isc = 0;
            isd = 0;
            ist = 0;
            name = null;
            gsm.push(new PlayerLevels(gsm));
            tempDown.set(0,0,0);
        }
        if (flag == 0){
            if (minus1.rectangle.contains(tempDown.x,tempDown.y) && x > 15) {
                x--;
                tempDown.set(0,0,0);
            }
            if (plus1.rectangle.contains(tempDown.x,tempDown.y) && x < 1000) {
                x++;
                tempDown.set(0,0,0);
            }
            if (minus2.rectangle.contains(tempDown.x,tempDown.y) && y > 10) {
                y--;
                tempDown.set(0,0,0);
            }
            if (plus2.rectangle.contains(tempDown.x,tempDown.y) && y < 1000) {
                y++;
                tempDown.set(0,0,0);
            }
            if (back.rectangle.contains(tempDown.x,tempDown.y)) {
                BankBlock.block.dispose();
                flag = 0;
                x = 0;
                y = 0;
                px = 0;
                py = 0;
                vhod = 0;
                com = 0;
                isc = 0;
                isd = 0;
                ist = 0;
                name = null;
                cmod = 0;
                gsm.push(new PlayerLevels(gsm));
                tempDown.set(0,0,0);
            }
            if (next.rectangle.contains(tempDown.x,tempDown.y)) {
                BankBlock.block.dispose();
                map = new Map(x, y, Map.map);
                mapd = new int[x][y];
                bankblock = new BankBlock();
                flag = 1;
                back.rectangle.width = 75;
                back.rectangle.height = 56;
                next.rectangle.width = 75;
                next.rectangle.height = 56;
                camera.position.set(400, 240, 0);
                tempDown.set(0,0,0);
            }
        }
        if (flag == 1) {
            if (back.rectangle.contains(tempDown.x,tempDown.y)) {
                flag = 0;
                back.rectangle.width = 100;
                back.rectangle.height = 75;
                next.rectangle.width = 100;
                next.rectangle.height = 75;
                tempDown.set(0,0,0);
            }
            if (next.rectangle.contains(tempDown.x,tempDown.y) && px != -50) {
                flag = 2;
                back.rectangle.width = 100;
                back.rectangle.height = 75;
                next.rectangle.width = 100;
                next.rectangle.height = 75;
                tempDown.set(0,0,0);
            }
            if (tempDown.x > tempUp.x - 3 && tempDown.x < tempUp.x + 3 && tempDown.y > tempUp.y - 3 && tempDown.y < tempUp.y + 3) {
                if (tempUp.x < camera.position.x + 200) {
                    playerinput.MapInput(camera.position.x, camera.position.y, tempDown.x, tempDown.y);
                } else {
                    playerinput.BlockInput(block1, block2, block3, block4, block8, block9, block10, block100, person, tempDown.x, tempDown.y,camera.position.x, camera.position.y);
                }
                tempDown.set(0,0,0);
            }
        }
        if (flag == 2){
            if (minus1.rectangle.contains(tempDown.x,tempDown.y) && vhod > 1) {
                vhod--;
                tempDown.set(0,0,0);
            }
            if (plus1.rectangle.contains(tempDown.x,tempDown.y) && vhod < 1000) {
                vhod++;
                tempDown.set(0,0,0);
            }
            if (minus2.rectangle.contains(tempDown.x,tempDown.y) && com > 1) {
                com--;
                tempDown.set(0,0,0);
            }
            if (plus2.rectangle.contains(tempDown.x,tempDown.y) && com < 1000) {
                com++;
                tempDown.set(0,0,0);
            }
            if (back.rectangle.contains(tempDown.x,tempDown.y)) {
                flag = 1;
                back.rectangle.width = 75;
                back.rectangle.height = 56;
                next.rectangle.width = 75;
                next.rectangle.height = 56;
                tempDown.set(0,0,0);
            }
            if (next.rectangle.contains(tempDown.x,tempDown.y)) {
                flag = 3;
                tempDown.set(0,0,0);
            }
        }
        if (flag == 3){
            if (check1.rectangle.contains(tempDown.x,tempDown.y) && isc == 0) {
                isc = 1;
                check1.newTexture("checkyes.png");
                tempDown.set(0,0,0);
            } else if (check1.rectangle.contains(tempDown.x,tempDown.y) && isc == 1) {
                isc = 0;
                check1.newTexture("check.png");
                tempDown.set(0,0,0);
            }
            if (check2.rectangle.contains(tempDown.x,tempDown.y) && isd == 0) {
                isd = 1;
                check2.newTexture("checkyes.png");
                tempDown.set(0,0,0);
            } else if (check2.rectangle.contains(tempDown.x,tempDown.y) && isd == 1) {
                isd = 0;
                check2.newTexture("check.png");
                tempDown.set(0,0,0);
            }
            if (check3.rectangle.contains(tempDown.x,tempDown.y) && ist == 0) {
                ist = 1;
                check3.newTexture("checkyes.png");
                tempDown.set(0,0,0);
            } else if (check3.rectangle.contains(tempDown.x,tempDown.y) && ist == 1) {
                ist = 0;
                check3.newTexture("check.png");
                tempDown.set(0,0,0);
            }
            if (back.rectangle.contains(tempDown.x,tempDown.y)) {
                flag = 2;
                tempDown.set(0,0,0);
            }
            if (test.rectangle.contains(tempDown.x,tempDown.y)) {
                level = new Level(px,py,vhod,com,isc,isd,ist);
                cmod = 1;
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        try {
                            mapd[i][j] = Map.map[i][j];
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                }
                gsm.push(new PlayGame(gsm));
                tempDown.set(0,0,0);
            }
            if (create.rectangle.contains(tempDown.x,tempDown.y)) {
                saveAndLoad.save();
                flag = 0;
                x = 0;
                y = 0;
                px = 0;
                py = 0;
                vhod = 0;
                com = 0;
                isc = 0;
                isd = 0;
                ist = 0;
                name = null;
                cmod = 0;
                gsm.push(new PlayerLevels(gsm));
                tempDown.set(0,0,0);
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        if (flag == 0) {
            plus1.rectangle.x = camera.position.x + 10;
            plus1.rectangle.y = camera.position.y + 25;
            plus2.rectangle.x = camera.position.x + 10;
            plus2.rectangle.y = camera.position.y - 85;
            minus1.rectangle.x = camera.position.x - 160;
            minus1.rectangle.y = camera.position.y + 25;
            minus2.rectangle.x = camera.position.x - 160;
            minus2.rectangle.y = camera.position.y - 85;
            back.rectangle.x = camera.position.x - 160;
            back.rectangle.y = camera.position.y - 200;
            next.rectangle.x = camera.position.x - 40;
            next.rectangle.y = camera.position.y - 200;
        }
        if (flag == 1) {
            block1.rectangle.x = camera.position.x + 240;
            block1.rectangle.y = camera.position.y + 165;
            block2.rectangle.x = camera.position.x + 310;
            block2.rectangle.y = camera.position.y + 165;
            block3.rectangle.x = camera.position.x + 240;
            block3.rectangle.y = camera.position.y + 100;
            block4.rectangle.x = camera.position.x + 310;
            block4.rectangle.y = camera.position.y + 100;
            block8.rectangle.x = camera.position.x + 240;
            block8.rectangle.y = camera.position.y + 35;
            block9.rectangle.x = camera.position.x + 310;
            block9.rectangle.y = camera.position.y + 35;
            block10.rectangle.x = camera.position.x + 240;
            block10.rectangle.y = camera.position.y - 30;
            block100.rectangle.x = camera.position.x + 310;
            block100.rectangle.y = camera.position.y - 30;
            back.rectangle.x = camera.position.x + 215;
            back.rectangle.y = camera.position.y - 230;
            next.rectangle.x = camera.position.x + 310;
            next.rectangle.y = camera.position.y - 230;
            person.rectangle.x = camera.position.x + 276;
            person.rectangle.y = camera.position.y - 126;
            bx = camera.position.x + playerinput.x;
            by = camera.position.y + playerinput.y;
        }
        if (flag == 2) {
            plus1.rectangle.x = camera.position.x + 10;
            plus1.rectangle.y = camera.position.y + 25;
            plus2.rectangle.x = camera.position.x + 10;
            plus2.rectangle.y = camera.position.y - 85;
            minus1.rectangle.x = camera.position.x - 160;
            minus1.rectangle.y = camera.position.y + 25;
            minus2.rectangle.x = camera.position.x - 160;
            minus2.rectangle.y = camera.position.y - 85;
            back.rectangle.x = camera.position.x - 160;
            back.rectangle.y = camera.position.y - 200;
            next.rectangle.x = camera.position.x - 40;
            next.rectangle.y = camera.position.y - 200;
        }
        if (flag == 3) {
            check1.rectangle.x = camera.position.x;
            check1.rectangle.y = camera.position.y + 60;
            check2.rectangle.x = camera.position.x;
            check2.rectangle.y = camera.position.y - 15;
            check3.rectangle.x = camera.position.x;
            check3.rectangle.y = camera.position.y - 90;
            back.rectangle.x = camera.position.x - 220;
            back.rectangle.y = camera.position.y - 200;
            test.rectangle.x = camera.position.x - 100;
            test.rectangle.y = camera.position.y - 200;
            create.rectangle.x = camera.position.x + 20;
            create.rectangle.y = camera.position.y - 200;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        playermaprender.render(sb, camera.position.x, camera.position.y);
        sb.begin();
        sb.draw(person.texture,px,py,32,46);
        sb.draw(bgcom, camera.position.x + 200, camera.position.y - 240);
        sb.draw(block1.texture,block1.rectangle.x,block1.rectangle.y,block1.rectangle.width,block1.rectangle.height);
        sb.draw(block2.texture,block2.rectangle.x,block2.rectangle.y,block2.rectangle.width,block2.rectangle.height);
        sb.draw(block3.texture,block3.rectangle.x,block3.rectangle.y,block3.rectangle.width,block3.rectangle.height);
        sb.draw(block4.texture,block4.rectangle.x,block4.rectangle.y,block4.rectangle.width,block4.rectangle.height);
        sb.draw(block8.texture,block8.rectangle.x,block8.rectangle.y,block8.rectangle.width,block8.rectangle.height);
        sb.draw(block9.texture,block9.rectangle.x,block9.rectangle.y,block9.rectangle.width,25);
        sb.draw(block10.texture,block10.rectangle.x,block10.rectangle.y,block10.rectangle.width,block10.rectangle.height);
        sb.draw(block100.texture,block100.rectangle.x,block100.rectangle.y,block100.rectangle.width,block100.rectangle.height);
        sb.draw(person.texture,person.rectangle.x,person.rectangle.y,person.rectangle.width,person.rectangle.height);
        if (flag == 1) {
            if (playerinput.x != 0 && playerinput.y != 0) {
                sb.draw(blockyes, bx, by, 50, 50);
            }
            sb.draw(back.texture, back.rectangle.x, back.rectangle.y, back.rectangle.width, back.rectangle.height);
            sb.draw(next.texture, next.rectangle.x, next.rectangle.y, next.rectangle.width, next.rectangle.height);
        }
        if (flag == 0) {
            sb.draw(bgb, camera.position.x - 400, camera.position.y - 240,800,480);
            sb.draw(t1,camera.position.x - 250,camera.position.y + 150,400,50);
            sb.draw(t2,camera.position.x - 150,camera.position.y + 75,200,50);
            sb.draw(t3,camera.position.x - 150,camera.position.y - 35,200,50);
            sb.draw(pole,camera.position.x - 100,camera.position.y + 25,100,50);
            sb.draw(pole,camera.position.x - 100,camera.position.y-85,100,50);
            if (x < 100) Font.draw(sb,String.valueOf(x),camera.position.x - 67,camera.position.y+60);
            if (x >= 100 && x < 1000) Font.draw(sb,String.valueOf(x),camera.position.x - 72,camera.position.y+60);
            if (x == 1000) Font.draw(sb,String.valueOf(x),camera.position.x - 77,camera.position.y+60);
            if (y < 100) Font.draw(sb,String.valueOf(y),camera.position.x - 67,camera.position.y-50);
            if (y >= 100 && y < 1000) Font.draw(sb,String.valueOf(y),camera.position.x - 72,camera.position.y-50);
            if (y == 1000) Font.draw(sb,String.valueOf(y),camera.position.x - 77,camera.position.y-50);
            sb.draw(minus1.texture,minus1.rectangle.x,minus1.rectangle.y,minus1.rectangle.width,minus1.rectangle.height);
            sb.draw(minus2.texture,minus2.rectangle.x,minus2.rectangle.y,minus2.rectangle.width,minus2.rectangle.height);
            sb.draw(plus1.texture,plus1.rectangle.x,plus1.rectangle.y,plus1.rectangle.width,plus1.rectangle.height);
            sb.draw(plus2.texture,plus2.rectangle.x,plus2.rectangle.y,plus2.rectangle.width,plus2.rectangle.height);
            sb.draw(back.texture,back.rectangle.x,back.rectangle.y,back.rectangle.width,back.rectangle.height);
            sb.draw(next.texture,next.rectangle.x,next.rectangle.y,next.rectangle.width,next.rectangle.height);
        }
        if (flag == 2) {
            sb.draw(bgb, camera.position.x - 400, camera.position.y - 240,800,480);
            sb.draw(t6,camera.position.x - 250,camera.position.y + 150,400,50);
            sb.draw(t4,camera.position.x - 300,camera.position.y + 75,500,50);
            sb.draw(t5,camera.position.x - 300,camera.position.y - 35,500,50);
            sb.draw(pole,camera.position.x - 100,camera.position.y + 25,100,50);
            sb.draw(pole,camera.position.x - 100,camera.position.y-85,100,50);
            if (vhod < 10) Font.draw(sb,String.valueOf(vhod),camera.position.x - 58,camera.position.y+60);
            if (vhod >= 10 && vhod < 100) Font.draw(sb,String.valueOf(vhod),camera.position.x - 67,camera.position.y+60);
            if (vhod >= 100 && vhod < 1000) Font.draw(sb,String.valueOf(vhod),camera.position.x - 72,camera.position.y+60);
            if (vhod == 1000) Font.draw(sb,String.valueOf(vhod),camera.position.x - 77,camera.position.y+60);
            if (com < 10) Font.draw(sb,String.valueOf(com),camera.position.x - 58,camera.position.y-50);
            if (com >= 10 && com < 100) Font.draw(sb,String.valueOf(com),camera.position.x - 67,camera.position.y-50);
            if (com >= 100 && com < 1000) Font.draw(sb,String.valueOf(com),camera.position.x - 72,camera.position.y-50);
            if (com == 1000) Font.draw(sb,String.valueOf(com),camera.position.x - 77,camera.position.y-50);
            sb.draw(minus1.texture,minus1.rectangle.x,minus1.rectangle.y,minus1.rectangle.width,minus1.rectangle.height);
            sb.draw(minus2.texture,minus2.rectangle.x,minus2.rectangle.y,minus2.rectangle.width,minus2.rectangle.height);
            sb.draw(plus1.texture,plus1.rectangle.x,plus1.rectangle.y,plus1.rectangle.width,plus1.rectangle.height);
            sb.draw(plus2.texture,plus2.rectangle.x,plus2.rectangle.y,plus2.rectangle.width,plus2.rectangle.height);
            sb.draw(back.texture,back.rectangle.x,back.rectangle.y,back.rectangle.width,back.rectangle.height);
            sb.draw(next.texture,next.rectangle.x,next.rectangle.y,next.rectangle.width,next.rectangle.height);
        }
        if (flag == 3) {
            sb.draw(bgb, camera.position.x - 400, camera.position.y - 240,800,480);
            sb.draw(t7,camera.position.x - 250,camera.position.y + 150,400,50);
            sb.draw(t8,camera.position.x - 185,camera.position.y + 60,200,50);
            sb.draw(t9,camera.position.x - 190,camera.position.y - 15,200,50);
            sb.draw(t10,camera.position.x - 225,camera.position.y - 90,200,50);
            sb.draw(check1.texture,check1.rectangle.x,check1.rectangle.y,check1.rectangle.width,check1.rectangle.height);
            sb.draw(check2.texture,check2.rectangle.x,check2.rectangle.y,check2.rectangle.width,check2.rectangle.height);
            sb.draw(check3.texture,check3.rectangle.x,check3.rectangle.y,check3.rectangle.width,check3.rectangle.height);
            sb.draw(back.texture,back.rectangle.x,back.rectangle.y,back.rectangle.width,back.rectangle.height);
            sb.draw(test.texture,test.rectangle.x,test.rectangle.y,test.rectangle.width,test.rectangle.height);
            sb.draw(create.texture,create.rectangle.x,create.rectangle.y,create.rectangle.width,create.rectangle.height);
        }
        sb.end();
        if (flag == 1) {
            if ((camera.position.x + (float) (dr.x * (-0.75))) - 400 > 0 && (camera.position.x + (float) (dr.x * (-0.75))) + 200 < Map.x * BankBlock.block.rectangle.width && f == 1 && tempDrag.x < camera.position.x + 200)
                camera.translate((float) (dr.x * (-0.75)), 0, 0);
            if ((camera.position.y + (float) (dr.y * (0.75))) - 240 > 0 && (camera.position.y + (float) (dr.y * (0.75))) + 240 < Map.y * BankBlock.block.rectangle.height && f == 1 && tempDrag.x < camera.position.x + 200)
                camera.translate(0, (float) (dr.y * (0.75)), 0);
            dr.set(0, 0, 0);
        }
    }

    @Override
    public void dispose() {
        bgcom.dispose();
        block1.dispose();
        block2.dispose();
        block3.dispose();
        block4.dispose();
        block8.dispose();
        block9.dispose();
        block10.dispose();
        block100.dispose();
        minus1.dispose();
        minus2.dispose();
        plus1.dispose();
        plus2.dispose();
        next.dispose();
        back.dispose();
        bgb.dispose();
        pole.dispose();
        Font.dispose();
        person.dispose();
        test.dispose();
        create.dispose();
        check1.dispose();
        check2.dispose();
        check3.dispose();
        t1.dispose();
        t2.dispose();
        t3.dispose();
        t4.dispose();
        t5.dispose();
        t6.dispose();
        t7.dispose();
        t8.dispose();
        t9.dispose();
        t10.dispose();
        blockyes.dispose();
    }

    public class MyTextInputListener implements Input.TextInputListener {
        @Override
        public void input (String text) {
            if (text.equals("")){
                MyTextInputListener listener = new MyTextInputListener();
                Gdx.input.getTextInput(listener, "Введите название уровня", "", "Название уровня");
            } else {
                name = text;
            }
        }

        @Override
        public void canceled () {
            d = 1;
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
