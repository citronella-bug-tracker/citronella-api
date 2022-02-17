package com.lorenjamison.citronella.api.model.authentication

import com.lorenjamison.citronella.api.model.CitronellaUser
import groovy.transform.CompileStatic

@CompileStatic
class LoginResponse implements Serializable {
    private static final long serialVersionUID = 1L

    String token
    CitronellaUser user

    LoginResponse(String token, CitronellaUser user) {
        this.token = token
        this.user = user
    }
}
