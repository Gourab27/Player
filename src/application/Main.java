package application;
	
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

public class Main extends Application {
	
	Player player;
	FileChooser fileChooser;
	MenuBar menuBar;
	
	@Override
	public void start(Stage primaryStage) {
		
		//Add menu bar to open file
		MenuItem open = new MenuItem("Open");
		Menu menuFile = new Menu("File");
		menuBar = new MenuBar();
		
		menuFile.getItems().add(open);
		menuBar.getMenus().add(menuFile);
		
		fileChooser = new FileChooser();
		
		open.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				File file = fileChooser.showOpenDialog(primaryStage);
				if (file != null){
					try {
						System.out.println(file.toURI().toURL().toExternalForm());
						player = new Player(file.toURI().toURL().toExternalForm());
						Scene scene = new Scene(player, 720, 520, Color.BLACK);
						primaryStage.setScene(scene);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		//System.out.println(System.getProperty("user.dir"));
		player = new Player();
		player.setTop(menuBar);					 //Set bar at the top
		Scene scene = new Scene(player, 720, 530, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
