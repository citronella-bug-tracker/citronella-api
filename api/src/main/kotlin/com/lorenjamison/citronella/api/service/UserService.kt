package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.dao.UserDao
import com.lorenjamison.citronella.data.generated.tables.pojos.User

class UserService(private val userDao: UserDao) {

    fun upsertUser(user: User): User? {
        val returnUserId: Long
        if (user.id == null) {
            returnUserId = userDao.createUser(user)
        } else {
            returnUserId = user.id
            userDao.updateUser(user)
        }
        return getUserById(returnUserId)
    }

    fun getUserById(id: Long): User? {
        return userDao.getUserById(id)
    }

    fun getUserByExternalId(externalId: String): User? {
        return userDao.getUserByExternalId(externalId)
    }
}
