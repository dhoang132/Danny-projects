package moviefiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import moviefiles.datamodel.Movie;
import moviefiles.datamodel.MovieData;
import moviefiles.datamodel.MovieList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


public class Controller {
    @FXML
    private TextArea areaField;
    @FXML
    private Button buttonNext;
    @FXML
    private Button buttonPrevious;
    @FXML
    private Button buttonShowList;
    @FXML
    private Button buttonCurrent;
    @FXML
    private Button addMovie;
    @FXML
    private BorderPane mainBorderPane;

    MovieList movieList = new MovieList();

    public void initialize() {
        //gets movie items from list created by "MovieListItems.txt" then adds it to movieList
        ArrayList<Movie>tempMovieList = new ArrayList<>();
        tempMovieList.addAll(MovieData.getInstance().getMovieListItems());
        for(int i = 0; i<tempMovieList.size(); i++){
            movieList.addMovie(tempMovieList.get(i));
        }
        areaField.setText(movieList.showCurrent());
    }
    //create new window to so user can input new movie
    @FXML
    public void showAddMovie(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addMovieDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
            dialog.resizableProperty();
            dialog.setTitle("Add Movie");
            dialog.setWidth(550);
            dialog.setHeight(340);
        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        //adds default OK and Cancel button to the add movie window
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            System.out.println("ok button clicked");
            AddMovieController controller = fxmlLoader.getController();
            movieList.addMovie(controller.processData());
        }
    }
    //determinds which button is press on the main window
    @FXML
    public void onButtonClicked(ActionEvent e){
        if(e.getSource().equals(buttonNext)) {
            areaField.setText(movieList.nextMovie());
        }
        if(e.getSource().equals(buttonPrevious)){
            areaField.setText(movieList.previousMovie());
        }
        if(e.getSource().equals(buttonShowList)){
            areaField.setText(movieList.printList());
        }
        if(e.getSource().equals(buttonCurrent)){
            areaField.setText(movieList.showCurrent());
        }
        if(e.getSource().equals(addMovie)) {
            System.out.println("add button clicked");
            showAddMovie();
        }
    }
}
