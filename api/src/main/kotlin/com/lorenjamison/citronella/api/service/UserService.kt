package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.dao.UserDao
import com.lorenjamison.citronella.data.generated.citronella.tables.pojos.Users

class UserService(private val userDao: UserDao) {

    fun upsertUser(user: Users): Users? {
        if (user.id == null) {
            userDao.createUser(user)
        } else {
            userDao.updateUser(user)
        }
        return userDao.getUserByAuth0Id(user.auth0Id)
    }

    fun getUserById(id: Int): Users? {
        return userDao.getUserById(id)
    }

    fun getUserByAuth0Id(auth0Id: String): Users? {
        return userDao.getUserByAuth0Id(auth0Id)
    }
}
