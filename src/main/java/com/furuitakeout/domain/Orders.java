package com.furuitakeout.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 订单表
* @TableName orders
*/
public class Orders implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 订单号
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("订单号")
    @Length(max= 50,message="编码长度不能超过50")
    private String number;
    /**
    * 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
    */
    @NotNull(message="[订单状态 1待付款，2待派送，3已派送，4已完成，5已取消]不能为空")
    @ApiModelProperty("订单状态 1待付款，2待派送，3已派送，4已完成，5已取消")
    private Integer status;
    /**
    * 下单用户
    */
    @NotNull(message="[下单用户]不能为空")
    @ApiModelProperty("下单用户")
    private Long userId;
    /**
    * 地址id
    */
    @NotNull(message="[地址id]不能为空")
    @ApiModelProperty("地址id")
    private Long addressBookId;
    /**
    * 下单时间
    */
    @NotNull(message="[下单时间]不能为空")
    @ApiModelProperty("下单时间")
    private LocalDateTime orderTime;
    /**
    * 结账时间
    */
    @NotNull(message="[结账时间]不能为空")
    @ApiModelProperty("结账时间")
    private LocalDateTime checkoutTime;
    /**
    * 支付方式 1微信,2支付宝
    */
    @NotNull(message="[支付方式 1微信,2支付宝]不能为空")
    @ApiModelProperty("支付方式 1微信,2支付宝")
    private Integer payMethod;
    /**
    * 实收金额
    */
    @NotNull(message="[实收金额]不能为空")
    @ApiModelProperty("实收金额")
    private BigDecimal amount;
    /**
    * 备注
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("备注")
    @Length(max= 100,message="编码长度不能超过100")
    private String remark;
    /**
    * 
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("")
    @Length(max= 255,message="编码长度不能超过255")
    private String phone;
    /**
    * 
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("")
    @Length(max= 255,message="编码长度不能超过255")
    private String address;
    /**
    * 
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("")
    @Length(max= 255,message="编码长度不能超过255")
    private String userName;
    /**
    * 
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("")
    @Length(max= 255,message="编码长度不能超过255")
    private String consignee;

    /**
    * 主键
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 订单号
    */
    private void setNumber(String number){
    this.number = number;
    }

    /**
    * 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
    */
    private void setStatus(Integer status){
    this.status = status;
    }

    /**
    * 下单用户
    */
    private void setUserId(Long userId){
    this.userId = userId;
    }

    /**
    * 地址id
    */
    private void setAddressBookId(Long addressBookId){
    this.addressBookId = addressBookId;
    }

    /**
    * 下单时间
    */
    private void setOrderTime(LocalDateTime orderTime){
    this.orderTime = orderTime;
    }

    /**
    * 结账时间
    */
    private void setCheckoutTime(LocalDateTime checkoutTime){
    this.checkoutTime = checkoutTime;
    }

    /**
    * 支付方式 1微信,2支付宝
    */
    private void setPayMethod(Integer payMethod){
    this.payMethod = payMethod;
    }

    /**
    * 实收金额
    */
    private void setAmount(BigDecimal amount){
    this.amount = amount;
    }

    /**
    * 备注
    */
    private void setRemark(String remark){
    this.remark = remark;
    }

    /**
    * 
    */
    private void setPhone(String phone){
    this.phone = phone;
    }

    /**
    * 
    */
    private void setAddress(String address){
    this.address = address;
    }

    /**
    * 
    */
    private void setUserName(String userName){
    this.userName = userName;
    }

    /**
    * 
    */
    private void setConsignee(String consignee){
    this.consignee = consignee;
    }


    /**
    * 主键
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 订单号
    */
    private String getNumber(){
    return this.number;
    }

    /**
    * 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
    */
    private Integer getStatus(){
    return this.status;
    }

    /**
    * 下单用户
    */
    private Long getUserId(){
    return this.userId;
    }

    /**
    * 地址id
    */
    private Long getAddressBookId(){
    return this.addressBookId;
    }

    /**
    * 下单时间
    */
    private LocalDateTime getOrderTime(){
    return this.orderTime;
    }

    /**
    * 结账时间
    */
    private LocalDateTime getCheckoutTime(){
    return this.checkoutTime;
    }

    /**
    * 支付方式 1微信,2支付宝
    */
    private Integer getPayMethod(){
    return this.payMethod;
    }

    /**
    * 实收金额
    */
    private BigDecimal getAmount(){
    return this.amount;
    }

    /**
    * 备注
    */
    private String getRemark(){
    return this.remark;
    }

    /**
    * 
    */
    private String getPhone(){
    return this.phone;
    }

    /**
    * 
    */
    private String getAddress(){
    return this.address;
    }

    /**
    * 
    */
    private String getUserName(){
    return this.userName;
    }

    /**
    * 
    */
    private String getConsignee(){
    return this.consignee;
    }

}
