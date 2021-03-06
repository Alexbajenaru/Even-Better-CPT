package cpt.rewrite;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Room5 extends Room {

    public Room5() {
        super();

        wallsColor = Color.DARKRED;
        doorColor = Color.BISQUE;

        createDoors();
        createWalls();
        fillRoom();

        int enterX = (int) doors.getChildren().get(0).getTranslateX();
        int enterY = (int) doors.getChildren().get(0).getTranslateY();

        Room.setSpawnX(enterX + getDOOR_H() / 2 - getPLAYER_H() / 2);
        Room.setSpawnY(enterY - getPLAYER_H());

        spawnX = Room.getSpawnX();
        spawnY = Room.getSpawnY();

        player = new Player(spawnX, spawnY, true, getPLAYER_W(), getPLAYER_H());

        root.getChildren().addAll(floor, walls, doors, roomObjects, player);

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

        //left wall 
        rect = new Rectangle(getWALL_W(), getROOM_H(), wallsColor);
        rect.setTranslateX(0);
        rect.setTranslateY(getHEADER_H());

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
        
        floor = new Group();
        Rectangle bg  = new Rectangle(0, 50, 900, 550);
        FloorMat mat = new FloorMat(800, 190, 75, 75);
        bg.setFill(Color.KHAKI);
        floor.getChildren().addAll(bg, mat);
    }

    @Override
    public void createDoors() {
        doors = new Group();

        Rectangle door;

        // door enter (0)
        door = new Rectangle(getDOOR_H(), getDOOR_W(), doorColor);
        door.setTranslateX(50);
        door.setTranslateY(getHEADER_H() + getROOM_H() - getDOOR_W());

        doors.getChildren().add(door);

        // door exit (1)
        door = new Rectangle(getDOOR_W(), getDOOR_H(), doorColor);
        door.setTranslateX(getROOM_W() - 10);
        door.setTranslateY(100 + getHEADER_H());

        doors.getChildren().add(door);
    }

    @Override
    public void fillRoom() {
        roomObjects = new Group();
        ScienceDesk desk = new ScienceDesk(30, 30, 66, 66);
        ScienceDesk desk2 = new ScienceDesk(146, 30, 66, 66);
        ScienceDesk desk3 = new ScienceDesk(264, 30, 66, 66);
        HealingMachine machine = new HealingMachine(830, 50, 48, 61);
        HealingMachine machine2 = new HealingMachine(782, 50, 48, 61);
        HealingMachine machine3 = new HealingMachine(830, 510, 48, 61);
        HealingMachine machine4 = new HealingMachine(782, 510, 48, 61);
        LabMachine machine5 = new LabMachine(500, 50, 55, 64);
        LabMachine machine6 = new LabMachine(575, 50, 55, 64);
        LabMachine machine7 = new LabMachine(650, 50, 55, 64);
        DisplayShelves shelf = new DisplayShelves(600, 234, 40, 44, true);
        DisplayShelves shelf2 = new DisplayShelves(600, 256, 40, 44, true);
        DisplayShelves shelf3 = new DisplayShelves(600, 278, 40, 44, true);
        DisplayShelves shelf4 = new DisplayShelves(600, 300, 40, 44, true);
        DisplayShelves shelf5 = new DisplayShelves(600, 322, 40, 44, true);
        DisplayShelves shelf6 = new DisplayShelves(600, 344, 40, 44, true);
        DisplayShelves shelf7 = new DisplayShelves(600, 366, 40, 44, true);
        DisplayShelves shelf8 = new DisplayShelves(400, 234, 40, 44, true);
        DisplayShelves shelf9 = new DisplayShelves(400, 256, 40, 44, true);
        DisplayShelves shelf10 = new DisplayShelves(400, 278, 40, 44, true);
        DisplayShelves shelf11 = new DisplayShelves(400, 300, 40, 44, true);
        DisplayShelves shelf12 = new DisplayShelves(400, 322, 40, 44, true);
        DisplayShelves shelf13 = new DisplayShelves(400, 344, 40, 44, true);
        DisplayShelves shelf14 = new DisplayShelves(400, 366, 40, 44, true);
        DisplayShelves shelf15 = new DisplayShelves(200, 234, 40, 44, true);
        DisplayShelves shelf16 = new DisplayShelves(200, 256, 40, 44, true);
        DisplayShelves shelf17 = new DisplayShelves(200, 278, 40, 44, true);
        DisplayShelves shelf18 = new DisplayShelves(200, 300, 40, 44, true);
        DisplayShelves shelf19 = new DisplayShelves(200, 322, 40, 44, true);
        DisplayShelves shelf20 = new DisplayShelves(200, 344, 40, 44, true);
        DisplayShelves shelf21 = new DisplayShelves(200, 366, 40, 44, true);
        TrashCan trash = new TrashCan(100, 60, 20, 25);
        TrashCan trash2 = new TrashCan(216, 60, 20, 25);
        TrashCan trash3 = new TrashCan(334, 60, 20, 25);
        DeskChair chair = new DeskChair(45, 90, 25, 30);
        DeskChair chair2 = new DeskChair(161, 90, 25, 30);
        DeskChair chair3 = new DeskChair(277, 90, 25, 30);
        Desk desk4 = new Desk(200, 490, 88, 88);
        Desk desk5 = new Desk(370, 490, 88, 88);
        Desk desk6 = new Desk(540, 490, 88, 88);
        Chair chair4 = new Chair(175, 500, 25, 30, false);
        Chair chair5 = new Chair(175, 540, 25, 30, false);
        Chair chair6 = new Chair(288, 500, 25, 30, true);
        Chair chair7 = new Chair(288, 540, 25, 30, true);
        Chair chair8 = new Chair(345, 500, 25, 30, false);
        Chair chair9 = new Chair(345, 540, 25, 30, false);
        Chair chair10 = new Chair(458, 500, 25, 30, true);
        Chair chair11 = new Chair(458, 540, 25, 30, true);
        Chair chair12 = new Chair(515, 500, 25, 30, false);
        Chair chair13 = new Chair(515, 540, 25, 30, false);
        Chair chair14 = new Chair(628, 500, 25, 30, true);
        Chair chair15 = new Chair(628, 540, 25, 30, true);

        roomObjects.getChildren().addAll(desk, desk2, desk3, shelf, shelf2, shelf3, shelf4, shelf5, shelf6, shelf7, shelf8, shelf9, shelf10, shelf11, shelf12, shelf13, shelf14, shelf15, shelf16, shelf17, shelf18, shelf19, shelf20, shelf21);
        roomObjects.getChildren().addAll(machine, machine2, machine3, machine4, trash, trash2, trash3, chair, chair2, chair3, machine5, machine6, machine7, desk4, desk5, desk6, chair4, chair5, chair6, chair7, chair8, chair9, chair10, chair11, chair12, chair13, chair14, chair15);
    }

}
