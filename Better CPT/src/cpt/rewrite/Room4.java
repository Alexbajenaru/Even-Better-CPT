package cpt.rewrite;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Room4 extends Room {

    public Room4() {
        super();

        wallsColor = Color.DARKRED;
        doorColor = Color.BISQUE;

        createDoors();
        createWalls();
        fillRoom();

        int enterX = (int) doors.getChildren().get(0).getTranslateX();
        int enterY = (int) doors.getChildren().get(0).getTranslateY();

        Room.setSpawnX(enterX- getPLAYER_W());
        Room.setSpawnY(enterY + getDOOR_H() / 2 - getPLAYER_H() / 2);

        spawnX = Room.getSpawnX();
        spawnY = Room.getSpawnY();

        player = new Player(spawnX, spawnY, true, getPLAYER_W(), getPLAYER_H());

        root.getChildren().addAll(walls, doors, roomObjects, player);

        scene = new Scene(root, getSCENE_W(), getSCENE_H());

        setKeyHandlers();
    }

    @Override
    public void createWalls() {
        walls = new Group();

        Rectangle doorEnter = (Rectangle) doors.getChildren().get(0);
        Rectangle doorExit = (Rectangle) doors.getChildren().get(1);
        Rectangle rect;

        // top wall left of door
        rect = new Rectangle(doorExit.getTranslateX(), getWALL_W(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // top wall right of door
        rect = new Rectangle(getROOM_W() - doorExit.getTranslateX() - getDOOR_H(), getWALL_W(), wallsColor);
        rect.setTranslateX(doorExit.getTranslateX() + getDOOR_H());
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // bottom wall
        rect = new Rectangle(getROOM_W(), getWALL_W(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getROOM_H() - getWALL_W() + getHEADER_H());

        walls.getChildren().add(rect);

        //left wall 
        rect = new Rectangle(getWALL_W(), getROOM_H(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // right wall above door
        rect = new Rectangle(getWALL_W(), doorEnter.getTranslateY() - getHEADER_H(), wallsColor);
        rect.setTranslateX(getROOM_W() - getWALL_W());
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // right wall under door
        rect = new Rectangle(getWALL_W(), getROOM_H() + getHEADER_H() - getDOOR_H() - doorEnter.getTranslateY(), wallsColor);
        rect.setTranslateX(getROOM_W() - getWALL_W());
        rect.setTranslateY(doorEnter.getTranslateY() + getDOOR_H());

        walls.getChildren().add(rect);
    }

    @Override
    public void createDoors() {
        doors = new Group();

        Rectangle door;

        // door enter (0)
        door = new Rectangle(getDOOR_W(), getDOOR_H(), doorColor);
        door.setTranslateX(getROOM_W() - getDOOR_W());
        door.setTranslateY(200 + getHEADER_H());

        doors.getChildren().add(door);

        // door exit (1)
        door = new Rectangle(getDOOR_H(), getDOOR_W(), doorColor);
        door.setTranslateX(50);
        door.setTranslateY(getHEADER_H());

        doors.getChildren().add(door);
    }
    
        @Override
    public void fillRoom() {
        roomObjects = new Group();

        //BigOilDrum bod1 = new BigOilDrum();
//        Wood wood1 = new Wood(600, 300, 80, 80);
        DiningTable table = new DiningTable(100, 400, 145, 120);
        Kitchen stoveAndPots = new Kitchen(588, 40, 75, 70, "stoveandpots");
        Kitchen microwave = new Kitchen(493, 18, 100, 101, "microwave");
        Kitchen stoveTeapot = new Kitchen(663, 24, 119, 86, "stoveteapot");
        Kitchen lightCounter = new Kitchen(338, 32, 170, 80, "lightcounter");
        Kitchen longCounter = new Kitchen(311, 35, 35, 160, "longcounter");
        Kitchen cornerCounter = new Kitchen(760, 32, 125, 130, "cornercounter");

        Kitchen vase1 = new Kitchen(320, 390, 30, 40, "vase");
        Kitchen vase2 = new Kitchen(320, 420, 30, 40, "vase");
        Kitchen vase3 = new Kitchen(320, 450, 30, 40, "vase");
        Kitchen vase4 = new Kitchen(320, 480, 30, 40, "vase");
        Kitchen vase5 = new Kitchen(320, 510, 30, 40, "vase");
        Kitchen vase6 = new Kitchen(320, 540, 30, 40, "vase");

        TrashCan trash1 = new TrashCan(290, 165, 20, 25);
        TrashCan trash2 = new TrashCan(290, 75, 20, 25);
        TrashCan trash3 = new TrashCan(290, 105, 20, 25);
        TrashCan trash4 = new TrashCan(290, 135, 20, 25);
        
        

        roomObjects.getChildren().addAll(table, stoveTeapot, lightCounter, longCounter, stoveAndPots, microwave, cornerCounter, vase1, vase2, vase3, vase4, vase5, vase6, trash1, trash2, trash3, trash4);

    }

}
