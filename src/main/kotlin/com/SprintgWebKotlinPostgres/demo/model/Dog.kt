package com.SprintgWebKotlinPostgres.demo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="dogs")
@JsonIgnoreProperties("hibernateLazyInitializer","handler")
class Dog (
	@Id
	@Column(name="id", nullable=false)
	@SequenceGenerator(name="dog_seq",sequenceName="dog_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO)
		val id:Long = -1,
		val name:String="Default",
		val age: Int=0,
		val sex: String="D"
	)

