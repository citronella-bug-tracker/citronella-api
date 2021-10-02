package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.mapper.UserMapper
import com.lorenjamison.citronella.api.model.User
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@CompileStatic
class UserService {

    private UserMapper userMapper

    @Autowired
    UserService(UserMapper userMapper) {
        this.userMapper = userMapper
    }

    User upsertUser(User user) {
        Long userId
        if (user.id == null) {
            userId = userMapper.createUser(user)
        } else {
            userId = user.id
            userMapper.updateUser(user)
        }

        getUserById(userId)
    }

    User getUserById (Long userId) {
        userMapper.getUser(userId)
    }

    void changeUserPassword(User user) {
        userMapper.changePassword(user)
    }

}
