package moviefiles.datamodel;

import java.util.HashMap;
import java.util.Map;

public class MovieSummary {
    private Map<Integer, String> movieSummary;

    public MovieSummary(){
        this.movieSummary=new HashMap<>();
    }
    //adds key and summary to movie map.
    public void addSummary(Integer id, String summary){
        this.movieSummary.put(id, summary);
    }
    //get summary with key
    public String getSumary(Integer id){
        return movieSummary.get(id);
    }


}
