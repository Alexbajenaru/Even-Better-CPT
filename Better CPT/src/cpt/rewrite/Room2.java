package cpt.rewrite;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Room2 extends Room {

    public Room2() {
        super();

        wallsColor = Color.DARKRED;
        doorColor = Color.BISQUE;

        createDoors();
        createWalls();
        fillRoom();

        int enterX = (int) doors.getChildren().get(0).getTranslateX();
        int enterY = (int) doors.getChildren().get(0).getTranslateY();

        Room.setSpawnX(enterX + getDOOR_W());
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
        rect.setTranslateX(doorExit.getTranslateX()+getDOOR_H());
        rect.setTranslateY(getHEADER_H());
        
        walls.getChildren().add(rect);

        // bottom wall
        rect = new Rectangle(getROOM_W(), getWALL_W(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getROOM_H() - getWALL_W() + getHEADER_H());

        walls.getChildren().add(rect);

        // left wall above door
        rect = new Rectangle(getWALL_W(), doorEnter.getTranslateY() - getHEADER_H(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // left wall under door
        rect = new Rectangle(getWALL_W(), getROOM_H() + getHEADER_H() - getDOOR_H() - doorEnter.getTranslateY(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(doorEnter.getTranslateY() + getDOOR_H());

        walls.getChildren().add(rect);

        //right wall 
        rect = new Rectangle(getWALL_W(), getROOM_H(), wallsColor);
        rect.setTranslateX(getROOM_W()-getWALL_W());
        rect.setTranslateY(getHEADER_H());
        
        walls.getChildren().add(rect);
    }

    @Override
    public void createDoors() {
        doors = new Group();
        
        Rectangle door;

        // door enter (0)
        door = new Rectangle(getDOOR_W(), getDOOR_H(), doorColor);
        door.setTranslateX(0);
        door.setTranslateY(200 + getHEADER_H());

        doors.getChildren().add(door);

        // door exit (1)
        door = new Rectangle(getDOOR_H(), getDOOR_W(), doorColor);
        door.setTranslateX(getROOM_W()- getDOOR_H()-200);
        door.setTranslateY(getHEADER_H());
        
        doors.getChildren().add(door);
    }
    
    @Override
    public void fillRoom() {
        roomObjects = new Group();

        //BigOilDrum bod1 = new BigOilDrum();
        Crate crate = new Crate(20, 470, 50, 50);
        Crate crate2 = new Crate(20, 500, 50, 50);
        Crate crate3 = new Crate(20, 530, 50, 50);
        Crate crate4 = new Crate(250, 530, 50, 50);
        Crate crate5 = new Crate(300, 530, 50, 50);
        OilDrum bod1 = new OilDrum(805, 505, 70, 70, true);
        OilDrum bod2 = new OilDrum(725, 505, 70, 70, true);
        OilDrum bod3 = new OilDrum(465, 265, 70, 70, true);
        OilDrum od1 = new OilDrum(423, 265, 30, 57, false);
        OilDrum od2 = new OilDrum(383, 265, 30, 57, false);
        OilDrum od3 = new OilDrum(775, 120, 30, 57, false);
        OilDrum od4 = new OilDrum(775, 150, 30, 57, false);
//        Wood wood1 = new Wood(600, 300, 80, 80);
        Table table = new Table(170, 180, 100, 60);
        TrashCan trash1 = new TrashCan(857, 300, 20, 25);
        TrashCan trash2 = new TrashCan(857, 330, 20, 25);
        TrashCan trash3 = new TrashCan(857, 360, 20, 25);
        TrashCan trash4 = new TrashCan(857, 270, 20, 25);

        roomObjects.getChildren().addAll(crate, crate2, crate3, crate4, crate5, bod1, bod2, bod3, od1, od2, od3, od4, table, trash1, trash2, trash3, trash4);

    }

}
