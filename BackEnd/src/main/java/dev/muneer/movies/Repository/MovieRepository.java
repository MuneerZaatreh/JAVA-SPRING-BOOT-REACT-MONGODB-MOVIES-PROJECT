package dev.muneer.movies.Repository;

import dev.muneer.movies.Models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {
}
