package infos.cod.codgame.button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Button {

    public Texture texture;
    public Rectangle rectangle;

    public Button(String texture, float x, float y, float width, float height) {
        this.texture = new Texture(texture);
        this.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        rectangle = new Rectangle(x, y, width, height);
    }

    public void newTexture(String texture){
        this.texture = new Texture(texture);
        this.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public void dispose() {
        texture.dispose();
    }
}
