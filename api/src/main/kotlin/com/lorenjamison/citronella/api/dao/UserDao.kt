package com.lorenjamison.citronella.api.dao

import com.lorenjamison.citronella.data.generated.tables.User.*
import com.lorenjamison.citronella.data.generated.tables.pojos.User
import com.lorenjamison.citronella.data.generated.tables.records.UserRecord
import org.jooq.DSLContext

class UserDao(private val dslContext: DSLContext) {

    fun getUserById(id: Int): User? {
        return dslContext.fetchOne(USER, USER.ID.eq(id))?.into(User::class.java)
    }

    fun getUserByExternalId(auth0Id: String): User? {
        return dslContext.fetchOne(USER, USER.EXTERNAL_ID.eq(auth0Id))?.into(User::class.java)
    }

    fun createUser(user: User) {
        val userRecord: UserRecord = dslContext.newRecord(USER, user)
        userRecord.store()
    }

    fun updateUser(user: User) {
        val userRecord: UserRecord = dslContext.newRecord(USER, user)
        dslContext.executeUpdate(userRecord)
    }

}
