package infos.cod.codgame.cod;

import infos.cod.codgame.maps.Map;

public class CodRender {

    public void update(int k, int i, int j, int com) {
        if (k == 1) {
            Map.map[i][j] = 11;
        }
        if (k == 2) {
            Map.map[i][j] = 12;
        }
        if (k == 42) {
            Map.map[i][j] = Cods.com[com];
        }
        if (k == 3 && com > 0) {
            if (Cods.cod[com - 1][0] == 1) {
                Map.map[Cods.cod[com - 1][1]][Cods.cod[com - 1][2]] = Cods.com[com-1];
            }
            if (Cods.cod[com - 1][0] == 2) {
                Map.map[Cods.cod[com - 1][1]][Cods.cod[com - 1][2]] = 0;
            }
            if (Cods.cod[com - 1][0] == 4) {
                Map.map[Cods.cod[com - 1][1]][Cods.cod[com - 1][2]] = Cods.com[com-1];
                Map.map[Cods.cod[com - 1][3]][Cods.cod[com - 1][4]] = 0;
            }
            Cods.cod[com - 1][0] = 0;
            Cods.cod[com - 1][1] = 0;
            Cods.cod[com - 1][2] = 0;
            Cods.cod[com - 1][3] = 0;
            Cods.cod[com - 1][4] = 0;
            Cods.com[com-1] = 0;
        }
    }

    public void render() {
        for (int i = 0; i < Cods.x; i++) {
            if (Cods.cod[i][0] == 1) {
                Map.map[Cods.cod[i][1]][Cods.cod[i][2]] = 0;
            }
            if (Cods.cod[i][0] == 2) {
                Map.map[Cods.cod[i][1]][Cods.cod[i][2]] = 3;
            }
            if (Cods.cod[i][0] == 4) {
                Map.map[Cods.cod[i][1]][Cods.cod[i][2]] = 0;
                Map.map[Cods.cod[i][3]][Cods.cod[i][4]] = Cods.com[i];
            }
        }
    }
}
