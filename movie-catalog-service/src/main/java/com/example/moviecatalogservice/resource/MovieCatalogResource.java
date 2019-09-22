package com.example.moviecatalogservice.resource;


import com.example.moviecatalogservice.model.CatalogItem;

import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.UserRating;
import com.example.moviecatalogservice.services.MovieInfoService;
import com.example.moviecatalogservice.services.UserRatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MovieInfoService movieInfoService;

    @Autowired
    UserRatingService userRatingService;


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        UserRating ratings = userRatingService.getUserRating(userId);

        return ratings.getUserRating().stream().map(rating -> {
            // get movie info for each movie user rated (get it by movieid from ratings data)
            return movieInfoService.getCatalogItem(rating);
        }).collect(Collectors.toList());

    }





}
