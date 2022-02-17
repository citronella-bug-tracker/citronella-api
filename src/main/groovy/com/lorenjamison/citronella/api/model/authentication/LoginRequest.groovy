package com.lorenjamison.citronella.api.model.authentication

import groovy.transform.CompileStatic

@CompileStatic
class LoginRequest {
    String email
    String password
}
