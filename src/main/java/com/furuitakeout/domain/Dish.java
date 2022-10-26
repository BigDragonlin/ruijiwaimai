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
* 菜品管理
* @TableName dish
*/
public class Dish implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 菜品名称
    */
    @NotBlank(message="[菜品名称]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("菜品名称")
    @Length(max= 64,message="编码长度不能超过64")
    private String name;
    /**
    * 菜品分类id
    */
    @NotNull(message="[菜品分类id]不能为空")
    @ApiModelProperty("菜品分类id")
    private Long categoryId;
    /**
    * 菜品价格
    */
    @ApiModelProperty("菜品价格")
    private BigDecimal price;
    /**
    * 商品码
    */
    @NotBlank(message="[商品码]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("商品码")
    @Length(max= 64,message="编码长度不能超过64")
    private String code;
    /**
    * 图片
    */
    @NotBlank(message="[图片]不能为空")
    @Size(max= 200,message="编码长度不能超过200")
    @ApiModelProperty("图片")
    @Length(max= 200,message="编码长度不能超过200")
    private String image;
    /**
    * 描述信息
    */
    @Size(max= 400,message="编码长度不能超过400")
    @ApiModelProperty("描述信息")
    @Length(max= 400,message="编码长度不能超过400")
    private String description;
    /**
    * 0 停售 1 起售
    */
    @NotNull(message="[0 停售 1 起售]不能为空")
    @ApiModelProperty("0 停售 1 起售")
    private Integer status;
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
    * 菜品名称
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 菜品分类id
    */
    private void setCategoryId(Long categoryId){
    this.categoryId = categoryId;
    }

    /**
    * 菜品价格
    */
    private void setPrice(BigDecimal price){
    this.price = price;
    }

    /**
    * 商品码
    */
    private void setCode(String code){
    this.code = code;
    }

    /**
    * 图片
    */
    private void setImage(String image){
    this.image = image;
    }

    /**
    * 描述信息
    */
    private void setDescription(String description){
    this.description = description;
    }

    /**
    * 0 停售 1 起售
    */
    private void setStatus(Integer status){
    this.status = status;
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
    * 菜品名称
    */
    private String getName(){
    return this.name;
    }

    /**
    * 菜品分类id
    */
    private Long getCategoryId(){
    return this.categoryId;
    }

    /**
    * 菜品价格
    */
    private BigDecimal getPrice(){
    return this.price;
    }

    /**
    * 商品码
    */
    private String getCode(){
    return this.code;
    }

    /**
    * 图片
    */
    private String getImage(){
    return this.image;
    }

    /**
    * 描述信息
    */
    private String getDescription(){
    return this.description;
    }

    /**
    * 0 停售 1 起售
    */
    private Integer getStatus(){
    return this.status;
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

    /**
    * 是否删除
    */
    private Integer getIsDeleted(){
    return this.isDeleted;
    }

}
