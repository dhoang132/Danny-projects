package moviefiles;

import moviefiles.Movie;

import java.util.LinkedList;
import java.util.ListIterator;

public class MovieList {
    private LinkedList<Movie> movieList;
    private int movieNumber;

    public MovieList(){

        this.movieList=new LinkedList<Movie>();
        this.movieNumber=0;
    }
    public LinkedList<Movie> getList(){
        return this.movieList;
    }


    //checks for duplicate and adds movies according to release date.
    public void addMovie(Movie movie){
        if(findMovie(movie.getName(), movie.getDirector())==null){
            ListIterator<Movie> movieListIterator = movieList.listIterator();
            if(!movieListIterator.hasNext()){
                this.movieList.add(movie);
            }else{
                for(int i=0; i<(movieList.size()); i++){
                    if(movieList.get(i).getReleaseYear()==movie.getReleaseYear()){
                        if(movieList.get(i).getReleaseMonth()<movie.getReleaseMonth()){
                            this.movieList.add(i, movie);
                            break;
                        }else {
                            this.movieList.add(i+1, movie);
                            break;
                        }
                    }
                    if(movieList.get(i).getReleaseYear()<movie.getReleaseYear()){
                        this.movieList.add(i, movie);
                        break;
                    }
                    if (i == movieList.size()-1){
                        this.movieList.add(movie);
                        break;
                    }
                }
            }

        }
    }
    //prints out each movie out list
    public String printList(){
        ListIterator<Movie> movieListIterator = this.movieList.listIterator();
        String movieList="";
        while(movieListIterator.hasNext()){
            movieList+=movieListIterator.next().toString() + "\n";
        }
        return movieList;
    }
    //checks for duplicates.
    public Movie findMovie(String name, String director){
        for(Movie checkMovie : this.movieList){
            if(checkMovie.getName() == name && checkMovie.getDirector() == director){
                return checkMovie;
            }
        }
        return null;
    }
    public String nextMovie() {
        if (this.movieNumber == this.movieList.size() - 1) {
            return this.movieList.get(this.movieNumber).toString();
        } else {
            this.movieNumber++;
            return this.movieList.get(this.movieNumber).toString();
        }
    }
    public String previousMovie(){
        if(this.movieNumber==0)
        {
            return this.movieList.get(this.movieNumber).toString();
        }else {
            this.movieNumber--;
            return this.movieList.get(this.movieNumber).toString();
        }
    }
    public String showCurrent(){
        return this.movieList.get(this.movieNumber).toString();
    }
}

