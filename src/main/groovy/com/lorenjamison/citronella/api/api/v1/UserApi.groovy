package com.lorenjamison.citronella.api.api.v1

import com.lorenjamison.citronella.api.model.ChangePasswordRequest
import com.lorenjamison.citronella.api.model.CitronellaUser
import com.lorenjamison.citronella.api.service.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
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

    @GetMapping(value = ['/'])
    ResponseEntity getLoggedInUser() {
        String email = SecurityContextHolder.context.authentication.name
        ResponseEntity.ok(userService.getUserByEmailAddress(email))
    }

    @PutMapping(value = ['/'], consumes = ['application/JSON'])
    ResponseEntity upsertUser(@RequestBody CitronellaUser user) {
        ResponseEntity.ok(userService.upsertUser(user))
    }

    @GetMapping(value = ['/{id}'])
    ResponseEntity getUserById(@PathVariable Long id) {
        CitronellaUser user = userService.getUserById(id)
        user ? ResponseEntity.ok(user) : ResponseEntity.notFound().build()
    }

    @PutMapping(value = ['/{id}/changepassword'], consumes = ['application/JSON'])
    ResponseEntity changeUserPassword(@PathVariable Long id, @RequestBody ChangePasswordRequest request) {
        ResponseEntity.badRequest().build() //TODO: Not implemented yet
    }
}
