package com.jkim.api_call.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jkim.api_call.Entity.Movie;
import com.jkim.api_call.ProjectConstants.Constants;

@Service
public class MovieService implements MovieServiceInterface {
    private static final String API_URL = "http://www.omdbapi.com/";
    private String apiKey;

    public MovieService() {
        this.apiKey = Constants.OMDB_API_KEY;
    }

    @Override
    public Movie getMovieDetails(String imdbID) {
        String url = API_URL + "?i=" + imdbID + "&apikey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        Movie movie = restTemplate.getForObject(url, Movie.class);

        return movie;
    }

    public static String getApiUrl() {
        return API_URL;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
