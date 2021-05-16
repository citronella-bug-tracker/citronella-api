package com.lorenjamison.citronella.api.exception

import org.jooq.ExecuteContext
import org.jooq.SQLDialect
import org.jooq.impl.DefaultExecuteListener
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator

class ExceptionTranslator : DefaultExecuteListener() {

    override fun exception(ctx: ExecuteContext) {
        if (ctx.sqlException() != null) {
            val dialect: SQLDialect = ctx.dialect()
            val translator = SQLErrorCodeSQLExceptionTranslator(dialect.thirdParty().springDbName()!!)
            ctx.exception(translator.translate("jOOQ", ctx.sql(), ctx.sqlException()!!))
        }
    }
}