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
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

/**
 *
 * @author markknapp
 */
public class Board extends GridPane {
    
    protected   int         xSlots, ySlots;
    protected   double      xTileSize, yTileSize;
    protected   double      xRobotSize, yRobotSize;
    protected   Shape       background;
    protected   Dimention   dimention;
    
    protected   Tile[][]    tileArr;
    protected   Group       tileGroup = new Group(); 
    
    protected   ArrayList<Robot>    robotArr = new ArrayList<>();
    protected   Group       robotGroup = new Group(); 
    
    protected       Random              diceRoller              = new Random();
            
    public Board (double xTopLeftLoc, double yTopLeftLoc, double xSize, double ySize, int xSlots, int ySlots) {
        dimention = new Dimention(xSize, ySize);
        dimention.setTopLeft(xTopLeftLoc, yTopLeftLoc);
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
        background = new Rectangle(dimention.getXTopLeftLoc(), dimention.getYTopLeftLoc(), dimention.getXSize(), dimention.getYSize());
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
                    temp = new PlainTile(dimention.getXTopLeftLoc() + x * xTileSize, dimention.getYTopLeftLoc() + y * yTileSize, xTileSize, yTileSize, Direction.randomDirection());
                else
                    temp = new SlowConveyorTile(dimention.getXTopLeftLoc() + x * xTileSize, dimention.getYTopLeftLoc() + y * yTileSize, xTileSize, yTileSize, Direction.randomDirection());
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
        Robot temp = new Robot(tileArr[xIndex][yIndex].getDimention().getXCenterLoc(), tileArr[xIndex][yIndex].getDimention().getYCenterLoc(), xRobotSize, yRobotSize, xIndex, yIndex, direction);
        robotGroup.getChildren().add(temp);
        robotArr.add(temp);
        return temp;
    }
    
    /**
     * Moves a specific robot a number of spaces forward or back.
     * @param robot the robot to move
     * @param move slots/tiles (NOT PIXELS) to move. Can be negative for backwards.
     */  
    public void moveRobot (Robot robot, int move) {
        int potentialXSlot = robot.getXSlot();
        int potentialYSlot = robot.getYSlot();
        int directionModifer = 1;
        
        if (move < 0) {
            directionModifer = -1;
            move = -move;
        }  
        
        for (int x = 0; x < move; x++) {
            potentialXSlot += directionModifer * robot.direction.getDx();
            potentialYSlot += directionModifer * robot.direction.getDy();
            
            // Can't move off the board
            if ((potentialXSlot < 0) || (potentialYSlot < 0) || (potentialXSlot >= xTileSize) || (potentialYSlot >= yTileSize))
                break;
                    
            // Can't move through a wall
            // TODO - check for walls between current slot and potential slot
                    
            // Looks good. Go ahead and move.
            robot.moveTo(tileArr[potentialXSlot][potentialYSlot].getDimention().getXCenterLoc(), tileArr[potentialXSlot][potentialYSlot].getDimention().getYCenterLoc(), potentialXSlot, potentialYSlot);
        }
    }
    
    /**
     * Rotates a robot on the board.
     * @param robot the robot to move
     * @param rotate 0 = nothing, 1 = 90 CW, 2 = 180 CW, 3 = 270 CW. Negative is CCW
     */  
    public void rotateRobot (Robot robot, int rotate) {
        rotate %= 4;
        switch (rotate) {
            case 1:
            case -3:
                robot.rotate90();
                break;
            case 2:
            case -2:
                robot.rotate180();
                break;
            case 3:
            case -1:
                robot.rotate270();
        }
    }

    /**
     * Gives robot instructions.
     * @param robot the robot to move
     * @param instruction in format "XYYY". X = m (move) or r (rotate). YYY is a positive or negative int.
     */  
    public void instructRobot (Robot robot, Instruction instruction) {
                
        if (instruction.getMove() != 0)
            moveRobot(robot, instruction.getMove());
        
        if (instruction.getRotate() != 0)
            rotateRobot(robot, instruction.getRotate());
    }    
    
    /**
     * Get the dimentions for this object
     * @return the dimention
     */
    public Dimention detDimention() {
        return dimention;
    }
}
