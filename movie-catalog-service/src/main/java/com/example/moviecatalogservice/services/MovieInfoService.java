package com.example.moviecatalogservice.services;


import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.Rating;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Auto
     private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

        return new CatalogItem(movie.getName(), "Hardcoded description", rating.getRating());
    }

    public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "No Desc", rating.getRating());
    }

}
