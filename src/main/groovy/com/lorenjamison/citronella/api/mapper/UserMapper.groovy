package com.lorenjamison.citronella.api.mapper

import com.lorenjamison.citronella.api.model.CitronellaUser
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface UserMapper {
    @Select('SELECT * FROM user where id = #{id}')
    CitronellaUser getUserById(@Param('id') Long id)

    @Select('SELECT * FROM user where email = #{email}')
    CitronellaUser getUserByEmail(@Param('email') String email)

    @Insert('''INSERT INTO
            user(firstName, lastName, email, password, enabled)
            VALUES(#{firstName}, #{lastName}, #{email}, #{password}, #{enabled})
            ''')
    @Options(useGeneratedKeys = true, keyColumn = 'id')
    Long createUser(CitronellaUser user)

    @Update('''
        UPDATE user
        SET
            firstName = #{firstName},
            lastName = #{lastName},
            email = #{email},
            enabled = #{enabled}
        WHERE id = #{id}
        ''')
    void updateUser(CitronellaUser user)

    @Update('''
        UPDATE user
        SET password = #{password}
        WHERE id = #{id}
        ''')
    void changePassword(CitronellaUser user)
}