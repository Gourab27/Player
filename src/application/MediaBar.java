package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

public class MediaBar extends HBox{
	
	Slider vol;
	Slider time;
	
	Button playButton = new Button("||");
	
	Label volume = new Label("Volume: ");
	
	MediaPlayer player;
	
	public MediaBar(MediaPlayer player){
		this.player = player;
		
		setAlignment(Pos.CENTER);
		setPadding(new Insets(10, 5, 10, 5));
		
		vol.setPrefWidth(70);
		vol.setMinWidth(40);
		
		HBox.setHgrow(time, Priority.ALWAYS);
		
		playButton.setPrefWidth(30);
		
		getChildren().add(vol);
		getChildren().add(time);
		getChildren().add(playButton);
		getChildren().add(volume);
	}

}
