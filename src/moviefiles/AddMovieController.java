package moviefiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.util.Optional;

public class AddMovieController {
    @FXML
    private BorderPane addMoviePane;
    @FXML
    private TextField movieNameField;
    @FXML
    private TextField directorField;
    @FXML
    private TextField movieIdField;
    @FXML
    private TextField releaseMonthField;
    @FXML
    private TextField releaseYearField;
    @FXML
    private TextArea movieSummaryField;

    public Movie processData(){
       Movie movie = new Movie(movieNameField.getText().toString(), directorField.getText().toString(), Integer.parseInt(movieIdField.getText().toString()),
               Integer.parseInt(releaseYearField.getText().toString()), Integer.parseInt(releaseMonthField.getText().toString()), movieSummaryField.getText().toString());
       return movie;

    }
}
