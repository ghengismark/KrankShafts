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

/**
 *
 * @author markknapp
 */
public class Board extends Group {

    private static final int X_TILE_SIZE = 100;
    private static final int Y_TILE_SIZE = 100;
    
    protected   int         xLoc, yLox;
    protected   int         xSlots, ySlots;
    protected   Tile[][]    tiles;
    
            
    public Board (int sXSlots, int sYSlots, int sXLoc, int sYLoc) {
        xLoc = sXLoc;
        yLox = sYLoc;
        xSlots = sXSlots;
        ySlots = sYSlots;
        tiles = new Tile[xSlots][ySlots];
        populate();
    }
    
    public void populate() {
        for (int x = 0; x < tiles.length; x++)
            for (int y = 0; y < tiles[x].length; y++)
                tiles[x][y] = new PlainTile(xLoc + x * X_TILE_SIZE, xLoc + x * Y_TILE_SIZE, X_TILE_SIZE, Y_TILE_SIZE, Direction.randomDirection());
        
    }
}
