package com.jkim.api_call;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jkim.api_call.Entity.Movie;
import com.jkim.api_call.Services.MovieService;

@SpringBootApplication
public class ApiCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCallApplication.class, args);
		System.out.println("Hello World");

		MovieService movieService = new MovieService();

		Movie movie = movieService.getMovieDetails("tt0347149");

		System.out.println(movie);
	}

}
