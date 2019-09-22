package com.example.movieinfoservice.resource;


import com.example.movieinfoservice.model.Movie;
import com.example.movieinfoservice.model.MovieSummary;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.http.RestTemplateTransportClientFactories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {


    @Autowired
    RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;



    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        MovieSummary movieSummary = restTemplate.getForObject("http://www.omdbapi.com/?apikey=" + apiKey +"&i=" + movieId, MovieSummary.class);


           return new Movie(movieId, movieSummary.getTitle(), movieSummary.getPlot());

    }



}
