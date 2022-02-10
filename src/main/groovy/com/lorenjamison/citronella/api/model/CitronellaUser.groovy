package com.lorenjamison.citronella.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic
import org.springframework.security.core.userdetails.UserDetails

@CompileStatic
class CitronellaUser {
    Long id
    String firstName
    String lastName
    String email
    Boolean enabled
    @JsonIgnore
    String password

    List<Role> roles
    List<Privilege> privileges
}
