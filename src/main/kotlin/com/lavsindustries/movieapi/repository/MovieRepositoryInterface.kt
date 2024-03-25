package com.lavsindustries.movieapi.repository

import com.lavsindustries.movieapi.entity.Movie
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface MovieRepositoryInterface: CrudRepository<Movie, Int> {

    @Query("SELECT m FROM Movie AS m")
    fun getAllMovies(): List<Movie>
}