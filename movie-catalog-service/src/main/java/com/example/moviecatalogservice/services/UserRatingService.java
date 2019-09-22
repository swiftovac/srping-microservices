package com.example.moviecatalogservice.services;

import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.UserRating;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Service
public class UserRatingService {


    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
    }




    public UserRating getFallbackUserRating(@PathVariable("userId")String userID){
        UserRating userRating = new UserRating();
        userRating.setUserRating(Arrays.asList(
                new Rating("0",0)
        ));

        return userRating;
    }
}
