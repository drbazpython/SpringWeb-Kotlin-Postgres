package com.SprintgWebKotlinPostgres.demo.controller

import com.SprintgWebKotlinPostgres.demo.model.Dog
import com.SprintgWebKotlinPostgres.demo.repository.DogRepsoitory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DogController {
	@Autowired
	lateinit var dogRepository: DogRepsoitory

	@CrossOrigin
	@GetMapping("/dogs")
	fun getAllDogs():List<Dog>{
		return dogRepository.findAll()
	}

	@CrossOrigin
	@PostMapping("/dogs")
	fun createDog(@RequestBody dog:Dog):Dog{
		var dog1 = dogRepository.save(dog)
		return dog1


		return dog1
	}

	@CrossOrigin
	@GetMapping("/dogs/{id}")
	fun getDogById(@PathVariable id:Long):Dog{
		return dogRepository.getOne(id)
	}

	@CrossOrigin
	@DeleteMapping("/dogs")
	fun deleteDog(@PathVariable id:Long): ResponseEntity<Unit>{
		dogRepository.deleteById(id)
		return ResponseEntity.noContent().build()
	}
}