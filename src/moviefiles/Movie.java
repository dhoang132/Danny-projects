package moviefiles;

public class Movie {
        private int movieId;
        private int releaseYear;
        private int releaseMonth;
        private String director;
        private String name;

        public Movie(String name, String director, int movieId, int releaseYear, int releaseMonth){
            this.name=name;
            this.director=director;
            this.movieId=movieId;
            this.releaseYear=releaseYear;
            this.releaseMonth=releaseMonth;
        }

        public int getMovieId() {
            return movieId;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public int getReleaseMonth() {
            return releaseMonth;
        }

        public String getDirector() {
            return director;
        }

        public String getName() {
            return name;
        }
        @Override
        public String toString(){
            return (this.name + " directed by " + this.director + " released:" + this.getReleaseMonth()+ "/" + this.getReleaseYear());
        }
    }

