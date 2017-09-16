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

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author markknapp
 */
public class Krankshafts extends Application {
    
    // Some initial dimentions
    public double   screenXSize        = 1000;
    public double   screenYSize        = 800;  
    public double   boardXSize         = 600;
    public double   boardYSize         = 600;  
    public int      boardXSlots        = 12;
    public int      boardYSlots        = 12;  
    
    protected       Stage               mainStage;    
    protected       Scene               scene;    
    protected       Group               root;
    protected       Board       mainBoard;
    
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        mainStage.setTitle("Asteroids FX");
        
        root = new Group();
        scene = new Scene(root, screenXSize, screenYSize, Color.BLACK);
        mainStage.setScene(scene);
        
        mainBoard = new Board(screenXSize-boardXSize-1, screenYSize-boardYSize-1, boardXSize, boardYSize, boardXSlots, boardYSlots);
        root.getChildren().add(mainBoard);
        
        Robot playerOne = mainBoard.addRobot(4, 4, Direction.NORTH);
        Robot playerTwo = mainBoard.addRobot(5, 5, Direction.EAST);
        Robot playerThree = mainBoard.addRobot(6, 6, Direction.SOUTH);
        Robot playerFour = mainBoard.addRobot(7, 7, Direction.WEST);
        
//        backgroundMusic = new AudioClip(getClass().getClassLoader().getResource(BACKGROUND_MUSIC_FILE).toString());
//        backgroundMusic.play();
        
    //    statusUpdate();
        
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
