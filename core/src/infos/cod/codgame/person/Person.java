package infos.cod.codgame.person;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Person {

    public Texture texturer,texturel;
    public Rectangle rectangle;
    public Animation Animationr,Animationl;
    public float speedX, speedY, speedingY;
    public static float x, y;

    public Person(int x, int y) {
        Person.x = x;
        Person.y = y;
    }

    public Person(float x, float y) {
        texturer = new Texture("persr.png");
        texturel = new Texture("persl.png");
        Animationr = new Animation(new TextureRegion(texturer), 4, 0.5f);
        Animationl = new Animation(new TextureRegion(texturel), 4, 0.5f);
        rectangle = new Rectangle(x, y, texturer.getWidth() /4-6, texturer.getHeight());
        speedingY = 500;
        speedX = 0;
    }

    public void update(float dt) {
        if (speedX >= 0) Animationr.update(dt,speedX);
        if (speedX <= 0) Animationl.update(dt,speedX);
        rectangle.x += speedX * dt;
        speedY -= speedingY * dt;
        if (speedY > 500) speedY = 500;
        rectangle.y += speedY * dt;
        if (speedX < 0) speedX += 15;
        if (speedX > 0) speedX -= 15;
        x = rectangle.x;
        y = rectangle.y;
    }

    public void dispose() {
        texturer.dispose();
        texturel.dispose();
    }
}
