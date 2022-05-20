package infos.cod.codgame.playerLevel;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.maps.BankBlock;
import infos.cod.codgame.maps.Map;
import infos.cod.codgame.states.CreateLevel;

public class PlayerInput {

    public int k;
    public float x, y;

    public PlayerInput() {
        k = 0;
        x = 0;
        y = 0;
    }

    public void BlockInput(Button block1,Button block2,Button block3,Button block4,Button block8,Button block9,Button block10,Button block100,Button person, float touchPosx, float touchPosy,float camx,float camy) {
        if (block1.rectangle.contains(touchPosx,touchPosy) && k != 1){
            k = 1;
            x = 240;
            y = 165;
        } else if (block1.rectangle.contains(touchPosx,touchPosy) && k == 1) {
            k = 0;
            x = 0;
            y = 0;
        }
        if (block2.rectangle.contains(touchPosx,touchPosy) && k != 2){
            k = 2;
            x = 310;
            y = 165;
        } else if (block2.rectangle.contains(touchPosx,touchPosy) && k == 2) {
            k = 0;
            x = 0;
            y = 0;
        }
        if (block3.rectangle.contains(touchPosx,touchPosy) && k != 3){
            k = 3;
            x = 240;
            y = 100;
        } else if (block3.rectangle.contains(touchPosx,touchPosy) && k == 3) {
            k = 0;
            x = 0;
            y = 0;
        }
        if (block4.rectangle.contains(touchPosx,touchPosy) && k != 4){
            k = 4;
            x = 310;
            y = 100;
        } else if (block4.rectangle.contains(touchPosx,touchPosy) && k == 4) {
            k = 0;
            x = 0;
            y = 0;
        }
        if (block8.rectangle.contains(touchPosx,touchPosy) && k != 8){
            k = 8;
            x = 240;
            y = 35;
        } else if (block8.rectangle.contains(touchPosx,touchPosy) && k == 8) {
            k = 0;
            x = 0;
            y = 0;
        }
        if (block9.rectangle.contains(touchPosx,touchPosy) && k != 9){
            k = 9;
            x = 310;
            y = 35;
        } else if (block9.rectangle.contains(touchPosx,touchPosy) && k == 9) {
            k = 0;
            x = 0;
            y = 0;
        }
        if (block10.rectangle.contains(touchPosx,touchPosy) && k != 10){
            k = 10;
            x = 240;
            y = -30;
        } else if (block10.rectangle.contains(touchPosx,touchPosy) && k == 10) {
            k = 0;
            x = 0;
            y = 0;
        }
        if (block100.rectangle.contains(touchPosx,touchPosy) && k != 100){
            k = 100;
            x = 310;
            y = -30;
        } else if (block100.rectangle.contains(touchPosx,touchPosy) && k == 100) {
            k = 0;
            x = 0;
            y = 0;
        }
        if (person.rectangle.contains(touchPosx,touchPosy) && k != 1000) {
            k = 1000;
            x = 276;
            y = -117;
        } else if (person.rectangle.contains(touchPosx,touchPosy) && k == 1000){
            k = 0;
            x = 0;
            y = 0;
        }
    }

    public void MapInput(float camx, float camy, float touchPosx, float touchPosy) {
        for (int i = (int) ((camx - 400) / BankBlock.block.rectangle.width); i < (int) ((camx + 200) / BankBlock.block.rectangle.width) + 1; i++) {
            for (int j = (int) ((camy - 240) / BankBlock.block.rectangle.height); j < (int) ((camy + 240) / BankBlock.block.rectangle.height) + 1; j++) {
                if (Map.map[i][j] == 9) {
                    BankBlock.masblock[i][j].rectangle.height = 50;
                }
                if (Map.map[i][j] == 10) {
                    BankBlock.masblock[i][j].rectangle.x = BankBlock.masblock[i][j].rectangle.x - 10;
                    BankBlock.masblock[i][j].rectangle.y = BankBlock.masblock[i][j].rectangle.y - 10;
                    BankBlock.masblock[i][j].rectangle.width = 50;
                    BankBlock.masblock[i][j].rectangle.height = 50;
                }
                if (BankBlock.masblock[i][j].rectangle.contains(touchPosx, touchPosy) && k != 1000 && !((CreateLevel.px-9)/50 == i && (CreateLevel.py-2)/50 == j)) {
                    if (Map.map[i][j] != k) {
                        Map.map[i][j] = k;
                    } else if (Map.map[i][j] == k) {
                        Map.map[i][j] = 0;
                    }
                }
                if (Map.map[i][j] == 9) {
                    BankBlock.masblock[i][j].rectangle.height = 25;
                }
                if (Map.map[i][j] == 10) {
                    BankBlock.masblock[i][j].rectangle.x = BankBlock.masblock[i][j].rectangle.x + 10;
                    BankBlock.masblock[i][j].rectangle.y = BankBlock.masblock[i][j].rectangle.y + 10;
                    BankBlock.masblock[i][j].rectangle.width = 30;
                    BankBlock.masblock[i][j].rectangle.height = 30;
                }
                if (BankBlock.masblock[i][j].rectangle.contains(touchPosx, touchPosy) && Map.map[i][j] == 0 && k == 1000) {
                    CreateLevel.px = i*50+9;
                    CreateLevel.py = j*50+2;
                }
            }
        }
    }
}
