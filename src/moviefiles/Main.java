package moviefiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
}



//package moviefiles;
//
//public class Main {
//    public static void main (String[]args ){
//        MovieList movieList = new MovieList();
//        movieList.addMovie(new Movie("Fast and Furious", "Mel City", 45, 2001, 06));
//        movieList.addMovie(new Movie("Fast and Furious", "Mel City", 45, 2001, 06));
//        movieList.addMovie(new Movie("Moneyball", "Bennet Miller", 47, 2011, 07));
//        movieList.addMovie(new Movie("Zombieland", "Rubien", 48, 2009, 05));
//        movieList.addMovie(new Movie("Blow", "Ted Demen", 68, 2001, 04));
//        movieList.printList();
//    }
//}
