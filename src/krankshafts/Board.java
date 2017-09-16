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

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

/**
 *
 * @author markknapp
 */
public class Board extends DimentionalGroup {
    
    protected   int         xSlots, ySlots;
    protected   double      xTileSize, yTileSize;
    protected   double      xRobotSize, yRobotSize;
    protected   Shape       background;
    
    protected   Tile[][]    tileArr;
    protected   Group       tileGroup = new Group(); 
    
    protected   ArrayList<Robot>    robotArr = new ArrayList<>();
    protected   Group       robotGroup = new Group(); 
    
    protected       Random              diceRoller              = new Random();
            
    public Board (double xTopLeftLoc, double yTopLeftLoc, double xSize, double ySize, int xSlots, int ySlots) {
        super(xSize, ySize);
        setTopLeft(xTopLeftLoc, yTopLeftLoc);
        this.xSlots = xSlots;
        this.ySlots = ySlots;
        xTileSize = xSize / xSlots;
        yTileSize = ySize / ySlots;
        xRobotSize = xTileSize*0.8;
        yRobotSize = yTileSize*0.8;
        tileArr = new Tile[xSlots][ySlots];
        draw();
        populate();
    }
    
    /**
     * Graphically construct the object.
     */
    protected void draw() {
        background = new Rectangle(getXTopLeftLoc(), getYTopLeftLoc(), getXSize(), getYSize());
        background.setFill(Color.GREY);
        background.setStroke(Color.WHITE);
        this.getChildren().add(background);
        this.getChildren().add(tileGroup);
        this.getChildren().add(robotGroup);
    }
    
    /**
     * Fill the board with random tiles
     */
    public void populate() {
        Tile temp;
        for (int x = 0; x < tileArr.length; x++)
            for (int y = 0; y < tileArr[x].length; y++) {
                if (getTile(x,y) != null)
                    killTile(x,y);
                if (diceRoller.nextBoolean())
                    temp = new PlainTile(getXTopLeftLoc() + x * xTileSize, getYTopLeftLoc() + y * yTileSize, xTileSize, yTileSize, Direction.randomDirection());
                else
                    temp = new SlowConveyorTile(getXTopLeftLoc() + x * xTileSize, getYTopLeftLoc() + y * yTileSize, xTileSize, yTileSize, Direction.randomDirection());
                setTile(temp, x, y);
            }
        
    }
    
    /**
     * Places a specific tile on a specific slot of the board.
     * @param newtile the tile to stick in the slot
     * @param xIndex the x slot on the board to add it to
     * @param yIndex the y slot on the board to add it to
     */  
    public void setTile (Tile newTile, int xIndex, int yIndex) {
        if (tileArr[xIndex][yIndex] != null)
            killTile(xIndex, yIndex);
        tileArr[xIndex][yIndex] = newTile;
        tileGroup.getChildren().add(newTile);
    }
    
    /**
     * Returns the Tile on a specific spot on the board.
     * @param xIndex the x slot on the board where the tile is
     * @param yIndex the y slot on the board where the tile is
     * @return the tile
     */  
    public Tile getTile (int xIndex, int yIndex) {
        return tileArr[xIndex][yIndex];
    }
    
    /**
     * Destroys the tile on a specific spot on the board
     * @param xIndex the x slot on the board where the tile is
     * @param yIndex the y slot on the board where the tile is
     */  
    public void killTile (int xIndex, int yIndex) {
        tileGroup.getChildren().remove(tileArr[xIndex][yIndex]);
        tileArr[xIndex][yIndex] = null;
    }
    
    /**
     * Creates a new robot and places it on the board.
     * @param xIndex the x slot on the board to add it to
     * @param yIndex the y slot on the board to add it to
     * @param direction the starting direction of the robot
     * @return the robot
     */  
    public Robot addRobot (int xIndex, int yIndex, Direction direction) {
        Robot temp = new Robot(tileArr[xIndex][yIndex].getXCenterLoc(), tileArr[xIndex][yIndex].getYCenterLoc(), xRobotSize, yRobotSize, direction);
        robotGroup.getChildren().add(temp);
        robotArr.add(temp);
        return temp;
    }
}
