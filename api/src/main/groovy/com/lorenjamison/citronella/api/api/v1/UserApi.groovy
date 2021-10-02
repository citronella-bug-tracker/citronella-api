package com.lorenjamison.citronella.api.api.v1

import com.lorenjamison.citronella.api.model.User
import com.lorenjamison.citronella.api.service.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ['/api/v1/users'],
        produces = ['application/JSON'])
@CompileStatic
class UserApi {
    private UserService userService

    @Autowired
    UserApi(UserService userService) {
        this.userService = userService
    }

    @PutMapping(value = ['/'], consumes = ['application/JSON'])
    User upsertUser(@RequestBody User user) {
        userService.upsertUser(user)
    }

    @GetMapping(value = ['/{id}'])
    User getUserById(@PathVariable Long id) {
        userService.getUserById(id)
    }

}
