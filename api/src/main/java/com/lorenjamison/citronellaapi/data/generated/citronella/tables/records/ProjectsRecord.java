/*
 * This file is generated by jOOQ.
 */
package com.lorenjamison.citronellaapi.data.generated.citronella.tables.records;


import com.lorenjamison.citronellaapi.data.generated.citronella.tables.Projects;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProjectsRecord extends UpdatableRecordImpl<ProjectsRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 140598026;

    /**
     * Setter for <code>citronella.projects.id</code>.
     */
    public ProjectsRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>citronella.projects.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>citronella.projects.name</code>.
     */
    public ProjectsRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>citronella.projects.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Projects.PROJECTS.ID;
    }

    @Override
    public Field<String> field2() {
        return Projects.PROJECTS.NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public ProjectsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public ProjectsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ProjectsRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProjectsRecord
     */
    public ProjectsRecord() {
        super(Projects.PROJECTS);
    }

    /**
     * Create a detached, initialised ProjectsRecord
     */
    public ProjectsRecord(Integer id, String name) {
        super(Projects.PROJECTS);

        set(0, id);
        set(1, name);
    }
}
