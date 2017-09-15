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
abstract class Tile extends Group {
    
    protected   Direction   direction;
    protected   int         xLoc, yLox;
    protected   int         xSize, ySize;
    
    public Tile(int sXLoc, int sYLoc, int sXSize, int sYSize, Direction sDirection) {
        direction = sDirection;
        xLoc = sXLoc;
        yLox = sYLoc;
        xSize = sXSize;
        ySize = sYSize;
    }
    
    abstract void draw();
    
}
