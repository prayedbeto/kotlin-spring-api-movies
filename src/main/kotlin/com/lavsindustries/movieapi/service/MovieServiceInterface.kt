package com.lavsindustries.movieapi.service

import com.lavsindustries.movieapi.dtos.MovieDTO

interface MovieServiceInterface {

    fun getMovies(): List<MovieDTO>
    fun createMovie(movieDTO: MovieDTO): MovieDTO
    fun getMovie(id: Int): MovieDTO
    fun updateMovie(movieDTO: MovieDTO): MovieDTO
}