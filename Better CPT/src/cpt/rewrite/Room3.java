package cpt.rewrite;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Room3 extends Room {

    public Room3() {
        super();

        wallsColor = Color.DARKRED;
        doorColor = Color.BISQUE;

        createDoors();
        createWalls();

        int enterX = (int) doors.getChildren().get(0).getTranslateX();
        int enterY = (int) doors.getChildren().get(0).getTranslateY();

        Room.setSpawnX(enterX + getDOOR_H() / 2 - getPLAYER_H() / 2);
        Room.setSpawnY(enterY - getPLAYER_H());

        spawnX = Room.getSpawnX();
        spawnY = Room.getSpawnY();

        player = new Player(spawnX, spawnY, true, getPLAYER_W(), getPLAYER_H());

        root.getChildren().addAll(walls, doors, player);

        scene = new Scene(root, getSCENE_W(), getSCENE_H());

        setKeyHandlers();
    }

    @Override
    public void createWalls() {
        walls = new Group();

        Rectangle doorEnter = (Rectangle) doors.getChildren().get(0);
        Rectangle doorExit = (Rectangle) doors.getChildren().get(1);
        Rectangle rect;

        // top wall
        rect = new Rectangle(getROOM_W(), getWALL_W(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // bottom wall left of door
        rect = new Rectangle(doorEnter.getTranslateX(), getWALL_W(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H() + getROOM_H() - getWALL_W());

        walls.getChildren().add(rect);

        // bottom wall right of door
        rect = new Rectangle(getROOM_W() - doorEnter.getTranslateX() - getDOOR_H(), getWALL_W(), wallsColor);
        rect.setTranslateX(doorEnter.getTranslateX() + getDOOR_H());
        rect.setTranslateY(getHEADER_H() + getROOM_H() - getWALL_W());

        walls.getChildren().add(rect);

        // left wall above door
        rect = new Rectangle(getWALL_W(), doorExit.getTranslateY() - getHEADER_H(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // left wall under door
        rect = new Rectangle(getWALL_W(), getROOM_H() + getHEADER_H() - getDOOR_H() - doorExit.getTranslateY(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(doorExit.getTranslateY() + getDOOR_H());

        walls.getChildren().add(rect);

        //right wall 
        rect = new Rectangle(getWALL_W(), getROOM_H(), wallsColor);
        rect.setTranslateX(getROOM_W() - getWALL_W());
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);
    }

    @Override
    public void createDoors() {
        doors = new Group();

        Rectangle door;

        // door enter (0)
        door = new Rectangle(getDOOR_H(), getDOOR_W(), doorColor);
        door.setTranslateX(getROOM_W() - getDOOR_H() - 200);
        door.setTranslateY(getHEADER_H() + getROOM_H() - getDOOR_W());

        doors.getChildren().add(door);

        // door exit (1)
        door = new Rectangle(getDOOR_W(), getDOOR_H(), doorColor);
        door.setTranslateX(0);
        door.setTranslateY(200 + getHEADER_H());

        doors.getChildren().add(door);
    }
}
