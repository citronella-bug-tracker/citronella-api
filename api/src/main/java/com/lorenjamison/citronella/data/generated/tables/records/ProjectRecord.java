/*
 * This file is generated by jOOQ.
 */
package com.lorenjamison.citronella.data.generated.tables.records;


import com.lorenjamison.citronella.data.generated.tables.Project;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProjectRecord extends UpdatableRecordImpl<ProjectRecord> implements Record4<Long, String, String, Byte> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>citronella.project.id</code>.
     */
    public ProjectRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>citronella.project.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>citronella.project.name</code>.
     */
    public ProjectRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>citronella.project.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>citronella.project.project_key</code>.
     */
    public ProjectRecord setProjectKey(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>citronella.project.project_key</code>.
     */
    public String getProjectKey() {
        return (String) get(2);
    }

    /**
     * Setter for <code>citronella.project.archived</code>.
     */
    public ProjectRecord setArchived(Byte value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>citronella.project.archived</code>.
     */
    public Byte getArchived() {
        return (Byte) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, Byte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, String, Byte> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Project.PROJECT.ID;
    }

    @Override
    public Field<String> field2() {
        return Project.PROJECT.NAME;
    }

    @Override
    public Field<String> field3() {
        return Project.PROJECT.PROJECT_KEY;
    }

    @Override
    public Field<Byte> field4() {
        return Project.PROJECT.ARCHIVED;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getProjectKey();
    }

    @Override
    public Byte component4() {
        return getArchived();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getProjectKey();
    }

    @Override
    public Byte value4() {
        return getArchived();
    }

    @Override
    public ProjectRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ProjectRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ProjectRecord value3(String value) {
        setProjectKey(value);
        return this;
    }

    @Override
    public ProjectRecord value4(Byte value) {
        setArchived(value);
        return this;
    }

    @Override
    public ProjectRecord values(Long value1, String value2, String value3, Byte value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProjectRecord
     */
    public ProjectRecord() {
        super(Project.PROJECT);
    }

    /**
     * Create a detached, initialised ProjectRecord
     */
    public ProjectRecord(Long id, String name, String projectKey, Byte archived) {
        super(Project.PROJECT);

        setId(id);
        setName(name);
        setProjectKey(projectKey);
        setArchived(archived);
    }
}
