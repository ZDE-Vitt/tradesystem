package com.gem.tradesystem.back.entity;

import lombok.Data;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/26 10:04
 * @Description:
 */
@Data
public class SysUserCustom extends SysUser {
    private String roleName;

    @Override
    public String toString() {
        return super.toString() +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
