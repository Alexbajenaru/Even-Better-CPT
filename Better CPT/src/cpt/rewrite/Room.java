package cpt.rewrite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class Room {

    static ArrayList rooms = new ArrayList<Room>();
    private final int ROOM_W = 900;
    private final int ROOM_H = 550;
    static final int SCENE_W = 900;
    static final int SCENE_H = 700;
    private final int WALL_W = 20;
    private final int DOOR_W = 10;
    private final int DOOR_H = 150;
    private final int PLAYER_W = 40;
    private final int PLAYER_H = 40;
    private final int HEADER_H = 50;
    static int spawnX;
    static int spawnY;
    static Color wallsColor;
    static Color doorColor;
    private Image image = null;
    private ImagePattern ip;

    Group walls;
    Group doors;
    Group roomObjects;
    Group root;
    Scene scene;
    Player player;

    public Room() {
        root = new Group();
    }

    public void createWalls() {
    }

    public void createDoors() {
    }

    public void fillRoom() {

    }

    public void spawnPlayer() {
        player.setTranslateX(spawnX);
        player.setTranslateY(spawnY);
    }

    public void spawnPlayer(int x, int y) {
        player.setTranslateX(x);
        player.setTranslateY(y);
        root.getChildren().add(player);
    }

    public int getDOOR_W() {
        return DOOR_W;
    }

    public int getDOOR_H() {
        return DOOR_H;
    }

    public int getPLAYER_H() {
        return PLAYER_H;
    }

    public int getPLAYER_W() {
        return PLAYER_W;
    }

    public static int getSCENE_H() {
        return SCENE_H;
    }

    public static int getSCENE_W() {
        return SCENE_W;
    }

    public int getWALL_W() {
        return WALL_W;
    }

    public int getROOM_W() {
        return ROOM_W;
    }

    public int getROOM_H() {
        return ROOM_H;
    }

    public int getHEADER_H() {
        return HEADER_H;
    }

    public static int getSpawnX() {
        return spawnX;
    }

    public static int getSpawnY() {
        return spawnY;
    }

    public static void setSpawnX(int spawnX) {
        Room.spawnX = spawnX;
    }

    public static void setSpawnY(int spawnY) {
        Room.spawnY = spawnY;
    }

    public Player getPlayer() {
        return player;
    }

    public Scene getScene() {
        return scene;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setKeyHandlers() {

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                    try {
                        image = new Image(new FileInputStream("src/Sprites/Player_left.png"), 100, 100, true, true);
                    } catch (IOException f) {
                    }
                    ip = new ImagePattern(image);
                    player.setFill(ip);
                    player.setSpeedX(-1 * player.getSpeed());
                    break;
                case RIGHT:
                    try {
                        image = new Image(new FileInputStream("src/Sprites/Player_right.png"), 100, 100, true, true);
                    } catch (IOException f) {
                    }
                    ip = new ImagePattern(image);
                    player.setFill(ip);
                    player.setSpeedX(player.getSpeed());
                    break;
                case UP:
                    try {
                        image = new Image(new FileInputStream("src/Sprites/Player_up.png"), 100, 100, true, true);
                    } catch (IOException f) {
                    }
                    ip = new ImagePattern(image);
                    player.setFill(ip);
                    player.setSpeedY(-1 * player.getSpeed());
                    break;
                case DOWN:
                    try {
                        image = new Image(new FileInputStream("src/Sprites/Player_down.png"), 100, 100, true, true);
                    } catch (IOException f) {
                    }
                    ip = new ImagePattern(image);
                    player.setFill(ip);
                    player.setSpeedY(player.getSpeed());
                    break;
                default:
            }
            player.update();

            if (player.getBoundsInParent().intersects(doors.getChildren().get(0).getBoundsInParent())) {
                CPTRewrite.prevRoom();
            }

            if (player.getBoundsInParent().intersects(doors.getChildren().get(1).getBoundsInParent())) {
                CPTRewrite.nextRoom();
            }
        });

        scene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case LEFT:
                case RIGHT:
                    player.setSpeedX(0);
                    break;
                case UP:
                case DOWN:
                    player.setSpeedY(0);
                    break;
            }
            player.update();
        });
    }

    public void start() {

    }

    public void stop() {

    }

}
