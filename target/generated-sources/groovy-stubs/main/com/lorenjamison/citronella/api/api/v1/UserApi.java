package com.lorenjamison.citronella.api.api.v1;
import org.springframework.web.bind.annotation.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.web.bind.annotation.RestController() @org.springframework.web.bind.annotation.RequestMapping(value={"/api/v1/users"}, produces={"application/JSON"}) @groovy.transform.CompileStatic() public class UserApi
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
@org.springframework.beans.factory.annotation.Autowired() public UserApi
(com.lorenjamison.citronella.api.service.UserService userService) {}
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
@org.springframework.web.bind.annotation.PutMapping(value={"/"}, consumes={"application/JSON"}) public  com.lorenjamison.citronella.api.model.User upsertUser(@org.springframework.web.bind.annotation.RequestBody() com.lorenjamison.citronella.api.model.User user) { return (com.lorenjamison.citronella.api.model.User)null;}
@org.springframework.web.bind.annotation.GetMapping(value={"/{id}"}) public  com.lorenjamison.citronella.api.model.User getUserById(@org.springframework.web.bind.annotation.PathVariable() java.lang.Long id) { return (com.lorenjamison.citronella.api.model.User)null;}
}
