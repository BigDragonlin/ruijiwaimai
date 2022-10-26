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
* 套餐菜品关系
* @TableName setmeal_dish
*/
public class SetmealDish implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 套餐id 
    */
    @NotBlank(message="[套餐id ]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("套餐id ")
    @Length(max= 32,message="编码长度不能超过32")
    private String setmealId;
    /**
    * 菜品id
    */
    @NotBlank(message="[菜品id]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("菜品id")
    @Length(max= 32,message="编码长度不能超过32")
    private String dishId;
    /**
    * 菜品名称 （冗余字段）
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("菜品名称 （冗余字段）")
    @Length(max= 32,message="编码长度不能超过32")
    private String name;
    /**
    * 菜品原价（冗余字段）
    */
    @ApiModelProperty("菜品原价（冗余字段）")
    private BigDecimal price;
    /**
    * 份数
    */
    @NotNull(message="[份数]不能为空")
    @ApiModelProperty("份数")
    private Integer copies;
    /**
    * 排序
    */
    @NotNull(message="[排序]不能为空")
    @ApiModelProperty("排序")
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
    * 套餐id 
    */
    private void setSetmealId(String setmealId){
    this.setmealId = setmealId;
    }

    /**
    * 菜品id
    */
    private void setDishId(String dishId){
    this.dishId = dishId;
    }

    /**
    * 菜品名称 （冗余字段）
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 菜品原价（冗余字段）
    */
    private void setPrice(BigDecimal price){
    this.price = price;
    }

    /**
    * 份数
    */
    private void setCopies(Integer copies){
    this.copies = copies;
    }

    /**
    * 排序
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
    * 套餐id 
    */
    private String getSetmealId(){
    return this.setmealId;
    }

    /**
    * 菜品id
    */
    private String getDishId(){
    return this.dishId;
    }

    /**
    * 菜品名称 （冗余字段）
    */
    private String getName(){
    return this.name;
    }

    /**
    * 菜品原价（冗余字段）
    */
    private BigDecimal getPrice(){
    return this.price;
    }

    /**
    * 份数
    */
    private Integer getCopies(){
    return this.copies;
    }

    /**
    * 排序
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
