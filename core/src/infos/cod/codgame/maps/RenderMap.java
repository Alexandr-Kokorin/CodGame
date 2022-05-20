package infos.cod.codgame.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RenderMap extends BlockRender {

    public void render(SpriteBatch sb, float camx, float camy) {
        rbg(sb,camx,camy,600,360,365);
        for (int i = (int) ((camx - 300) / BankBlock.block.rectangle.width); i < (int) ((camx + 300) / BankBlock.block.rectangle.width) + 1; i++) {
            for (int j = (int) ((camy - 180) / BankBlock.block.rectangle.height); j < (int) ((camy + 180) / BankBlock.block.rectangle.height) + 1; j++) {
                r1(sb,i,j);
                r2(sb,i,j);
                r3(sb,i,j);
                r4(sb,i,j);
                r5(sb,i,j);
                r6(sb,i,j);
                r7(sb,i,j);
                r100(sb,i,j);
                r9(sb,i,j);
                r10(sb,i,j);
            }
        }
    }

}
