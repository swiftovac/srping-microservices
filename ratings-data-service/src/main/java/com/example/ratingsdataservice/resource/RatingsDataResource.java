package com.example.ratingsdataservice.resource;


import com.example.ratingsdataservice.model.Rating;
import com.example.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {


    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {

        return new Rating(movieId, 4);
    }


    @RequestMapping("users/{userId}")
    public UserRating getRatings(@PathVariable("userId") String userId) {


        List<Rating> ratings = Arrays.asList(
                new Rating("tt7752126", 5),
                new Rating("tt0181182",2)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }


}
