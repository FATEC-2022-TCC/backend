package com.fatec.tcc.animais.tests

import com.fatec.tcc.animais.animal.data.AnimalEntity
import com.fatec.tcc.animais.animal.data.AnimalRepository
import com.fatec.tcc.animais.animal.domain.Animal
import com.fatec.tcc.animais.roles.domain.Role
import com.fatec.tcc.animais.user.domain.User
import com.fatec.tcc.animais.user.domain.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.lang.IllegalStateException

@RestController
@RequestMapping("/test")
class UnsecureTestController(
    private val animalRepository: AnimalRepository,
    private val userRepository: UserRepository
) {
    @GetMapping("/helloworld")
    fun helloWorld() = "Hello World"

    @PostMapping("/animal")
    fun postAnimal(@RequestBody animal: Animal): AnimalEntity {
        if (animal.id != -1L) {
            throw IllegalStateException("Id must be -1")
        }
        val entity = animal.run {
            AnimalEntity(id, type, age)
        }
        return animalRepository.save(entity)
    }

    @PostMapping("/user")
    fun postUser(@RequestBody user: User) =
        userRepository.insert(user)

    @GetMapping("/user")
    fun getUser(@RequestParam userId: Long) =
        userRepository.find(userId)

    @PostMapping("/role")
    fun postRole(
        @RequestParam userId: Long,
        @RequestBody role: Role
    ): ResponseEntity<User> {
        val user = userRepository.find(userId) ?: return ResponseEntity.notFound().build()
        val roles = user.roles.toMutableList().apply {
            add(role)
        }
        val new = user.copy(roles = roles)
        return ResponseEntity.ok(userRepository.update(new))
    }
}