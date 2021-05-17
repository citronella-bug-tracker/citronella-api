package com.lorenjamison.citronella.api.api.v1

import com.lorenjamison.citronella.api.service.UserService
import com.lorenjamison.citronella.data.generated.citronella.tables.pojos.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/users"])
class UserApi (@Autowired val userService: UserService) {

    @PutMapping(value = ["/"],
        consumes = ["application/JSON"],
        produces = ["application/JSON"])
    fun upsertUser(@RequestBody newUser: User): User? {
        return userService.upsertUser(newUser)
    }

    @GetMapping(value = ["/{id}"],
        produces = ["application/JSON"])
    fun getUserById(@PathVariable id: Int): User? {
        return userService.getUserById(id)
    }

    @GetMapping(value = ["/external/{externalId}"],
        produces = ["application/JSON"])
    fun getUserByExternalId(@PathVariable externalId: String): User? {
        return userService.getUserByExternalId(externalId)
    }

}
