package com.example.managementsystemdemo.entity.sysuser;
/**
 * @author longzhonghua
 * @data 2018/11/04 22:30
 */

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    /**
     *  编号
     */
    private Integer id;
    private String cnname;
    /**
     * 角色标识程序中判断使用,如"sys",这个是唯一的
     */
    private String role;
    /**
     * 角色描述,UI界面显示使用
     */
    private String description;
    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 角色-权限关系：多对多关系;
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissions;
    /**
     * 用户-角色关系定义;
     */
    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "uid")})
    /**
     * 一个角色对应多个用户
     */
    private List<SysUser> userInfos;
}
