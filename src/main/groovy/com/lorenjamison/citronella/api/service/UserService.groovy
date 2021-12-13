package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.mapper.UserMapper
import com.lorenjamison.citronella.api.model.ChangePasswordRequest
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

    void changeUserPassword(Long userId, ChangePasswordRequest request) {
        if (request.newPassword != request.confirmNewPassword) {
            //TODO: Return helpful error response
            return
        }
        User user = getUserById(userId)
        if (!user) {
            //TODO: Return a helpful error response
            return
        }
        //TODO: Verify old password matches

        //TODO: Set new password
        userMapper.changePassword(user)
    }
    
}
