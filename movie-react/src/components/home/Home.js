import React from 'react'
import Hero from '../hero/Hero'
import MovieGrid from '../movieGrid/MovieGrid'
import './Home.css'

const Home = ({ movies }) => {
    return (
        <div className='container-fluid'>
            <Hero movies={movies} />
            <h1 className='text-center'>Explore All Movies</h1>
            <MovieGrid movies={movies} />
        </div>
    )
}

export default Home
