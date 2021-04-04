package com.lorenjamison.citronella.citronellaapi.dao

import com.lorenjamison.citronellaapi.data.generated.citronella.tables.Users.*
import com.lorenjamison.citronellaapi.data.generated.citronella.tables.pojos.Users
import com.lorenjamison.citronellaapi.data.generated.citronella.tables.records.UsersRecord
import org.jooq.DSLContext

class UserDao(private val dslContext: DSLContext) {

    fun getUserById(id: Int): Users? {
        return dslContext.fetchOne(USERS, USERS.ID.eq(id)).into(Users::class.java)
    }

    fun getUserByAuth0Id(auth0Id: String): Users? {
        return dslContext.fetchOne(USERS, USERS.AUTH0_ID.eq(auth0Id)).into(Users::class.java)
    }

    fun createUser(user: Users) {
        val newUserRecord: UsersRecord = dslContext.newRecord(USERS, user)
        newUserRecord.store()
    }

    fun updateUser(user: Users) {
        val updatedUserRecord: UsersRecord = dslContext.newRecord(USERS, user)
        dslContext.executeUpdate(updatedUserRecord)
    }

}