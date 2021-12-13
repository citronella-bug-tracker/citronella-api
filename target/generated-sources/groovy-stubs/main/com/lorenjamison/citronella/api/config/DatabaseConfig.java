package com.lorenjamison.citronella.api.config;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.context.annotation.Configuration() @groovy.transform.CompileStatic() public class DatabaseConfig
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.String getDbUrl() { return (java.lang.String)null;}
public  void setDbUrl(java.lang.String value) { }
public  java.lang.String getDbUsername() { return (java.lang.String)null;}
public  void setDbUsername(java.lang.String value) { }
public  java.lang.String getDbPassword() { return (java.lang.String)null;}
public  void setDbPassword(java.lang.String value) { }
@org.springframework.context.annotation.Bean() public  javax.sql.DataSource dataSource() { return (javax.sql.DataSource)null;}
@org.springframework.context.annotation.Bean() public  org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory() { return (org.apache.ibatis.session.SqlSessionFactory)null;}
}
