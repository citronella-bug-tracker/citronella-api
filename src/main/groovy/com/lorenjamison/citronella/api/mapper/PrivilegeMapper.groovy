package com.lorenjamison.citronella.api.mapper

import com.lorenjamison.citronella.api.model.Privilege
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface PrivilegeMapper {
    @Select('''SELECT p.*
               FROM privilege p
               JOIN role_privileges rp on p.id = rp.privilege_id
               WHERE rp.role_id = #{role_id}''')
    List<Privilege> getPrivilegesForRole(@Param('role_id') Long roleId)
}