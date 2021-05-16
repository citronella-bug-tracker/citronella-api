package com.lorenjamison.citronella.api.api.v1

import com.lorenjamison.citronella.api.service.UserService
import com.lorenjamison.citronella.data.generated.citronella.tables.pojos.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/users"])
class UserApi (@Autowired val userService: UserService) {

    @PutMapping(value = ["/"],
        consumes = ["application/JSON"],
        produces = ["application/JSON"])
    fun upsertUser(@RequestBody newUser: Users): Users? {
        return userService.upsertUser(newUser)
    }

    @GetMapping(value = ["/{id}"],
        produces = ["application/JSON"])
    fun getUserById(@PathVariable id: Int): Users? {
        return userService.getUserById(id)
    }

    @GetMapping(value = ["/auth0/{auth0Id}"],
        produces = ["application/JSON"])
    fun getUserByAuth0Id(@PathVariable auth0Id: String): Users? {
        return userService.getUserByAuth0Id(auth0Id)
    }

}
