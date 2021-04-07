package ca.tetervak.restbasicauthdemo1.controller

import ca.tetervak.restbasicauthdemo1.data.UserDataService
import ca.tetervak.restbasicauthdemo1.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/"])
class UserController(private val userDataService: UserDataService) {

    @GetMapping(path = ["/users"])
    fun userList(): ResponseEntity<List<User>>{
        return ResponseEntity(userDataService.getUsers(), HttpStatus.OK)
    }

}
