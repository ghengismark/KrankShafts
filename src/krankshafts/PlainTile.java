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

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author markknapp
 */
public class PlainTile extends Tile {
    
    protected Shape background;
    
    
    public PlainTile(double xTopLeftLoc, double yTopLeftLoc, double xSize, double ySize, int xSlot, int ySlot, Direction direction) {
        super(xTopLeftLoc, yTopLeftLoc, xSize, ySize, xSlot, ySlot, direction);
        draw();
    }

    /**
     * Graphically construct the object.
     */
    @Override
    protected void draw() {
        background = new Rectangle(getDimention().getXTopLeftLoc(), getDimention().getYTopLeftLoc(), getDimention().getXSize(), getDimention().getYSize());
        background.setFill(Color.BLUE);
        background.setStroke(Color.WHITE);
        this.getChildren().add(background);
    }

}
