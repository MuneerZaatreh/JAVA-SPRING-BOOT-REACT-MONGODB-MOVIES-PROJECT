package dev.muneer.movies.Services;

import dev.muneer.movies.Models.Movie;
import dev.muneer.movies.Repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }
    public Optional<Movie> getSingleMovie(ObjectId id) {
        return repository.findById(String.valueOf(id));
    }


}
