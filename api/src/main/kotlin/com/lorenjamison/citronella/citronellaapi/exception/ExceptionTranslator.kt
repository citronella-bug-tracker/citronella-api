package com.lorenjamison.citronella.citronellaapi.exception

import org.jooq.ExecuteContext
import org.jooq.SQLDialect
import org.jooq.impl.DefaultExecuteListener
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator

class ExceptionTranslator : DefaultExecuteListener() {

    override fun exception(ctx: ExecuteContext) {
        if (ctx.sqlException() != null) {
            val dialect: SQLDialect? = ctx.dialect()
            val translator = if (dialect != null)
                SQLErrorCodeSQLExceptionTranslator(dialect.thirdParty().springDbName())
            else SQLStateSQLExceptionTranslator()

            ctx.exception(translator.translate("jOOQ", ctx.sql(),ctx.sqlException()))
        }
    }
}