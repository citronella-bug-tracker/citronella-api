package com.lorenjamison.citronella.api.service.jwt

import com.lorenjamison.citronella.api.mapper.UserMapper
import com.lorenjamison.citronella.api.model.CitronellaUser
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@CompileStatic
@Service
class JwtUserDetailsService implements UserDetailsService {
    private UserMapper userMapper

    @Autowired
    JwtUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper
    }

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CitronellaUser citronellaUser = userMapper.getUserByEmail(username)
        if (citronellaUser) {
            return new User(username,
                    citronellaUser.password,
                    citronellaUser.enabled,
                    true,
                    true,
                    true,
                    [])
        } else {
            throw new UsernameNotFoundException("No account found for username/email address ${username}")
        }
    }
}
