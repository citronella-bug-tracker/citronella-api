package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.dao.UserDao
import com.lorenjamison.citronella.data.generated.tables.pojos.User

class UserService(private val userDao: UserDao) {

    fun upsertUser(user: User): User? {
        if (user.id == null) {
            userDao.createUser(user)
        } else {
            userDao.updateUser(user)
        }
        return getUserByExternalId(user.externalId)
    }

    fun getUserById(id: Int): User? {
        return userDao.getUserById(id)
    }

    fun getUserByExternalId(externalId: String): User? {
        return userDao.getUserByExternalId(externalId)
    }
}
