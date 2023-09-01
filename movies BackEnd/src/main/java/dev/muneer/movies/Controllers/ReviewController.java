package dev.muneer.movies.Controllers;

import dev.muneer.movies.Models.Movie;
import dev.muneer.movies.Models.Review;
import dev.muneer.movies.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
    @Autowired
    private  ReviewService reviewService;
   @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("id")), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return  new ResponseEntity<List<Review>>(reviewService.AllReviews(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getSingleReview(@PathVariable String id){
       return  new ResponseEntity<Optional<Review>>(reviewService.SingleReview(id),HttpStatus.OK);
    }

}
