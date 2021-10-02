package com.lorenjamison.citronella.api.mapper

import com.lorenjamison.citronella.api.model.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface UserMapper {
    @Select('SELECT * FROM user where id = #{id}')
    User getUser(@Param('id') Long id)

    @Insert('''INSERT INTO
            user(firstName, lastName, email, password)
            VALUES(#{firstName}, #{lastName}, #{email}, #{password})
            ''')
    @Options(useGeneratedKeys = true, keyColumn = 'id')
    Long createUser(User user)

    @Update('''
        UPDATE user
        SET
            firstName = #{firstName},
            lastName = #{lastName},
            email = #{email}
        WHERE id = #{id}
        ''')
    void updateUser(User user)

    @Update('''
        UPDATE user
        SET password = #{password}
        WHERE id = #{id}
        ''')
    void changePassword(User user)
}