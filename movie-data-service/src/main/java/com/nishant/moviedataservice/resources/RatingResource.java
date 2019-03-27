package com.nishant.moviedataservice.resources;

import com.nishant.moviedataservice.resources.models.Rating;
import com.nishant.moviedataservice.resources.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);

    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List <Rating> ratings = Arrays.asList(
                new Rating("1", 4),
                new Rating("5", 5)
        );

        UserRating userRatings = new UserRating();
        userRatings.setUserRating(ratings);
        return userRatings;
    }
}
