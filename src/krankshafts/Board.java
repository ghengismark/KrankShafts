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

import java.util.Random;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

/**
 *
 * @author markknapp
 */
public class Board extends Group {
    
    protected   double      xLoc, yLoc;
    protected   int         xSlots, ySlots;
    protected   double      xSize, ySize;
    protected   double      xTileSize, yTileSize;
    protected   Shape       background;
    protected   Tile[][]    tileArr;
    protected   Group       tileGroup = new Group();    
    protected       Random              diceRoller              = new Random();
            
    public Board (double sXLoc, double sYLoc, double sXSize, double sYSize, int sXSlots, int sYSlots) {
        xLoc = sXLoc;
        yLoc = sYLoc;
        xSlots = sXSlots;
        ySlots = sYSlots;
        xSize = sXSize;
        ySize = sYSize;
        xTileSize = xSize / xSlots;
        yTileSize = ySize / ySlots;
        tileArr = new Tile[xSlots][ySlots];
        draw();
        populate();
    }
    
    protected void draw() {
        background = new Rectangle(xLoc, yLoc, xSize, ySize);
        background.setFill(Color.GREY);
        background.setStroke(Color.WHITE);
        this.getChildren().add(background);
        this.getChildren().add(tileGroup);
    }
    
    public void populate() {
        Tile temp;
        for (int x = 0; x < tileArr.length; x++)
            for (int y = 0; y < tileArr[x].length; y++) {
                if (getTile(x,y) != null)
                    killTile(x,y);
                if (diceRoller.nextBoolean())
                    temp = new PlainTile(xLoc + x * xTileSize, yLoc + y * yTileSize, xTileSize, yTileSize, Direction.randomDirection());
                else
                    temp = new SlowConveyorTile(xLoc + x * xTileSize, yLoc + y * yTileSize, xTileSize, yTileSize, Direction.randomDirection());
                setTile(temp, x, y);
            }
        
    }
    
    public void setTile (Tile newTile, int xIndex, int yIndex) {
        tileArr[xIndex][yIndex] = newTile;
        tileGroup.getChildren().add(newTile);
    }
    
    public Tile getTile (int xIndex, int yIndex) {
        return tileArr[xIndex][yIndex];
    }
    
    public void killTile (int xIndex, int yIndex) {
        tileGroup.getChildren().remove(tileArr[xIndex][yIndex]);
        tileArr[xIndex][yIndex] = null;
    }
}
