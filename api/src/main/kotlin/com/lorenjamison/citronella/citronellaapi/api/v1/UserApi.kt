package com.lorenjamison.citronella.citronellaapi.api.v1

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/users"])
class UserApi {
    @PostMapping(value = ["/"],
        consumes = ["application/JSON"],
        produces = ["application/JSON"])
    fun createUser() {

    }
}