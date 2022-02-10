package com.lorenjamison.citronella.api.service.jwt


import com.lorenjamison.citronella.api.model.CitronellaUser
import com.lorenjamison.citronella.api.service.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@CompileStatic
@Service
class JwtUserDetailsService implements UserDetailsService {
    private UserService userService

    @Autowired
    JwtUserDetailsService(UserService userService) {
        this.userService = userService
    }

    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CitronellaUser citronellaUser = userService.getUserByEmailAddress(email)
        if (!citronellaUser) {
            throw new UsernameNotFoundException("No account found for username/email address ${email}")
        }
        new User(email,
                citronellaUser.password,
                citronellaUser.enabled,
                true,
                true,
                true,
                grantedAuthoritiesForUser(citronellaUser))
    }

    private static List<GrantedAuthority> grantedAuthoritiesForUser(CitronellaUser user) {
        List<GrantedAuthority> authorities = []

        user.roles.each { role ->
            authorities << new SimpleGrantedAuthority("ROLE_${role.name}")
        }
        user.privileges.each { privilege ->
            authorities << new SimpleGrantedAuthority(privilege.name)
        }
        authorities
    }
}
