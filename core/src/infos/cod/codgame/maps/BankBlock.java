package infos.cod.codgame.maps;

public class BankBlock {

    public static BlockMap block;
    public static BlockMap[][] masblock;

    public BankBlock() {
        masblock = new BlockMap[Map.x][Map.y];
        for (int i = 0; i < Map.x; i++) {
            for (int j = 0; j < Map.y; j++) {
                if (Map.map[i][j] == 10) {
                    block = new BlockMap(i * 50 + 10, j * 50 + 10,30,30);
                    masblock[i][j] = block;
                }
                if (Map.map[i][j] == 9) {
                    block = new BlockMap(i * 50, j * 50,50,25);
                    masblock[i][j] = block;
                }
                if (Map.map[i][j] != 9 && Map.map[i][j] != 10) {
                    block = new BlockMap(i * 50, j * 50, 50, 50);
                    masblock[i][j] = block;
                }
            }
        }
        block = new BlockMap();
    }
}
