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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author markknapp
 */
public class Krankshafts extends Application {
    
    // Some initial dimentions
    private double   screenXSize        = 1000;
    private double   screenYSize        = 800;  
    private double   boardXSize         = 600;
    private double   boardYSize         = 600;  
    private int      boardXSlots        = 12;
    private int      boardYSlots        = 12;
    private int      cardMargins        = 20;
    
    
    
    private       Stage               mainStage;    
    private       Scene               scene;    
    private       GridPane            rootGrid;
    private       Board               mainBoard;
    private       HBox                topBanner;
    private       HBox                cards;
    private       VBox                handOfCards;
    private       VBox                registerOfCards;
    
    @Override
    public void start(Stage primaryStage) {

        
        rootGrid = new GridPane();
        rootGrid.setBackground(new Background((new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))));
        
        mainBoard = new Board(boardXSize, boardYSize, boardXSlots, boardYSlots);
        rootGrid.add(mainBoard, 1, 1);
        GridPane.setHalignment(mainBoard, HPos.RIGHT);
        GridPane.setValignment(mainBoard, VPos.BOTTOM);
        
        topBanner = new HBox();
        rootGrid.add(topBanner, 1, 0);
        rootGrid.setVgrow(topBanner, Priority.ALWAYS);
        
        cards = new HBox();
        rootGrid.add(cards, 0, 0, 1, 2);
        rootGrid.setHgrow(cards, Priority.ALWAYS);
        cards.setSpacing(cardMargins);
        rootGrid.setMargin(cards, new Insets(cardMargins, cardMargins, cardMargins, cardMargins));
        
        handOfCards = new VBox();
        registerOfCards = new VBox();
        cards.getChildren().addAll(handOfCards, registerOfCards);
        handOfCards.setSpacing(cardMargins);
        registerOfCards.setSpacing(cardMargins);        
        
        Robot playerOne = mainBoard.addRobot(1, 1, Direction.EAST);
        mainBoard.instructRobot(playerOne, Instruction.FORWARD3);
//        mainBoard.instructRobot(playerOne, Instruction.LEFT);
//        mainBoard.instructRobot(playerOne, Instruction.FORWARD3);
//        mainBoard.instructRobot(playerOne, Instruction.UTURN);
        
        InstructionCard ic = new InstructionCard(200,200,Instruction.FORWARD3);
        handOfCards.getChildren().add(ic);
        InstructionCard ic2 = new InstructionCard(200,700,Instruction.BACK2);
        handOfCards.getChildren().add(ic2);
        
        InstructionCard ic3 = new InstructionCard(200,200,Instruction.FORWARD1);
        registerOfCards.getChildren().add(ic3);
        InstructionCard ic4 = new InstructionCard(200,700,Instruction.BACK1);
        registerOfCards.getChildren().add(ic4);

        
//        backgroundMusic = new AudioClip(getClass().getClassLoader().getResource(BACKGROUND_MUSIC_FILE).toString());
//        backgroundMusic.play();
        
    //    statusUpdate();
        
    
        mainStage = primaryStage;
        mainStage.setTitle("Krank Shafts");
        scene = new Scene(rootGrid, screenXSize, screenYSize, Color.BLACK);
        mainStage.setScene(scene);
        
        mainStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
