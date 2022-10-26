package com.furuitakeout.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 订单明细表
* @TableName order_detail
*/
public class OrderDetail implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 名字
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("名字")
    @Length(max= 50,message="编码长度不能超过50")
    private String name;
    /**
    * 图片
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("图片")
    @Length(max= 100,message="编码长度不能超过100")
    private String image;
    /**
    * 订单id
    */
    @NotNull(message="[订单id]不能为空")
    @ApiModelProperty("订单id")
    private Long orderId;
    /**
    * 菜品id
    */
    @ApiModelProperty("菜品id")
    private Long dishId;
    /**
    * 套餐id
    */
    @ApiModelProperty("套餐id")
    private Long setmealId;
    /**
    * 口味
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("口味")
    @Length(max= 50,message="编码长度不能超过50")
    private String dishFlavor;
    /**
    * 数量
    */
    @NotNull(message="[数量]不能为空")
    @ApiModelProperty("数量")
    private Integer number;
    /**
    * 金额
    */
    @NotNull(message="[金额]不能为空")
    @ApiModelProperty("金额")
    private BigDecimal amount;

    /**
    * 主键
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 名字
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 图片
    */
    private void setImage(String image){
    this.image = image;
    }

    /**
    * 订单id
    */
    private void setOrderId(Long orderId){
    this.orderId = orderId;
    }

    /**
    * 菜品id
    */
    private void setDishId(Long dishId){
    this.dishId = dishId;
    }

    /**
    * 套餐id
    */
    private void setSetmealId(Long setmealId){
    this.setmealId = setmealId;
    }

    /**
    * 口味
    */
    private void setDishFlavor(String dishFlavor){
    this.dishFlavor = dishFlavor;
    }

    /**
    * 数量
    */
    private void setNumber(Integer number){
    this.number = number;
    }

    /**
    * 金额
    */
    private void setAmount(BigDecimal amount){
    this.amount = amount;
    }


    /**
    * 主键
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 名字
    */
    private String getName(){
    return this.name;
    }

    /**
    * 图片
    */
    private String getImage(){
    return this.image;
    }

    /**
    * 订单id
    */
    private Long getOrderId(){
    return this.orderId;
    }

    /**
    * 菜品id
    */
    private Long getDishId(){
    return this.dishId;
    }

    /**
    * 套餐id
    */
    private Long getSetmealId(){
    return this.setmealId;
    }

    /**
    * 口味
    */
    private String getDishFlavor(){
    return this.dishFlavor;
    }

    /**
    * 数量
    */
    private Integer getNumber(){
    return this.number;
    }

    /**
    * 金额
    */
    private BigDecimal getAmount(){
    return this.amount;
    }

}
