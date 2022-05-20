package infos.cod.codgame.person;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Intersector;

import infos.cod.codgame.levels.Level;
import infos.cod.codgame.maps.BankBlock;
import infos.cod.codgame.maps.Map;
import infos.cod.codgame.states.CreateLevel;
import infos.cod.codgame.states.GameMenu;
import infos.cod.codgame.states.GameOver;
import infos.cod.codgame.states.GameStateManager;
import infos.cod.codgame.states.LevelComplate;
import infos.cod.codgame.states.PlayGame;
import infos.cod.codgame.states.PlayerLevels;

public class Collisions {

    static boolean isy, isx;
    int g;

    public Collisions() {
        isx = false;
        isy = false;
        g=0;
    }

    public void update(Person person, OrthographicCamera camera, GameStateManager gsm) {
        for (int i = (int) ((camera.position.x - 300) / BankBlock.block.rectangle.width); i < (int) ((camera.position.x + 300) / BankBlock.block.rectangle.width) + 1; i++) {
            for (int j = (int) ((camera.position.y - 180) / BankBlock.block.rectangle.height); j < (int) ((camera.position.y + 180) / BankBlock.block.rectangle.height) + 1; j++) {
                if (Map.map[i][j] != 0 && Map.map[i][j] != 9 && Map.map[i][j] != 10 && Map.map[i][j] != 100) {
                    try {
                        if (Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && person.rectangle.x + person.rectangle.width > BankBlock.masblock[i][j].rectangle.x && person.rectangle.x < BankBlock.masblock[i][j].rectangle.x + BankBlock.masblock[i][j].rectangle.width && person.rectangle.y > BankBlock.masblock[i][j].rectangle.y + BankBlock.masblock[i][j].rectangle.height - 10 && person.rectangle.y < BankBlock.masblock[i][j].rectangle.y + BankBlock.masblock[i][j].rectangle.height && (Map.map[i][j + 1] == 0 || Map.map[i][j + 1] == 10)) {
                            person.rectangle.y += (BankBlock.masblock[i][j].rectangle.y + BankBlock.masblock[i][j].rectangle.height) - person.rectangle.y;
                            if (person.speedY < -350) {
                                if (CreateLevel.cmod == 0) {
                                    BankBlock.block.dispose();
                                    gsm.push(new GameOver(gsm));
                                } else if (CreateLevel.cmod == 1) {
                                    Map.rewrite(CreateLevel.mapd);
                                    gsm.push(new CreateLevel(gsm));
                                }
                            } else {
                                isy = true;
                                person.speedY = 0;
                            }
                        }
                        if (Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && person.rectangle.x + person.rectangle.width > BankBlock.masblock[i][j].rectangle.x && person.rectangle.x < BankBlock.masblock[i][j].rectangle.x + BankBlock.masblock[i][j].rectangle.width && person.rectangle.y + person.rectangle.height > BankBlock.masblock[i][j].rectangle.y && person.rectangle.y + person.rectangle.height < BankBlock.masblock[i][j].rectangle.y + 10) {
                            person.rectangle.y -= (person.rectangle.y + person.rectangle.height) - BankBlock.masblock[i][j].rectangle.y;
                            person.speedY = 0;
                        }
                        if (Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && person.rectangle.y >= BankBlock.masblock[i][j].rectangle.y && person.rectangle.y < BankBlock.masblock[i][j].rectangle.y + BankBlock.masblock[i][j].rectangle.height && person.rectangle.x + person.rectangle.width > BankBlock.masblock[i][j].rectangle.x && person.rectangle.x + person.rectangle.width < BankBlock.masblock[i][j].rectangle.x + 10) {
                            person.rectangle.x -= (person.rectangle.x + person.rectangle.width) - BankBlock.masblock[i][j].rectangle.x;
                            person.speedX = 0;
                            isx = true;
                        }
                        if (Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && person.rectangle.y + 1 >= BankBlock.masblock[i][j].rectangle.y && person.rectangle.y < BankBlock.masblock[i][j].rectangle.y + BankBlock.masblock[i][j].rectangle.height && person.rectangle.x < BankBlock.masblock[i][j].rectangle.x + BankBlock.masblock[i][j].rectangle.width && person.rectangle.x > BankBlock.masblock[i][j].rectangle.x + BankBlock.masblock[i][j].rectangle.width - 10) {
                            person.rectangle.x += (BankBlock.masblock[i][j].rectangle.x + BankBlock.masblock[i][j].rectangle.width) - person.rectangle.x;
                            person.speedX = 0;
                            isx = true;
                        }
                        if (Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && person.rectangle.y <= 0) {
                            person.speedX = 0;
                            isx = true;
                        }
                        g=j;
                        if (Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && person.rectangle.y < BankBlock.masblock[i][j].rectangle.y + 40) {
                           while (Map.map[i][g] != 0 && Map.map[i-1][g-1] != 0 && Map.map[i+1][g-1] != 0){
                               if (Map.map[i][g+1] == 0) person.rectangle.y = BankBlock.masblock[i][g].rectangle.y + BankBlock.masblock[i][g].rectangle.height;
                               if (Map.map[i+1][g] == 0) {
                                   person.rectangle.x = BankBlock.masblock[i][g].rectangle.x + BankBlock.masblock[i][g].rectangle.width;
                                   person.rectangle.y = BankBlock.masblock[i+1][g].rectangle.y + BankBlock.masblock[i+1][g].rectangle.height;
                               }
                               if (Map.map[i-1][g] == 0) {
                                   person.rectangle.x = BankBlock.masblock[i][g].rectangle.x - person.rectangle.width;
                                   person.rectangle.y = BankBlock.masblock[i-1][g].rectangle.y + BankBlock.masblock[i-1][g].rectangle.height;
                               }
                               g++;
                           }
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (Map.map[i][j] == 100 && Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && CreateLevel.cmod == 0) {
                    System.out.println(PlayerLevels.pl);
                    if (PlayerLevels.pl == 0) {
                        if (GameMenu.num == GameMenu.save) {
                            GameMenu.save++;
                            GameMenu.Prefs.putInteger("save", GameMenu.save);
                            GameMenu.Prefs.flush();
                        }
                    }
                    PlayGame.f = 2;
                } else if (Map.map[i][j] == 100 && Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && CreateLevel.cmod == 1) {
                    Map.rewrite(CreateLevel.mapd);
                    gsm.push(new CreateLevel(gsm));
                }
                if (Map.map[i][j] == 9 && Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && CreateLevel.cmod == 0) {
                    BankBlock.block.dispose();
                    gsm.push(new GameOver(gsm));
                } else if (Map.map[i][j] == 9 && Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle) && CreateLevel.cmod == 1) {
                    Map.rewrite(CreateLevel.mapd);
                    gsm.push(new CreateLevel(gsm));
                }
                if (Map.map[i][j] == 10 && Intersector.overlaps(person.rectangle, BankBlock.masblock[i][j].rectangle)) {
                    Map.map[i][j] = 0;
                    BankBlock.masblock[i][j].rectangle.x = BankBlock.masblock[i][j].rectangle.x - 10;
                    BankBlock.masblock[i][j].rectangle.y = BankBlock.masblock[i][j].rectangle.y - 10;
                    BankBlock.masblock[i][j].rectangle.width = 50;
                    BankBlock.masblock[i][j].rectangle.height = 50;
                }
            }
        }
        for (int i=0;i<Map.x;i++){
            for (int j=0;j<Map.y;j++){
                try {
                    int k = 0;
                    while ((Map.map[i][j-k] == 4 || Map.map[i][j-k] == 5 || Map.map[i][j-k] == 7) && Map.map[i][j-k-1] == 0){
                        Map.map[i][j-k-1] = Map.map[i][j-k];
                        Map.map[i][j-k] = 0;
                        k++;
                    }
                }catch (Exception e){}
            }
        }
        if (person.rectangle.x < 0) person.rectangle.x = 0;
        if (person.rectangle.x > Map.x * BankBlock.block.rectangle.width - person.rectangle.width)
            person.rectangle.x = Map.x * BankBlock.block.rectangle.width - person.rectangle.width;
        if (person.rectangle.y < 0) {
            person.rectangle.y = 0;
            person.speedY = 0;
            isy = true;
        }
        if (person.rectangle.y > Map.y * BankBlock.block.rectangle.height - person.rectangle.height)
            person.rectangle.y = Map.y * BankBlock.block.rectangle.height - person.rectangle.height;
    }

}
