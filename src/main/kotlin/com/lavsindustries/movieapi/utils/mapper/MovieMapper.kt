package com.lavsindustries.movieapi.utils.mapper

import com.lavsindustries.movieapi.dtos.MovieDTO
import com.lavsindustries.movieapi.entity.Movie
import org.springframework.stereotype.Service

@Service
class MovieMapper: Mapper<MovieDTO, Movie> {
    override fun fromEntity(entity: Movie): MovieDTO {
        return MovieDTO(entity.id, entity.name, entity.rating)
    }

    override fun toEntity(domain: MovieDTO): Movie {
        return Movie(domain.id, domain.name, domain.rating)
    }
}