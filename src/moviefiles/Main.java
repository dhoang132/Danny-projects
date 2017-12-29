package moviefiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import moviefiles.datamodel.MovieData;
import moviefiles.datamodel.MovieList;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainGui.fxml"));
        primaryStage.setTitle("Movies");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    //initate saving movie items to text files
    @Override
    public void stop() throws Exception {
        try{
            MovieData.getInstance().storeMovieDataItems();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    //init loading movie items to movie list
    @Override
    public void init() throws Exception {
        try{
            MovieData.getInstance().loadMovieDataItems();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
