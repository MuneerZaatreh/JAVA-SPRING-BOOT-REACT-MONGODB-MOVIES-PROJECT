package dev.muneer.movies.Repository;

import dev.muneer.movies.Models.Movie;
import dev.muneer.movies.Models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review,String> {
}
