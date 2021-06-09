package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//author @surajkushvaha

public class Main extends Application {
	private static Stage stg;
	@Override
	public void start(Stage primaryStage) throws Exception {
			stg= primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("sample0login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Suraj Kushvaha Institute");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
//from Suraj Kushvaha 
