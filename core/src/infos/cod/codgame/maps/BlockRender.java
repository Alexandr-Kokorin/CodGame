package infos.cod.codgame.maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import infos.cod.codgame.states.GameMenu;


public class BlockRender {

    public void rbg(SpriteBatch sb, float camx, float camy,int sizeX,int sizeY,int size){
        sb.begin();
        for (int x = 0; x < 2; x++) {
            sb.draw(BankBlock.block.bg, camx - sizeX / 2 + size * x, camy - sizeY / 2, size, size);
        }
        sb.end();
    }

    public void r1(SpriteBatch sb, int i, int j){
        sb.begin();
        if (Map.map[i][j] == 1) {
            try {
                if (Map.map[i][j + 1] == 0 || Map.map[i][j + 1] == 100 || Map.map[i][j + 1] == 9 || Map.map[i][j + 1] == 10 || Map.map[i][j + 1] == 3) {
                    sb.draw(BankBlock.block.texturet, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
                } else {
                    sb.draw(BankBlock.block.texture, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
                }
            }catch (ArrayIndexOutOfBoundsException e){
                sb.draw(BankBlock.block.texture, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
            }
        }
        sb.end();
    }

    public void r2(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 2) {
            sb.draw(BankBlock.block.t2, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }

    public void r3(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 3) {
            sb.draw(BankBlock.block.redact, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }
    public void r4(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 4) {
            sb.draw(BankBlock.block.sand, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }

    public void r5(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 5) {
            sb.draw(BankBlock.block.black, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }

    public void r6(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 6) {
            sb.draw(BankBlock.block.blue, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }
    public void r7(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 7) {
            sb.draw(BankBlock.block.red, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }

    public void r9(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 9) {
            sb.draw(BankBlock.block.ship, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y,BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }

    public void r10(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 10) {
            sb.draw(BankBlock.block.star, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y,BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }

    public void r100(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 100) {
            sb.draw(BankBlock.block.texture2, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y, BankBlock.masblock[i][j].rectangle.width, BankBlock.masblock[i][j].rectangle.height);
        }
        sb.end();
    }
}
