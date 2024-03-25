package com.lavsindustries.movieapi.utils.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun generalExceptionHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(exception.message ?: "Something went wrong")
        return ResponseEntity(error, error.status)
    }

    @ExceptionHandler(MovieException::class)
    fun movieExceptionHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(exception.message ?: "Something went wrong")
        return ResponseEntity(error, error.status)
    }

}