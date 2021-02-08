package com.SprintgWebKotlinPostgres.demo.repository

import com.SprintgWebKotlinPostgres.demo.model.Dog
import org.springframework.data.jpa.repository.JpaRepository

interface DogRepsoitory: JpaRepository<Dog,Long> {
fun findOneById(id:Long):Dog

}