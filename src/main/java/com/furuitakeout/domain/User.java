package com.furuitakeout.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 用户信息
* @TableName user
*/
public class User implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 姓名
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("姓名")
    @Length(max= 50,message="编码长度不能超过50")
    private String name;
    /**
    * 手机号
    */
    @NotBlank(message="[手机号]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("手机号")
    @Length(max= 100,message="编码长度不能超过100")
    private String phone;
    /**
    * 性别
    */
    @Size(max= 2,message="编码长度不能超过2")
    @ApiModelProperty("性别")
    @Length(max= 2,message="编码长度不能超过2")
    private String sex;
    /**
    * 身份证号
    */
    @Size(max= 18,message="编码长度不能超过18")
    @ApiModelProperty("身份证号")
    @Length(max= 18,message="编码长度不能超过18")
    private String idNumber;
    /**
    * 头像
    */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("头像")
    @Length(max= 500,message="编码长度不能超过500")
    private String avatar;
    /**
    * 状态 0:禁用，1:正常
    */
    @ApiModelProperty("状态 0:禁用，1:正常")
    private Integer status;

    /**
    * 主键
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 姓名
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 手机号
    */
    private void setPhone(String phone){
    this.phone = phone;
    }

    /**
    * 性别
    */
    private void setSex(String sex){
    this.sex = sex;
    }

    /**
    * 身份证号
    */
    private void setIdNumber(String idNumber){
    this.idNumber = idNumber;
    }

    /**
    * 头像
    */
    private void setAvatar(String avatar){
    this.avatar = avatar;
    }

    /**
    * 状态 0:禁用，1:正常
    */
    private void setStatus(Integer status){
    this.status = status;
    }


    /**
    * 主键
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 姓名
    */
    private String getName(){
    return this.name;
    }

    /**
    * 手机号
    */
    private String getPhone(){
    return this.phone;
    }

    /**
    * 性别
    */
    private String getSex(){
    return this.sex;
    }

    /**
    * 身份证号
    */
    private String getIdNumber(){
    return this.idNumber;
    }

    /**
    * 头像
    */
    private String getAvatar(){
    return this.avatar;
    }

    /**
    * 状态 0:禁用，1:正常
    */
    private Integer getStatus(){
    return this.status;
    }

}
