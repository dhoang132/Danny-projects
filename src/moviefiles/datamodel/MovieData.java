package moviefiles.datamodel;



import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class MovieData {
    private static MovieData instance = new MovieData();
    private static String filename = "MovieListItems.txt";
    private List<Movie> movieListItems;
    //static, allows user to access from any class
    public static MovieData getInstance() {
        return instance;
    }

    public List<Movie> getMovieListItems() {
        return movieListItems;
    }
    //adds movie items to movielist
    public void loadMovieDataItems() throws IOException{
        movieListItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try{
            while((input = br.readLine())!=null){
                String[] itemPieces = input.split("\t");

                String movieTitle = itemPieces[0];
                String movieDirector = itemPieces[1];
                String movieId = itemPieces[2];
                String releaseMonth = itemPieces[3];
                String releaseYear = itemPieces[4];
                String movieSummary = itemPieces[5];
                Movie movie = new Movie(movieTitle, movieDirector, (Integer.parseInt(movieId)),
                        Integer.parseInt(releaseYear), Integer.parseInt(releaseMonth),
                        movieSummary);
                movieListItems.add(movie);
            }
        } finally {
            if(br!=null){
                br.close();
            }
        }
    }
    //saves movie items from movie list to text file
    public void storeMovieDataItems() throws IOException {

        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<Movie> iter = movieListItems.iterator();
            while(iter.hasNext()){
                Movie item = iter.next();
                bw.write(String.format("%s\t%s\t%s\t%s\t%s\t%s",
                        item.getName(), item.getDirector(), item.getMovieId(), item.getReleaseMonth(),
                        item.getReleaseYear(), item.getSummary()));
                bw.newLine();
            }
        } finally{
            if(bw!=null){
                bw.close();
            }
        }
    }
}