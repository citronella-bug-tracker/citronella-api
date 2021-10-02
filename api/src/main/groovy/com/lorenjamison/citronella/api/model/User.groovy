package com.lorenjamison.citronella.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic

@CompileStatic
class User {
    Long id
    String firstName
    String lastName
    String email
    @JsonIgnore
    String password
}
