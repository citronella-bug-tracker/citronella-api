package com.lorenjamison.citronella.api.service;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.stereotype.Service() @groovy.transform.CompileStatic() public class UserService
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
@org.springframework.beans.factory.annotation.Autowired() public UserService
(com.lorenjamison.citronella.api.mapper.UserMapper userMapper) {}
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  com.lorenjamison.citronella.api.model.User upsertUser(com.lorenjamison.citronella.api.model.User user) { return (com.lorenjamison.citronella.api.model.User)null;}
public  com.lorenjamison.citronella.api.model.User getUserById(java.lang.Long userId) { return (com.lorenjamison.citronella.api.model.User)null;}
public  void changeUserPassword(com.lorenjamison.citronella.api.model.User user) { }
}
