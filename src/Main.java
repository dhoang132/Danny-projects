public class Main {
    public static void main (String[]args ){
        MovieList movieList = new MovieList();
        movieList.addMovie(new Movie("Fast and Furious", "Mel City", 45, 2001, 06));
        movieList.addMovie(new Movie("Fast and Furious", "Mel City", 45, 2001, 06));
        movieList.addMovie(new Movie("Moneyball", "Bennet Miller", 47, 2011, 07));
        movieList.addMovie(new Movie("Zombieland", "Rubien", 48, 2009, 05));
        movieList.addMovie(new Movie("Blow", "Ted Demen", 68, 2001, 04));
        movieList.printList();
    }
}
