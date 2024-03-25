package com.lavsindustries.movieapi.web.rest

import com.lavsindustries.movieapi.service.MovieService
import com.lavsindustries.movieapi.dtos.MovieDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.Exception

@RestController
class MovieResource(
    private val movieService: MovieService
) {

    @GetMapping("/movies")
    fun getMovies(): ResponseEntity<List<MovieDTO>> =
        ResponseEntity(movieService.getMovies(), HttpStatus.OK)

    @PostMapping("/movies")
    fun createMovie(@RequestBody movieDTO: MovieDTO): ResponseEntity<MovieDTO> {
        return ResponseEntity(movieService.createMovie(movieDTO), HttpStatus.CREATED)
    }

    @GetMapping("/movies/{id}")
    fun getMovie(@PathVariable id: Int) =
        ResponseEntity(movieService.getMovie(id), HttpStatus.OK)

    @PutMapping("/movies")
    fun updateMovie(@RequestBody movieDTO: MovieDTO) =
        ResponseEntity(movieService.updateMovie(movieDTO), HttpStatus.OK)

    @DeleteMapping("/movies/{id}")
    fun deleteMovie(@PathVariable id: Int) =
        ResponseEntity(movieService.deleteMovie(id), HttpStatus.OK)
}