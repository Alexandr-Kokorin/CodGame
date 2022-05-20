package infos.cod.codgame.maps;

public class Map {

    public static int[][] map;
    public static int x, y;

    public Map(int x, int y, int[][] level) {
        Map.x = x;
        Map.y = y;
        map = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    map[i][j] = level[i][j];
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
    }

    public Map(int x,int y){
        Map.x = x;
        Map.y = y;
        map = new int[x][y];
    }

    public static void rewrite(int [][]mapd){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    if (map[i][j] != 10 && mapd[i][j] == 10) {
                        BankBlock.masblock[i][j].rectangle.x = BankBlock.masblock[i][j].rectangle.x + 10;
                        BankBlock.masblock[i][j].rectangle.y = BankBlock.masblock[i][j].rectangle.y + 10;
                        BankBlock.masblock[i][j].rectangle.width = 30;
                        BankBlock.masblock[i][j].rectangle.height = 30;
                    }
                    map[i][j] = mapd[i][j];
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
    }
}
