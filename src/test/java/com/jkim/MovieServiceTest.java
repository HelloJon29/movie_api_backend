package com.jkim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.web.client.RestTemplate;

import com.jkim.api_call.Entity.Movie;
import com.jkim.api_call.ProjectConstants.Constants;
import com.jkim.api_call.Services.MovieService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private RestTemplate restTemplate;

    private final String API_URL = "http://www.omdbapi.com/";
    private String apiKey;

    @BeforeEach
    public void setUp() {
        this.apiKey = Constants.OMDB_API_KEY;
    }

    @Test
    public void testGetMovieDetails() {
        // Given
        String imdbID = "tt1234567";
        Movie expectedMovie = new Movie();
        expectedMovie.setTitle("The Top 14 Perform");
        expectedMovie.setYear("2008");

        String url = API_URL + "?i=" + imdbID + "@apikey=" + apiKey;

        // When
        when(restTemplate.getForObject(url, Movie.class)).thenReturn(expectedMovie);

        // Then
        Movie actualMovie = movieService.getMovieDetails(imdbID);

        // Assert
        assertEquals(expectedMovie.getTitle(), actualMovie.getTitle());
        assertEquals(expectedMovie.getYear(), actualMovie.getYear());

    }
}
