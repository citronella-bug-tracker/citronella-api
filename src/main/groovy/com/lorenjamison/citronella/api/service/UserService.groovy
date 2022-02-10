package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.mapper.PrivilegeMapper
import com.lorenjamison.citronella.api.mapper.RoleMapper
import com.lorenjamison.citronella.api.mapper.UserMapper
import com.lorenjamison.citronella.api.model.ChangePasswordRequest
import com.lorenjamison.citronella.api.model.CitronellaUser
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@CompileStatic
class UserService {

    private UserMapper userMapper
    private RoleMapper roleMapper
    private PrivilegeMapper privilegeMapper

    @Autowired
    UserService(UserMapper userMapper,
                RoleMapper roleMapper,
                PrivilegeMapper privilegeMapper) {
        this.userMapper = userMapper
        this.roleMapper = roleMapper
        this.privilegeMapper = privilegeMapper
    }

    CitronellaUser upsertUser(CitronellaUser user) {
        Long userId
        if (user.id == null) {
            userId = userMapper.createUser(user)
        } else {
            userId = user.id
            userMapper.updateUser(user)
        }

        getUserById(userId)
    }

    CitronellaUser getUserById (Long userId) {
        CitronellaUser user = userMapper.getUserById(userId)
        getRolesAndPrivilegesForUser(user)
        user
    }

    CitronellaUser getUserByEmailAddress(String emailAddress) {
        CitronellaUser user = userMapper.getUserByEmail(emailAddress)
        getRolesAndPrivilegesForUser(user)
        user
    }

    void changeUserPassword(Long userId, ChangePasswordRequest request) {
        if (request.newPassword != request.confirmNewPassword) {
            //TODO: Return helpful error response
            return
        }
        CitronellaUser user = getUserById(userId)
        if (!user) {
            //TODO: Return a helpful error response
            return
        }
        //TODO: Verify old password matches

        //TODO: Set new password
        userMapper.changePassword(user)
    }

    private void getRolesAndPrivilegesForUser(CitronellaUser user) {
        if (user) {
            user.roles = roleMapper.getRolesForUser(user.id)
            user.privileges = []
            user.roles.each { role ->
                user.privileges.addAll(privilegeMapper.getPrivilegesForRole(role.id))
            }
        }
        user
    }
}
