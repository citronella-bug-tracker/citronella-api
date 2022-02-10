package com.lorenjamison.citronella.api.api.v1

import com.lorenjamison.citronella.api.model.ChangePasswordRequest
import com.lorenjamison.citronella.api.model.CitronellaUser
import com.lorenjamison.citronella.api.service.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
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
    CitronellaUser upsertUser(@RequestBody CitronellaUser user) {
        userService.upsertUser(user)
    }

    @GetMapping(value = ['/{id}'])
    CitronellaUser getUserById(@PathVariable Long id) {
        userService.getUserById(id)
    }

    @PutMapping(value = ['/{id}/changepassword'], consumes = ['application/JSON'])
    void changeUserPassword(@PathVariable Long id, @RequestBody ChangePasswordRequest request) {

    }
}
