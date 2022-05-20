package infos.cod.codgame.person;

import infos.cod.codgame.button.Button;

public class PersonMove {
    /*
    private int f = 0, k = 0;

    public void Move(float touchPosx, int v, Person person) {
        if ((touchPosx > person.rectangle.x + person.rectangle.width && v == 1) || (touchPosx < person.rectangle.x && v == (-1))) {
            if (Collisions.isy) {
                person.speedX = 200 * v;
                k = 1;
                f = 0;
            }
            if (Collisions.isx && Collisions.isy) {
                person.speedY = 225;
                k = 2;
            }
            if (Collisions.isx) {
                person.speedX = v;
                k = 2;
            }
            if (!Collisions.isx && !Collisions.isy && f == 0) {
                person.speedX = 200 * v;
                f = 1;
            }
            if (!Collisions.isx && !Collisions.isy && f == 1) {
                person.speedX = 0;
            }
            if (k == 1) Collisions.isy = false;
            if (k == 2) {
                Collisions.isx = false;
                Collisions.isy = false;
            }
        }
    }
     */
    public void Move(float touchPosx, float touchPosy, Person person, Button right, Button left){
        if (right.rectangle.contains(touchPosx, touchPosy) && Collisions.isy) {
            person.speedX = 195;
        }
        if (right.rectangle.contains(touchPosx, touchPosy) && !Collisions.isy) {
            person.speedX = 45;
        }
        if (left.rectangle.contains(touchPosx, touchPosy) && Collisions.isy) {
            person.speedX = (-195);
        }
        if (left.rectangle.contains(touchPosx, touchPosy) && !Collisions.isy) {
            person.speedX = (-45);
        }
        if (Collisions.isx && Collisions.isy) {
            person.speedY = 225;
        }
        Collisions.isx = false;
        Collisions.isy = false;
    }
}
