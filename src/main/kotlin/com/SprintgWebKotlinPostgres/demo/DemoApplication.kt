package com.SprintgWebKotlinPostgres.demo

import com.SprintgWebKotlinPostgres.demo.model.Dog
import com.SprintgWebKotlinPostgres.demo.repository.DogRepsoitory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@SpringBootApplication

class DemoApplication (val dogRepository: DogRepsoitory): ApplicationRunner{
	override fun run(args:ApplicationArguments){
		val dog1 = Dog (9999,"Meg",9,"B")
		val dog2 = Dog (9999,"Duffy",5,"B")
		dogRepository.save(dog1)
		dogRepository.save(dog2)
	}

}

	fun main(args: Array<String>) {
		runApplication<DemoApplication>(*args)
	}


