package com.lorenjamison.citronella.api.mapper

import com.lorenjamison.citronella.api.model.Role
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface RoleMapper {

    @Select('''SELECT r.*
               FROM role r
               JOIN user_roles ur on r.id = ur.role_id
               WHERE ur.user_id = #{user_id}''')
    List<Role> getRolesForUser(@Param('user_id') Long userId)
}