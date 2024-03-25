package com.lavsindustries.movieapi.service

import com.lavsindustries.movieapi.dtos.MovieDTO
import com.lavsindustries.movieapi.repository.MovieRepositoryInterface
import com.lavsindustries.movieapi.utils.exceptions.MovieException
import com.lavsindustries.movieapi.utils.mapper.MovieMapper
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepositoryInterface,
    private val movieMapper: MovieMapper
) : MovieServiceInterface {
    override fun getMovies(): List<MovieDTO> {
        val movies = movieRepository.getAllMovies()

        return movies.map {
            movieMapper.fromEntity(it)
        }
    }

    override fun createMovie(movieDTO: MovieDTO): MovieDTO {
        if(movieDTO.id == -1)
            throw MovieException("Id must be null or -1")

        val movie = movieMapper.toEntity(movieDTO)
        movieRepository.save(movie)
        return movieMapper.fromEntity(movie)
    }

    override fun getMovie(id: Int): MovieDTO {
        val optionalMovie = movieRepository.findById(id)
        val movie = optionalMovie.orElseThrow { MovieException("Movie with id $id is not registered") }
        return movieMapper.fromEntity(movie)
    }

    override fun updateMovie(movieDTO: MovieDTO): MovieDTO {
        getMovie(movieDTO.id)
        movieRepository.save(movieMapper.toEntity(movieDTO))
        return movieDTO
    }
}