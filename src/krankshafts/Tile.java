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

/**
 *
 * @author markknapp
 */
abstract class Tile extends StackPane {
    
    protected   Direction   direction;
    protected   Dimention   dimention;
    
    public Tile(double xTopLeftLoc, double yTopLeftLoc, double xSize, double ySize, Direction sDirection) {
        direction = sDirection;
        dimention = new Dimention(xSize, ySize);
        dimention.setTopLeft(xTopLeftLoc, yTopLeftLoc);
    }
    
    /**
     * Graphically construct the object.
     */
    abstract void draw();
    
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
    
    /**
     * Get the dimentions for this object
     * @return the dimention
     */
    public Dimention getDimention() {
        return dimention;
    }
    
}
