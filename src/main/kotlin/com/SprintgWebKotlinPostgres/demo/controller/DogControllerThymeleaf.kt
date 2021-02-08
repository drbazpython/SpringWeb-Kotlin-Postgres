package com.SprintgWebKotlinPostgres.demo.controller

import com.SprintgWebKotlinPostgres.demo.model.Dog
import com.SprintgWebKotlinPostgres.demo.repository.DogRepsoitory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
@Controller
class DogControllerThymeleaf {
	@Autowired
	lateinit var dogRepository: DogRepsoitory

	@GetMapping("/dogs/list")
	fun listDogsThymeleaf(model: Model):String{
		model.addAttribute("dogs",dogRepository.findAll())
		return "list"

	}
}