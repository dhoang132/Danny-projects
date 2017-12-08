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
        movieList.addMovie(new Movie("Fast and Furious", "Mel City", 45, 2001, 06,
                "Los Angeles police officer Brian O'Connor must decide where his loyalty really lies when " +
                        "he becomes enamored with the street racing world he has been sent undercover to destroy."));
        movieList.addMovie(new Movie("Fast and Furious", "Mel City", 45, 2001, 06, "\n" +
                "Los Angeles police officer Brian O'Connor must decide where his loyalty really lies when " +
                "he becomes enamored with the street racing world he has been sent undercover to destroy."));
        movieList.addMovie(new Movie("Moneyball", "Bennet Miller", 47, 2011, 07,
                "Oakland A's general manager Billy Beane's successful attempt to assemble a baseball team on a lean " +
                        "budget by employing computer-generated analysis to acquire new players."));
        movieList.addMovie(new Movie("Zombieland", "Rubien", 48, 2009, 05,
                "A shy student trying to reach his family in Ohio, a gun-toting tough guy trying to find " +
                        "the last Twinkie, and a pair of sisters trying to get to an amusement park join forces to " +
                        "travel across a zombie-filled America."));
        movieList.addMovie(new Movie("Blow", "Ted Demen", 68, 2001, 04,
                "The story of George Jung, along with the Medellín Cartel, headed by Pablo " +
                        "Escobar established the American cocaine market in the 1970s in the United States."));
        movieList.addMovie(new Movie("Lion King", "Rogers Allers", 69, 1994, 06,
                "Lion cub and future king Simba searches for his identity. His eagerness to please " +
                        "others and penchant for testing his boundaries sometimes gets him into trouble."));
        movieList.addMovie(new Movie("Toy Story", "Tim Allen", 78, 1995, 06,
                "A cowboy doll is profoundly threatened and jealous when a new spaceman figure " +
                        "supplants him as top toy in a boy's room."));
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
