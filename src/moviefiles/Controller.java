package moviefiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.LinkedList;
import java.util.List;


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

    MovieList movieList = new MovieList();

    public void initialize() {
        movieList.addMovie(new Movie("Fast and Furious", "Mel City", 45, 2001, 06));
        movieList.addMovie(new Movie("Fast and Furious", "Mel City", 45, 2001, 06));
        movieList.addMovie(new Movie("Moneyball", "Bennet Miller", 47, 2011, 07));
        movieList.addMovie(new Movie("Zombieland", "Rubien", 48, 2009, 05));
        movieList.addMovie(new Movie("Blow", "Ted Demen", 68, 2001, 04));
        movieList.addMovie(new Movie("Lion King", "Rogers Allers", 68, 1994, 06));
        movieList.addMovie(new Movie("Toy Story", "Tim Allen", 78, 1995, 06));
        areaField.setText(movieList.showCurrent());
    }

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
    }
}
