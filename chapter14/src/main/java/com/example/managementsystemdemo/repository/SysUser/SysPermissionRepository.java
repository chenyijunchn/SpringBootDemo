
package com.example.managementsystemdemo.repository.SysUser;


import com.example.managementsystemdemo.entity.sysuser.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author longzhonghua
 * @data 2019/01/27 08:26
 */

public interface SysPermissionRepository extends JpaRepository<SysPermission, Long> {
    SysPermission findById(long id);


}

