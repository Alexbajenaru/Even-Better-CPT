/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt.rewrite;

import cpt.rewrite.Furniture;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 *
 * @author along
 */
public class Kitchen extends Furniture {

    private Image image = null;
    private ImagePattern ip;
    private String kitchenType = "";

    public Kitchen(double x, double y, double width, double height, String kitchenType) {
        super(x, y, width, height);
        try {
            if (kitchenType == "stoveandpots") {
                image = new Image(new FileInputStream("src/Sprites/StovePot.png"), 100, 100, true, true);
            } else if (kitchenType == "microwave") {
                image = new Image(new FileInputStream("src/Sprites/Microwave.png"), 100, 100, true, true);
            } else if (kitchenType == "stoveteapot") {
                image = new Image(new FileInputStream("src/Sprites/StoveTeapot.png"), 100, 100, true, true);
            } else if (kitchenType == "lightcounter") {
                image = new Image(new FileInputStream("src/Sprites/LightCounter.png"), 100, 100, true, true);
            } else if (kitchenType == "longcounter") {
                image = new Image(new FileInputStream("src/Sprites/LongCounter.png"), 100, 100, true, true);
            } else if (kitchenType == "cornercounter") {
                image = new Image(new FileInputStream("src/Sprites/CornerCounter.png"), 100, 100, true, true);
            } else if (kitchenType == "vase") {
                image = new Image(new FileInputStream("src/Sprites/vase.png"), 100, 100, true, true);
            }
        } catch (IOException e) {
        }
        ip = new ImagePattern(image);
        this.setFill(ip);
    }

    public String getKitchenType() {
        return kitchenType;
    }

    public void setKitchenType(String kitchenType) {
        this.kitchenType = kitchenType;
    }

}
