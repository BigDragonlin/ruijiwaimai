package com.furuitakeout.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Value;

/**
 * 员工信息
 *
 * @TableName employee
 */
@TableName(value = "employee")
@Data
public class Employee implements Serializable {
    /**
     * 主键
     */

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password",fill = FieldFill.INSERT)
    private String password;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 身份证号
     */
    @TableField(value = "id_number")
    private String idNumber;

    /**
     * 状态 0:禁用，1:正常
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime update_time;

    /**
     * 创建人
     */
    @TableField(value = "create_user",fill = FieldFill.INSERT_UPDATE)
    private Long create_user;

    /**
     * 修改人
     */
    @TableField(value = "update_user",fill = FieldFill.UPDATE)
    private Long update_user;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Employee other = (Employee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
                && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
                && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
                && (this.getCreate_user() == null ? other.getCreate_user() == null : this.getCreate_user().equals(other.getCreate_user()))
                && (this.getUpdate_user() == null ? other.getUpdate_user() == null : this.getUpdate_user().equals(other.getUpdate_user()));
    }



}