package com.nishant.moviecatalogueservice.resources;

import com.nishant.moviecatalogueservice.model.CatalogueItem;
import com.nishant.moviecatalogueservice.model.Movie;
import com.nishant.moviecatalogueservice.model.Rating;
import com.nishant.moviecatalogueservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogueItem> getCatalogue(@PathVariable("userId") String userId){

    UserRating ratings = restTemplate.getForObject("http://movie-data-service/ratingdata/users/" + userId , UserRating.class);

    return ratings.getUserRating().stream().map(rating -> {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

//         Movie movie = webClientBuilder.build()
//                .get()
//                .uri("http://localhost:8081/movies/" + rating.getMovieId())
//                .retrieve()
//                .bodyToMono(Movie.class)
//                .block();
        return new CatalogueItem(movie.getName(), "test",rating.getRating());
    }) .collect(Collectors.toList());
//        return Collections.singletonList(
//                new CatalogueItem("Transformers", "Test", 4)xx`
//        );
    }
}
