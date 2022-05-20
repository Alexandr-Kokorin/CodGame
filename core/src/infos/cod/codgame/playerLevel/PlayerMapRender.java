package infos.cod.codgame.playerLevel;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import infos.cod.codgame.maps.BankBlock;
import infos.cod.codgame.maps.BlockRender;
import infos.cod.codgame.maps.Map;

public class PlayerMapRender extends BlockRender {

    public void render(SpriteBatch sb, float camx, float camy) {
        rbg(sb,camx,camy,800,480,485);
        for (int i = (int) ((camx - 400) / BankBlock.block.rectangle.width); i < (int) ((camx + 200) / BankBlock.block.rectangle.width) + 1; i++) {
            for (int j = (int) ((camy - 240) / BankBlock.block.rectangle.height); j < (int) ((camy + 240) / BankBlock.block.rectangle.height) + 1; j++) {
                r1(sb,i,j);
                r2(sb,i,j);
                r3(sb,i,j);
                r4(sb,i,j);
                r100(sb,i,j);
                r9(sb,i,j);
                r10(sb,i,j);
                rr(sb,i,j);
            }
        }
    }

    private void rr(SpriteBatch sb,int i,int j){
        sb.begin();
        if (Map.map[i][j] == 8 || Map.map[i][j] == 9 || Map.map[i][j] == 100 || Map.map[i][j] == 10) {
        }else {
            sb.draw(BankBlock.block.cod, BankBlock.masblock[i][j].rectangle.x, BankBlock.masblock[i][j].rectangle.y,50,50);
        }
        sb.end();
    }
}
