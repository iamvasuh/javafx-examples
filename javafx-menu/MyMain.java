package com.iamvasuh.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application {

	public static void main(String[] args) {
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init"); // Initialize your application
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("start");    // Starts an application

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().addAll(menuBar);

		Scene scene = new Scene(rootNode, 300, 275);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello JavaFX");
		primaryStage.show();
	}

	private MenuBar createMenu() {

		// File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> {
			System.out.println("New Menu Item Clicked");
			// More code....
		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		// Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		// Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp() {
		// TODO
	}

	@Override
	public void stop() throws Exception {

		System.out.println("stop"); // Called when application is stopped and is about to shut down
		super.stop();
	}
}
