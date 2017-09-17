/*
 * Copyright (C) 2017 markknapp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package krankshafts;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author mark.knapp
 */
public class Robot extends StackPane {
    
    protected Direction direction;
    protected Dimention dimention;
    protected int xSlot;
    protected int ySlot;
    
    public Robot(double xCenterLoc, double yCenterLoc, double xSize, double ySize, int xSlot, int ySlot, Direction direction) {
        dimention = new Dimention(xSize, ySize);
        this.direction = direction;
        this.xSlot = xSlot;
        this.ySlot = ySlot;
        dimention.setCenter(xCenterLoc, yCenterLoc);
        draw();
    }
    
    /**
     * Graphically construct the object.
     */
    protected void draw() {
        
        Polygon poly = new Polygon();
        poly.getPoints().setAll(
                dimention.getXTopLeftLoc()+(dimention.getXSize()/3), dimention.getYTopLeftLoc(),
                dimention.getXTopLeftLoc()+(2*dimention.getXSize()/3), dimention.getYTopLeftLoc(),
                dimention.getXTopLeftLoc()+dimention.getXSize(), dimention.getYTopLeftLoc()+(dimention.getYSize()),
                dimention.getXTopLeftLoc(), dimention.getYTopLeftLoc()+(dimention.getYSize())
        );
        poly.setFill(Color.RED);
        poly.setStroke(Color.WHITE);
        this.getChildren().add(poly);
        
        this.setRotate(getDirection().getDegree());
        
    }
    
    /**
     * Rotate 90 degrees clockwise.
     */
    public void rotate90() {
        direction = getDirection().rotate90(this);
    }
    
    /**
     * Rotate 180 degrees clockwise.
     */
    public void rotate180() {
        direction = getDirection().rotate180(this);
    }
    
    /**
     * Rotate 270 degrees clockwise (90 deg CCW).
     */
    public void rotate270() {
        direction = getDirection().rotate270(this);
    }
    
    /**
     * Move the robot to a new X,Y (Center)
     * @param   xCenterLoc    The X coordinate of the desired location
     * @param   yCenterLoc    The Y coordinate of the desired location
     * @param   xSlot    The X slot of the desired location
     * @param   ySlot    The Y slot of the desired location
     */  
    public void moveTo (double xCenterLoc, double yCenterLoc, int xSlot, int ySlot) { 
        this.setTranslateX(xCenterLoc - dimention.getXCenterLoc() + this.getTranslateX());
        this.setTranslateY(yCenterLoc - dimention.getYCenterLoc() + this.getTranslateY());
        dimention.setCenter(xCenterLoc, yCenterLoc);
        this.xSlot = xSlot;
        this.ySlot = ySlot;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return the xSlot
     */
    public int getXSlot() {
        return xSlot;
    }

    /**
     * @return the ySlot
     */
    public int getYSlot() {
        return ySlot;
    }
    
    /**
     * Get the dimentions for this object
     * @return the dimention
     */
    public Dimention getDimention() {
        return dimention;
    }
}
