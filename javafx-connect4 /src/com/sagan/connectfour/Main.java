package com.sagan.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller=loader.getController();
        controller.createPlayground();
        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

         Scene scene = new Scene(rootGridPane);
         primaryStage.setScene(scene);
         primaryStage.setTitle("Connect Four");
         primaryStage.setResizable(false);
         primaryStage.show();
    }
    private MenuBar createMenu(){

        Menu fileMenu = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset Game");
        newGame.setOnAction(event -> controller.resetGame());
        
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        
        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(event -> exitGame());
        
        Menu helpMenu = new Menu("Help");
        MenuItem aboutConnectFour = new MenuItem("About Connect4");
        aboutConnectFour.setOnAction(event -> aboutConnectFour());

        SeparatorMenuItem separator = new SeparatorMenuItem();

        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);
        helpMenu.getItems().addAll(aboutConnectFour,separator,aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert((Alert.AlertType.INFORMATION));
        alert.setTitle("About Developer");
        alert.setHeaderText("Vasu Harshvardhan");
        alert.setContentText("Hey I Am A Coder.");
        alert.show();
    }

    private void aboutConnectFour() {
        Alert alert = new Alert((Alert.AlertType.INFORMATION));
        alert.setTitle("About Connect4");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect4 is a two-player connection game in which the players first choose a color and then" +
                " take turns dropping one colored disc from the top into a seven-column, six-row vertically suspended grid." +
                        " The pieces fall straight down, occupying the lowest available space within the column." +
                        " The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. " +
                        "Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

