/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
