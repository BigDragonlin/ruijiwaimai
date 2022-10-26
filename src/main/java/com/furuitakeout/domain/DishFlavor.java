package com.furuitakeout.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 菜品口味关系表
* @TableName dish_flavor
*/
public class DishFlavor implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 菜品
    */
    @NotNull(message="[菜品]不能为空")
    @ApiModelProperty("菜品")
    private Long dishId;
    /**
    * 口味名称
    */
    @NotBlank(message="[口味名称]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("口味名称")
    @Length(max= 64,message="编码长度不能超过64")
    private String name;
    /**
    * 口味数据list
    */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("口味数据list")
    @Length(max= 500,message="编码长度不能超过500")
    private String value;
    /**
    * 创建时间
    */
    @NotNull(message="[创建时间]不能为空")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    @NotNull(message="[更新时间]不能为空")
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
    /**
    * 创建人
    */
    @NotNull(message="[创建人]不能为空")
    @ApiModelProperty("创建人")
    private Long createUser;
    /**
    * 修改人
    */
    @NotNull(message="[修改人]不能为空")
    @ApiModelProperty("修改人")
    private Long updateUser;
    /**
    * 是否删除
    */
    @NotNull(message="[是否删除]不能为空")
    @ApiModelProperty("是否删除")
    private Integer isDeleted;

    /**
    * 主键
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 菜品
    */
    private void setDishId(Long dishId){
    this.dishId = dishId;
    }

    /**
    * 口味名称
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 口味数据list
    */
    private void setValue(String value){
    this.value = value;
    }

    /**
    * 创建时间
    */
    private void setCreateTime(LocalDateTime createTime){
    this.createTime = createTime;
    }

    /**
    * 更新时间
    */
    private void setUpdateTime(LocalDateTime updateTime){
    this.updateTime = updateTime;
    }

    /**
    * 创建人
    */
    private void setCreateUser(Long createUser){
    this.createUser = createUser;
    }

    /**
    * 修改人
    */
    private void setUpdateUser(Long updateUser){
    this.updateUser = updateUser;
    }

    /**
    * 是否删除
    */
    private void setIsDeleted(Integer isDeleted){
    this.isDeleted = isDeleted;
    }


    /**
    * 主键
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 菜品
    */
    private Long getDishId(){
    return this.dishId;
    }

    /**
    * 口味名称
    */
    private String getName(){
    return this.name;
    }

    /**
    * 口味数据list
    */
    private String getValue(){
    return this.value;
    }

    /**
    * 创建时间
    */
    private LocalDateTime getCreateTime(){
    return this.createTime;
    }

    /**
    * 更新时间
    */
    private LocalDateTime getUpdateTime(){
    return this.updateTime;
    }

    /**
    * 创建人
    */
    private Long getCreateUser(){
    return this.createUser;
    }

    /**
    * 修改人
    */
    private Long getUpdateUser(){
    return this.updateUser;
    }

    /**
    * 是否删除
    */
    private Integer getIsDeleted(){
    return this.isDeleted;
    }

}
