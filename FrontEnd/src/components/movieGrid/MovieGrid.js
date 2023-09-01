import React from 'react';
import './MovieGrid.css'; // Import the CSS file for styling

const MovieGrid = ({ movies }) => {
    return (
        <div className="row justify-content-center">

            {movies.map((movie, index) => (
                <div className='col-2 movies_cards'>
                    <div className="movie-card" key={index}>
                        <img className='image_poster' src={movie.poster} alt={movie.title} />
                        <hr></hr>
                        <h3>{movie.title}</h3>
                    </div>
                </div>

            ))}
        </div>
    );
};

export default MovieGrid;