package com.lorenjamison.citronella.api.mapper;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
import groovy.lang.*;
import groovy.util.*;

@org.apache.ibatis.annotations.Mapper() public interface UserMapper
 {
;
@org.apache.ibatis.annotations.Select(value="SELECT * FROM user where id = #{id}")  com.lorenjamison.citronella.api.model.User getUser(@org.apache.ibatis.annotations.Param(value="id") java.lang.Long id);
@org.apache.ibatis.annotations.Insert(value="INSERT INTO\n            user(firstName, lastName, email, password)\n            VALUES(#{firstName}, #{lastName}, #{email}, #{password})\n            ") @org.apache.ibatis.annotations.Options(useGeneratedKeys=true, keyColumn="id")  java.lang.Long createUser(com.lorenjamison.citronella.api.model.User user);
@org.apache.ibatis.annotations.Update(value="\n        UPDATE user\n        SET\n            firstName = #{firstName},\n            lastName = #{lastName},\n            email = #{email}\n        WHERE id = #{id}\n        ")  void updateUser(com.lorenjamison.citronella.api.model.User user);
@org.apache.ibatis.annotations.Update(value="\n        UPDATE user\n        SET password = #{password}\n        WHERE id = #{id}\n        ")  void changePassword(com.lorenjamison.citronella.api.model.User user);
}
