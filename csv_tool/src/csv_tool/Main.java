package csv_tool;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Logfile Viewer");

        try
        {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/LogfileTable.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}