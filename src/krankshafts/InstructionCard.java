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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author mark.knapp
 */
public class InstructionCard extends DimentionalGroup {
    
    private static final double CARD_X_SIZE = 100;
    private static final double CARD_Y_SIZE = 100;
    
    private Instruction instruction;
    
    public InstructionCard(double xCenterLoc, double yCenterLoc, Instruction instruction) {
        super(CARD_X_SIZE, CARD_Y_SIZE);
        this.instruction = instruction;
        setCenter(xCenterLoc, yCenterLoc);
        draw();
    }
    
    /**
     * Graphically construct the object.
     */
    protected void draw() {
        
        Rectangle rect = new Rectangle(getXTopLeftLoc(), getYTopLeftLoc(), getXSize(), getYSize());
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.GREY);
        this.getChildren().add(rect);
        
        
        Label text = new Label(instruction.getText());
        text.setFont(new Font("Arial", 16));
        text.setTextFill(Color.RED);
        text.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().add(text);
        
        System.out.println(text.getWidth());
        System.out.println(text.getHeight());
        System.out.println(rect.getWidth());
        System.out.println(rect.getHeight());
        
        text.setTranslateX(getXTopLeftLoc() + (rect.getWidth() - text.getWidth())/2);
        text.setTranslateY(getYTopLeftLoc() + (rect.getHeight() - text.getHeight())/2);
                
    }
    
    /**
     * Move the card to a new X,Y (Center)
     * @param   xCenterLoc    The X coordinate of the desired location
     * @param   yCenterLoc    The Y coordinate of the desired location
     */  
    public void moveTo (double xCenterLoc, double yCenterLoc) { 
        this.setTranslateX(xCenterLoc - getXCenterLoc() + this.getTranslateX());
        this.setTranslateY(yCenterLoc - getYCenterLoc() + this.getTranslateY());
        setCenter(xCenterLoc, yCenterLoc);
    }

    /**
     * @return the direction
     */
    public Instruction getInstruction() {
        return instruction;
    }

}