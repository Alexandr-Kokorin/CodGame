package infos.cod.codgame.button;

public class ButtonLevel extends Button {

    public String name;

    public ButtonLevel(String texture, float x, float y, float width, float height,String name) {
        super(texture, x, y, width, height);
        this.name = name;
    }
}
