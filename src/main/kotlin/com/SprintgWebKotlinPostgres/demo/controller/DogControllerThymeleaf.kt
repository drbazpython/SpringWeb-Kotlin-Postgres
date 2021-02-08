package com.SprintgWebKotlinPostgres.demo.controller
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.SprintgWebKotlinPostgres.demo.model.Dog
import com.SprintgWebKotlinPostgres.demo.repository.DogRepsoitory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class DogControllerThymeleaf {
	@Autowired
	lateinit var dogRepository: DogRepsoitory
	private val log = LoggerFactory.getLogger(DogControllerThymeleaf::class.java)

	@GetMapping("/dogs/list")
	fun listDogs(model: Model):String{
		model.addAttribute("dogs",dogRepository.findAll())
		return "list"
	}
	@GetMapping("/create")
	fun createDogForm(model:Model):String{
		model.addAttribute("dog", Dog())
		return "create"
	}
	@PostMapping("/create")
	fun saveDog(@ModelAttribute("dog") dog:Dog, model:Model):String{
		model.addAttribute("dog", dog)
		val info = String.format("Submission: name = %s", dog.name)
		log.info(info)
		dogRepository.save(dog)
		return "result"
	}
}