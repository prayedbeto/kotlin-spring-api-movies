package com.lavsindustries.movieapi.utils.mapper

interface Mapper<D, E> {

    fun fromEntity(entity: E): D
    fun toEntity(domain: D): E
}