package cpt.rewrite;

import javafx.scene.shape.Rectangle;

public class Player extends Character {

    public Player() {
        super(0, 0, false, 0, 0);
    }

    public Player(double x, double y, boolean alive, double width, double height) {
        super(x, y, alive, width, height);
    }

}
