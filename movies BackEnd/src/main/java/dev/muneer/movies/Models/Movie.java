package dev.muneer.movies.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("movies")
public class Movie {
    @Id
    private String id;
    private String title;
    private String date;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private  List<String> backdrops;
    @DocumentReference
    private List<Review> reviewsIds;

}
