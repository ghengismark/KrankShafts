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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author markknapp
 */
public class SlowConveyorTile extends Tile {
    
    protected Rectangle background;
    protected Polygon   arrow;
    
    
    public SlowConveyorTile(double sXLoc, double sYLoc, double sXSize, double sYSize, Direction sDirection) {
        super(sXLoc, sYLoc, sXSize, sYSize, sDirection);
        draw();
    }

    @Override
    protected void draw() {
        background = new Rectangle(xLoc, yLoc, xSize, ySize);
        background.setFill(Color.GREEN);
        background.setStroke(Color.WHITE);
        this.getChildren().add(background);
        
        arrow = new Polygon();
        arrow.getPoints().setAll(
                xLoc+(xSize/2), yLoc,
                xLoc, yLoc+(ySize/2),
                xLoc+xSize, yLoc+(ySize/2)
        );
        arrow.setFill(Color.LIGHTGREEN);
        arrow.setStroke(Color.WHITE);
        this.getChildren().add(arrow);
        
        this.setRotate(direction.getDegree());
        
    }

}
