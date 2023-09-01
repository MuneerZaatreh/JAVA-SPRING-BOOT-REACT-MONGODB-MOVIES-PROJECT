package dev.muneer.movies.Services;
import dev.muneer.movies.Models.Movie;
import dev.muneer.movies.Models.Review;
import dev.muneer.movies.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MongoTemplate mongoTemplate) {
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Review createReview(String reviewBody, String id) {
        Review review = new Review();
        review.setBody(reviewBody);
        Review insertedReview = reviewRepository.insert(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().push("reviewsIds").value(insertedReview))
                .first();

        return insertedReview;
    }
    public List<Review> AllReviews(){
        return  reviewRepository.findAll();
    }
    public Optional<Review> SingleReview(String id){
        return  reviewRepository.findById(id);
    }
}
