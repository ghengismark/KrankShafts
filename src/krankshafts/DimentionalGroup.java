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
import javafx.scene.Node;

/**
 *
 * @author mark.knapp
 */
public class DimentionalGroup extends Group {
    private   double         xCenterLoc, yCenterLoc;
    private   double         xTopLeftLoc, yTopLeftLoc;
    private   double         xSize, ySize;

    public DimentionalGroup () {
    }
    
    public DimentionalGroup (double xSize, double ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    /**
     * Sets the size.
     * @param xSize the x size
     * @param ySize the y size
     */
    public void setSize(double xSize, double ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }
    
    /**
     * Sets all coordinates based on the center.
     * @param xCenterLoc the x coordinate of the center
     * @param yCenterLoc the y coordinate of the center
     */
    public void setCenter(double xCenterLoc, double yCenterLoc) {
        this.xCenterLoc = xCenterLoc;
        this.yCenterLoc = yCenterLoc;
        xTopLeftLoc = getXCenterLoc()-getXSize()/2;
        yTopLeftLoc = getYCenterLoc()-getYSize()/2;
    }

    /**
     * Sets all coordinates based on the top left corner.
     * @param xTopLeftLoc the x coordinate of the top left
     * @param yTopLeftLoc the y coordinate of the top left
     */
    public void setTopLeft(double xTopLeftLoc, double yTopLeftLoc) {
        this.xTopLeftLoc = xTopLeftLoc;
        this.yTopLeftLoc = yTopLeftLoc;
        xCenterLoc = getXTopLeftLoc()+getXSize()/2;
        yCenterLoc = getYTopLeftLoc()+getYSize()/2;
    }
    
    /**
     * Sets all coordinates based on the center, but then also moves the object.
     * @param xCenterLoc the x coordinate of the center
     * @param yCenterLoc the y coordinate of the center
     */
    public void setCenterAndMove(double xCenterLoc, double yCenterLoc) {
        this.setTranslateX(xCenterLoc - getXCenterLoc() + this.getTranslateX());
        this.setTranslateY(yCenterLoc - getYCenterLoc() + this.getTranslateY());
        setCenter(xCenterLoc, yCenterLoc);
    }

    /**
     * @return the xCenterLoc
     */
    public double getXCenterLoc() {
        return xCenterLoc;
    }

    /**
     * @return the yCenterLoc
     */
    public double getYCenterLoc() {
        return yCenterLoc;
    }

    /**
     * @return the xTopLeftLoc
     */
    public double getXTopLeftLoc() {
        return xTopLeftLoc;
    }

    /**
     * @return the yTopLeftLoc
     */
    public double getYTopLeftLoc() {
        return yTopLeftLoc;
    }

    /**
     * @return the xSize
     */
    public double getXSize() {
        return xSize;
    }

    /**
     * @return the ySize
     */
    public double getYSize() {
        return ySize;
    }
    
    
    
    
}
