package com.lorenjamison.citronella.citronellaapi.service

import com.lorenjamison.citronella.citronellaapi.dao.UserDao
import com.lorenjamison.citronellaapi.data.generated.citronella.tables.pojos.Users

class UserService(private val userDao: UserDao) {

    fun createUser(newUser: Users) {
        userDao.createUser(newUser)
    }

    fun updateUser(userToUpdate: Users) {
        userDao.updateUser(userToUpdate)
    }

    fun getUserById(id: Int): Users? {
        return userDao.getUserById(id)
    }

    fun getUserByAuth0Id(auth0Id: String): Users? {
        return userDao.getUserByAuth0Id(auth0Id)
    }
}