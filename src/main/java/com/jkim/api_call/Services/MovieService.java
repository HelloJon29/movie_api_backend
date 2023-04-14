package com.jkim.api_call.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jkim.api_call.Entity.Movie;
import com.jkim.api_call.ProjectConstants.Constants;

@Service
public class MovieService {
    private static final String API_URL = "http://www.omdbapi.com/";
    private String apiKey;
    private RestTemplate restTemplate;

    public MovieService() {
        this.restTemplate = new RestTemplate();
        this.apiKey = Constants.OMDB_API_KEY;
    }

    public Movie getMovieDetails(String imdbID) {
        String url = API_URL + "?apikey=" + apiKey + "&i=" + imdbID;
        Movie movie = restTemplate.getForObject(url, Movie.class);

        return movie;
    }
}
