package infos.cod.codgame.cod;

import infos.cod.codgame.button.Button;
import infos.cod.codgame.levels.Level;
import infos.cod.codgame.maps.BankBlock;
import infos.cod.codgame.maps.Map;
import infos.cod.codgame.states.GameStateManager;
import infos.cod.codgame.states.PlayGame;

public class CodInput {

    private CodRender codrender;
    public int com, k;
    private boolean ist;

    public CodInput() {
        codrender = new CodRender();
        com = 0;
        k = 0;
        ist = false;
    }

    public void Input(float camx, float camy, float touchPosx, float touchPosy, GameStateManager gsm, Button com1, Button com2, Button com3, Button com4, Button run, Button esc) {
        if (com1.rectangle.contains(touchPosx, touchPosy) && (k == 0 || k == 2 || k == 4) && Level.isd && !ist) {
            k = 1;
            com1.newTexture("comn1be.png");
            if (Level.isc) {com2.newTexture("comn2e.png");
            } else com2.newTexture("closee.png");
            if (Level.ist) com4.newTexture("teleporte.png");
            else com4.newTexture("closee.png");
        }
        else if (com1.rectangle.contains(touchPosx, touchPosy) && k == 1 && Level.isd && !ist) {
            k = 0;
            com1.newTexture("comn1e.png");
        }
        if (com2.rectangle.contains(touchPosx, touchPosy) && (k == 0 || k == 1 || k == 4) && Level.isc && !ist) {
            k = 2;
            com2.newTexture("comn2be.png");
            if (Level.isd) com1.newTexture("comn1e.png");
            else com1.newTexture("closee.png");
            if (Level.ist) com4.newTexture("teleporte.png");
            else com4.newTexture("closee.png");
        }
        else if (com2.rectangle.contains(touchPosx, touchPosy) && k == 2 && Level.isc && !ist) {
            k = 0;
            com2.newTexture("comn2e.png");
        }
        if (com4.rectangle.contains(touchPosx, touchPosy) && (k == 0 || k == 1 || k == 2) && Level.ist && !ist) {
            k = 4;
            com4.newTexture("teleportbe.png");
            if (Level.isd) com1.newTexture("comn1e.png");
            else com1.newTexture("closee.png");
            if (Level.isc) com2.newTexture("comn2e.png");
            else com2.newTexture("closee.png");
        }
        else if (com4.rectangle.contains(touchPosx, touchPosy) && k == 4 && Level.isc && !ist) {
            k = 0;
            com4.newTexture("teleporte.png");
        }
        if (com3.rectangle.contains(touchPosx, touchPosy) && !ist) {
            codrender.update(3, 0, 0, com);
            com--;
            if (com < 0) com = 0;
        }
        if (run.rectangle.contains(touchPosx, touchPosy) && !ist) {
            codrender.render();
            gsm.push(new PlayGame(gsm));
        }
        for (int i = (int) ((camx - 400) / BankBlock.block.rectangle.width); i < (int) ((camx + 200) / BankBlock.block.rectangle.width) + 1; i++) {
            for (int j = (int) ((camy - 240) / BankBlock.block.rectangle.height); j < (int) ((camy + 240) / BankBlock.block.rectangle.height) + 1; j++) {
                if (BankBlock.masblock[i][j].rectangle.contains(touchPosx, touchPosy) && ((k == 1 && Map.map[i][j] != 0 && Map.map[i][j] != 8 && Map.map[i][j] != 9 && Map.map[i][j] != 10 && Map.map[i][j] != 100 && Map.map[i][j] != 11) || (k == 2 && (Map.map[i][j] == 0 || Map.map[i][j] == 11))) && com < Cods.x) {
                    Cods.add(com, 0, k);
                    Cods.add(com, 1, i);
                    Cods.add(com, 2, j);
                    if (k == 1){
                        Cods.addcom(com,Map.map[i][j]);
                    }
                    codrender.update(k, i, j, com);
                    com++;
                }
                if (BankBlock.masblock[i][j].rectangle.contains(touchPosx, touchPosy) && k == 4 && com < Cods.x) {
                    if (!ist && Map.map[i][j] != 0 && Map.map[i][j] != 8 && Map.map[i][j] != 9 && Map.map[i][j] != 10 && Map.map[i][j] != 100 && Map.map[i][j] != 11) {
                        Cods.add(com, 0, k);
                        Cods.add(com, 1, i);
                        Cods.add(com, 2, j);
                        Cods.addcom(com,Map.map[i][j]);
                        codrender.update(1, i, j, com);
                        ist = true;
                    }
                    if (ist && Map.map[i][j] == 0) {
                        Cods.add(com, 3, i);
                        Cods.add(com, 4, j);
                        codrender.update(42, i, j, com);
                        ist = false;
                        com++;
                    }
                }
            }
        }
        if (esc.rectangle.contains(touchPosx,touchPosy)) {
            for (int i = 0; i < Cods.x; i++){
                codrender.update(3, 0, 0, com);
                com--;
                if (com < 0) com = 0;
            }
            Level.col--;
            gsm.push(new PlayGame(gsm));
        }
    }
}
