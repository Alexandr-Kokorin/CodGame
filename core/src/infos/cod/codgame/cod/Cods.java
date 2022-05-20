package infos.cod.codgame.cod;

public class Cods {

    static int[][] cod;
    static int[] com;
    public static int x;

    public Cods(int lim) {
        cod = new int[lim][5];
        com = new int[lim];
        x = lim;
    }

    static void add(int x, int y, int l) {
        try {
            cod[x][y] = l;
        } catch (ArrayIndexOutOfBoundsException e) {}
    }

    static void addcom(int x, int l) {
        try {
            com[x] = l;
        } catch (ArrayIndexOutOfBoundsException e) {}
    }

    public static void reset() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 5; j++) {
                cod[i][j] = 0;
            }
        }
        for (int i = 0; i < x; i++) {
            com[i] = 0;
        }
    }
}
