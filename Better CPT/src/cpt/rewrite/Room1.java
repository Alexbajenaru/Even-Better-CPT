package cpt.rewrite;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Room1 extends Room {

    public Room1() {
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

        // top wall
        rect = new Rectangle(getROOM_W(), getWALL_W(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // bottom wall
        rect = new Rectangle(getROOM_W(), getWALL_W(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getROOM_H() - getWALL_W() +getHEADER_H());

        walls.getChildren().add(rect);

        // left wall above door
        rect = new Rectangle(getWALL_W(), doorEnter.getTranslateY()-getHEADER_H(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // left wall under door
        rect = new Rectangle(getWALL_W(), getROOM_H()+ getHEADER_H() - getDOOR_H() - doorEnter.getTranslateY(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(doorEnter.getTranslateY()+ getDOOR_H());

        walls.getChildren().add(rect);

        // right wall above door
        rect = new Rectangle(getWALL_W(), doorExit.getTranslateY()- getHEADER_H(), wallsColor); // to find how long the vertical wall has to be, make it the length of the x coordinate of the door
        rect.setTranslateX(getROOM_W() - getWALL_W());
        rect.setTranslateY(getHEADER_H());

        walls.getChildren().add(rect);

        // right wall under door
        rect = new Rectangle(getWALL_W(), getROOM_H() + getHEADER_H() - doorExit.getTranslateY() - getDOOR_H(), wallsColor);
        rect.setTranslateX(getROOM_W() - getWALL_W());
        rect.setTranslateY(doorExit.getTranslateY() + getDOOR_H());

        walls.getChildren().add(rect);
    }

    @Override
    public void createDoors() {
        doors = new Group();
        
        Rectangle door;

        // door enter (0)
        door = new Rectangle(getDOOR_W(), getDOOR_H(), doorColor);
        door.setTranslateX(0);
        door.setTranslateY(getROOM_H() - getDOOR_H() - 50 + getHEADER_H());

        doors.getChildren().add(door);

        // door exit (1)
        door = new Rectangle(getDOOR_W(), getDOOR_H(), doorColor);
        door.setTranslateX(getROOM_W() - 10);
        door.setTranslateY(200 + getHEADER_H());

        doors.getChildren().add(door);
    }

    @Override
    public void fillRoom() {
        roomObjects = new Group();
        
        Crate crate = new Crate(780, 40, 50, 50);
        Crate crate2 = new Crate(830, 40, 50, 50);
        Crate crate3 = new Crate(830, 68, 50, 50);
        Crate crate4 = new Crate(250, 530, 50, 50);
        Crate crate5 = new Crate(300, 530, 50, 50);
        Table table = new Table(350, 250, 200, 100);
        Bookcase bookcase = new Bookcase(100, 20, 110, 75);
        Bookcase bookcase2 = new Bookcase(175, 20, 110, 75);
        Bookcase bookcase3 = new Bookcase(250, 20, 110, 75);
        Bookcase bookcase4 = new Bookcase(325, 20, 110, 75);
        Desk desk = new Desk(20, 220, 100, 175);
        DeskChair deskChair = new DeskChair(125, 280, 40, 40);
        IronBeam ironBeam = new IronBeam(500, 470, 50, 110);
        IronBeam ironBeam2 = new IronBeam(550, 470, 50, 110);
        IronBeam ironBeam3 = new IronBeam(600, 470, 50, 110);
        ComputerDesk computerDesk = new ComputerDesk(600, 20, 100, 75);
        FloorMat mat = new FloorMat(800, 290, 75, 75);
        roomObjects.getChildren().addAll(crate, crate2, crate3, crate4, crate5, table, bookcase, bookcase2, bookcase3, bookcase4, desk, deskChair, ironBeam, ironBeam2, ironBeam3, computerDesk, mat);        
    }

    
}
