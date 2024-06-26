package com.lavsindustries.movieapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var name: String,
    var rating: Double
) {
    constructor() : this(0, "", 0.0)
}
