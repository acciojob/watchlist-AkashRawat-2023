package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
 //   HashMap<String,String> movieDirectorPair = new HashMap<>();
    HashMap<String,List<String>> movieDirectorPair = new HashMap<>();//director -- List of movies

    public String addMovie(Movie movie){

        String key = movie.getName();
        movieDb.put(key,movie);
        return "Movie added Successfully";

    }
    public String addDirector(Director director){

        String key = director.getName();
        directorDb.put(key,director);
        return "Director added Successfully";

    }
    public  String addMovieDirectorPair(String movieName,String directorName){

//        movieDirectorPair.put(movieName,directorName);
        List<String> list = movieDirectorPair.get(directorName);
        if(list == null){
            list = new ArrayList<String>();
        }

        list.add(movieName);

        return "director- movie pair added duccessfully";
    }
    public Movie getMovieByName(String movieName){
        return movieDb.get(movieName);
    }
    public Director getDirectorByName(String directorName){
        return directorDb.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
//        List<String> ans  = new ArrayList<>();
        return movieDirectorPair.get(directorName);
//        for(Map.Entry<String,String> entry : movieDirectorPair.entrySet()){
//            if(entry.getValue().equals(directorName)){
//                ans.add(entry.getKey());
//            }
//        }
//        return ans;
    }
    public List<String> findAllMovies(){
        List<String> ans  = new ArrayList<>();
        for(String movieNmae : movieDb.keySet()){
            ans.add(movieNmae);
        }
        return ans;
    }
    public String deleteDirectorByName(String directorName){
        for(String movie: movieDirectorPair.get(directorName)){
            movieDb.remove(movie);
        }
        directorDb.remove(directorName);
//        directorDb.remove(directorName);
//
//        for(Map.Entry<String,String> entry : movieDirectorPair.entrySet()){
//            if(entry.getValue().equals(directorName)){
//                String movieName = entry.getKey();
//                movieDb.remove(movieName);
//                movieDirectorPair.remove(movieName);
//            }
//        }
        return "Director removed successfully";
    }

    public String deleteAllDirectors() {

        for(String director:directorDb.keySet()) {
            for(String movie: movieDirectorPair.get(director)){
                movieDb.remove(movie);
            }
            directorDb.remove(director);
        }
//        for (String director : directorDb.keySet()) {
//
//            for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
//                if (entry.getValue().equals(director)) {
//                    String movieName = entry.getKey();
//                    movieDb.remove(movieName);
//                    movieDirectorPair.remove(movieName);
//                }
//            }
//            directorDb.remove(director);
//        }
        return "All directors deleted";
    }

}
