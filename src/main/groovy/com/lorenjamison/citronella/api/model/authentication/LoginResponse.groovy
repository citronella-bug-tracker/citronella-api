package com.lorenjamison.citronella.api.model.authentication

import groovy.transform.CompileStatic

@CompileStatic
class LoginResponse implements Serializable {
    private static final long serialVersionUID = 1L

    String token

    LoginResponse(String token) {
        this.token = token
    }
}
