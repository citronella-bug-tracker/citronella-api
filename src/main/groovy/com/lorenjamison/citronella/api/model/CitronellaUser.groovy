package com.lorenjamison.citronella.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic

@CompileStatic
class CitronellaUser {
    Long id
    String firstName
    String lastName
    String email
    Boolean enabled
    @JsonIgnore
    String password
}
