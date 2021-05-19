package com.lorenjamison.citronella.api.dao

import com.lorenjamison.citronella.data.generated.tables.User.*
import com.lorenjamison.citronella.data.generated.tables.pojos.User
import com.lorenjamison.citronella.data.generated.tables.records.UserRecord
import org.jooq.DSLContext

class UserDao(private val dslContext: DSLContext) {

    fun getUserById(id: Long): User? {
        return dslContext.fetchOne(USER, USER.ID.eq(id))?.into(User::class.java)
    }

    fun getUserByExternalId(externalId: String): User? {
        return dslContext.fetchOne(USER, USER.EXTERNAL_ID.eq(externalId))?.into(User::class.java)
    }

    fun createUser(user: User): Long {
        val userRecord: UserRecord = dslContext.newRecord(USER, user)
        userRecord.store()
        return dslContext.lastID().toLong()
    }

    fun updateUser(user: User) {
        val userRecord: UserRecord = dslContext.newRecord(USER, user)
        dslContext.executeUpdate(userRecord)
    }

}
