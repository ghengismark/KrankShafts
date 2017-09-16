/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krankshafts;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author mark.knapp
 */
public class Robot extends DimentionalGroup {
    
    public   Direction   direction;
    
    public Robot(double xCenterLoc, double yCenterLoc, double xSize, double ySize, Direction direction) {
        super(xSize, ySize);
        this.direction = direction;
        setCenter(xCenterLoc, yCenterLoc);
        draw();
    }
    
    /**
     * Graphically construct the object.
     */
    protected void draw() {
        
        Polygon poly = new Polygon();
        poly.getPoints().setAll(
                getXTopLeftLoc()+(getXSize()/3), getYTopLeftLoc(),
                getXTopLeftLoc()+(2*getXSize()/3), getYTopLeftLoc(),
                getXTopLeftLoc()+getXSize(), getYTopLeftLoc()+(getYSize()),
                getXTopLeftLoc(), getYTopLeftLoc()+(getYSize())
        );
        poly.setFill(Color.RED);
        poly.setStroke(Color.WHITE);
        this.getChildren().add(poly);
        
        this.setRotate(direction.getDegree());
        
    }
    
    /**
     * Rotate 90 degrees clockwise.
     */
    public void rotate90() {
        direction = direction.rotate90(this);
    }
    
    /**
     * Rotate 180 degrees clockwise.
     */
    public void rotate180() {
        direction = direction.rotate180(this);
    }
    
    /**
     * Rotate 270 degrees clockwise (90 deg CCW).
     */
    public void rotate270() {
        direction = direction.rotate270(this);
    }
}
