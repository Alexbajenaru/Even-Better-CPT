package cpt.rewrite;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Character extends Rectangle {

    //private int x, y;
    private boolean alive;
    private int speed;

    private int speedX, speedY;

    private Bullet gun;
    private Image image = null;
    private ImagePattern ip;

    characterAction action = characterAction.NONE;

    public Character(double x, double y, boolean alive, double width, double height) {
        super(width, height);
        //this.x = x;
        //this.y = y;
        this.setX(x);
        this.setY(y);
        //this.setWidth(width);
        //this.setHeight(height);
        this.alive = alive;
        this.speed = 10;
        this.speedX = 0;
        this.speedY = 0;
        try {
            image = new Image(new FileInputStream("src/Sprites/Player_down.png"), 100, 100, true, true);
        } catch (IOException f) {
        }
        ip = new ImagePattern(image);
        this.setFill(ip);

    }

    public void setAction(characterAction action) {
        this.action = action;
    }

    public characterAction getAction() {
        return action;
    }

    public void setX(int x) {
        //this.x = x;
        super.setX(x);
    }

    public void setY(int y) {
        //this.y = y;
        super.setY(y);
    }

    public void setAlive(boolean b) {
        this.alive = b;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSpeedX(int speed) {
        this.speedX = speed;
    }

    public void setSpeedY(int speed) {
        this.speedY = speed;
    }

    public void update() {
        setTranslateX(getTranslateX() + speedX);
        setTranslateY(getTranslateY() + speedY);
    }

}
