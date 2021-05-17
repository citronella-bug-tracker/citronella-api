/*
 * This file is generated by jOOQ.
 */
package com.lorenjamison.citronella.data.generated.citronella;


import com.lorenjamison.citronella.data.generated.citronella.tables.Project;
import com.lorenjamison.citronella.data.generated.citronella.tables.User;
import com.lorenjamison.citronella.data.generated.citronella.tables.records.ProjectRecord;
import com.lorenjamison.citronella.data.generated.citronella.tables.records.UserRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * citronella.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ProjectRecord> KEY_PROJECT_PRIMARY = Internal.createUniqueKey(Project.PROJECT, DSL.name("KEY_project_PRIMARY"), new TableField[] { Project.PROJECT.ID }, true);
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, DSL.name("KEY_user_PRIMARY"), new TableField[] { User.USER.ID }, true);
    public static final UniqueKey<UserRecord> KEY_USER_USER_EXTERNAL_ID_IDX = Internal.createUniqueKey(User.USER, DSL.name("KEY_user_user_external_id_IDX"), new TableField[] { User.USER.EXTERNAL_ID }, true);
}
