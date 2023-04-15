package com.jkim.api_call.Services;

import com.jkim.api_call.Entity.Movie;

public interface MovieServiceInterface {
    Movie getMovieDetails(String imdbID);

}
