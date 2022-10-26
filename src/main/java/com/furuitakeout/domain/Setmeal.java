package com.furuitakeout.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 套餐
* @TableName setmeal
*/
public class Setmeal implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 菜品分类id
    */
    @NotNull(message="[菜品分类id]不能为空")
    @ApiModelProperty("菜品分类id")
    private Long categoryId;
    /**
    * 套餐名称
    */
    @NotBlank(message="[套餐名称]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("套餐名称")
    @Length(max= 64,message="编码长度不能超过64")
    private String name;
    /**
    * 套餐价格
    */
    @NotNull(message="[套餐价格]不能为空")
    @ApiModelProperty("套餐价格")
    private BigDecimal price;
    /**
    * 状态 0:停用 1:启用
    */
    @ApiModelProperty("状态 0:停用 1:启用")
    private Integer status;
    /**
    * 编码
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("编码")
    @Length(max= 32,message="编码长度不能超过32")
    private String code;
    /**
    * 描述信息
    */
    @Size(max= 512,message="编码长度不能超过512")
    @ApiModelProperty("描述信息")
    @Length(max= 512,message="编码长度不能超过512")
    private String description;
    /**
    * 图片
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("图片")
    @Length(max= 255,message="编码长度不能超过255")
    private String image;
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
    * 菜品分类id
    */
    private void setCategoryId(Long categoryId){
    this.categoryId = categoryId;
    }

    /**
    * 套餐名称
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 套餐价格
    */
    private void setPrice(BigDecimal price){
    this.price = price;
    }

    /**
    * 状态 0:停用 1:启用
    */
    private void setStatus(Integer status){
    this.status = status;
    }

    /**
    * 编码
    */
    private void setCode(String code){
    this.code = code;
    }

    /**
    * 描述信息
    */
    private void setDescription(String description){
    this.description = description;
    }

    /**
    * 图片
    */
    private void setImage(String image){
    this.image = image;
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
    * 菜品分类id
    */
    private Long getCategoryId(){
    return this.categoryId;
    }

    /**
    * 套餐名称
    */
    private String getName(){
    return this.name;
    }

    /**
    * 套餐价格
    */
    private BigDecimal getPrice(){
    return this.price;
    }

    /**
    * 状态 0:停用 1:启用
    */
    private Integer getStatus(){
    return this.status;
    }

    /**
    * 编码
    */
    private String getCode(){
    return this.code;
    }

    /**
    * 描述信息
    */
    private String getDescription(){
    return this.description;
    }

    /**
    * 图片
    */
    private String getImage(){
    return this.image;
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
