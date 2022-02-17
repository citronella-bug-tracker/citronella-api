package com.lorenjamison.citronella.api.authentication

import com.lorenjamison.citronella.api.model.CitronellaUser
import com.lorenjamison.citronella.api.model.authentication.LoginRequest
import com.lorenjamison.citronella.api.model.authentication.LoginResponse
import com.lorenjamison.citronella.api.service.UserService
import com.lorenjamison.citronella.api.service.jwt.JwtUserDetailsService
import groovy.transform.CompileStatic
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@CompileStatic
@Log
class AuthenticationController {
    private JwtUserDetailsService userDetailsService
    private UserService userService
    private AuthenticationManager authenticationManager
    private TokenManager tokenManager

    @Autowired
    AuthenticationManager(JwtUserDetailsService userDetailsService,
                          UserService userService,
                          AuthenticationManager authenticationManager,
                          TokenManager tokenManager) {
        this.userDetailsService = userDetailsService
        this.userService = userService
        this.authenticationManager = authenticationManager
        this.tokenManager = tokenManager
    }

    @PostMapping('/login')
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email, loginRequest.password))
        } catch (DisabledException e) {
            log.severe("User ${loginRequest.email} is disabled")
            throw e
        } catch (BadCredentialsException e) {
            log.severe("Bad credentials for user ${loginRequest.email}")
            throw e
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.email)
        String jwtToken = tokenManager.generateJwtToken(userDetails)
        CitronellaUser user = userService.getUserByEmailAddress(loginRequest.email)
        ResponseEntity.ok(new LoginResponse(jwtToken, user))
    }
}
