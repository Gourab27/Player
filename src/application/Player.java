package application;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane{
	
	Media media;
	MediaPlayer player;
	MediaView view;
	Pane mpane;
	MediaBar bar;

	public Player(){
		
	}
	
	public Player (String fileName){
		
		media = new Media(fileName);
		player = new MediaPlayer(media);
		view = new MediaView(player);
		mpane = new Pane();
		
		//Add the view to the pane and center pane
		mpane.getChildren().add(view);
		setCenter(mpane);
		
		//Create controller bar and set it to the bottom
		bar = new MediaBar(player);
		setBottom(bar);
		
		view.setFitHeight(520);
		view.setFitWidth(720);
		
		//DoubleProperty mvw = view.fitWidthProperty();
		//DoubleProperty mvh = view.fitHeightProperty();
		//mvw.bind(Bindings.selectDouble(view.sceneProperty(), "width"));
		//mvh.bind(Bindings.selectDouble(view.sceneProperty(), "height"));
		view.setPreserveRatio(true);
		player.play();
		
	}

}
