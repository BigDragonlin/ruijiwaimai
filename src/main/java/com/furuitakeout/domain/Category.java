package com.furuitakeout.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 菜品及套餐分类
* @TableName category
*/
public class Category implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 类型   1 菜品分类 2 套餐分类
    */
    @ApiModelProperty("类型   1 菜品分类 2 套餐分类")
    private Integer type;
    /**
    * 分类名称
    */
    @NotBlank(message="[分类名称]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("分类名称")
    @Length(max= 64,message="编码长度不能超过64")
    private String name;
    /**
    * 顺序
    */
    @NotNull(message="[顺序]不能为空")
    @ApiModelProperty("顺序")
    private Integer sort;
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
    * 主键
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 类型   1 菜品分类 2 套餐分类
    */
    private void setType(Integer type){
    this.type = type;
    }

    /**
    * 分类名称
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 顺序
    */
    private void setSort(Integer sort){
    this.sort = sort;
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
    * 主键
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 类型   1 菜品分类 2 套餐分类
    */
    private Integer getType(){
    return this.type;
    }

    /**
    * 分类名称
    */
    private String getName(){
    return this.name;
    }

    /**
    * 顺序
    */
    private Integer getSort(){
    return this.sort;
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

}
