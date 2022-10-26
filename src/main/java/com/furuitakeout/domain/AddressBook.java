package com.furuitakeout.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 地址管理
* @TableName address_book
*/
public class AddressBook implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 用户id
    */
    @NotNull(message="[用户id]不能为空")
    @ApiModelProperty("用户id")
    private Long userId;
    /**
    * 收货人
    */
    @NotBlank(message="[收货人]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("收货人")
    @Length(max= 50,message="编码长度不能超过50")
    private String consignee;
    /**
    * 性别 0 女 1 男
    */
    @ApiModelProperty("性别 0 女 1 男")
    private Integer sex;
    /**
    * 手机号
    */
    @NotBlank(message="[手机号]不能为空")
    @Size(max= 11,message="编码长度不能超过11")
    @ApiModelProperty("手机号")
    @Length(max= 11,message="编码长度不能超过11")
    private String phone;
    /**
    * 省级区划编号
    */
    @Size(max= 12,message="编码长度不能超过12")
    @ApiModelProperty("省级区划编号")
    @Length(max= 12,message="编码长度不能超过12")
    private String provinceCode;
    /**
    * 省级名称
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("省级名称")
    @Length(max= 32,message="编码长度不能超过32")
    private String provinceName;
    /**
    * 市级区划编号
    */
    @Size(max= 12,message="编码长度不能超过12")
    @ApiModelProperty("市级区划编号")
    @Length(max= 12,message="编码长度不能超过12")
    private String cityCode;
    /**
    * 市级名称
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("市级名称")
    @Length(max= 32,message="编码长度不能超过32")
    private String cityName;
    /**
    * 区级区划编号
    */
    @Size(max= 12,message="编码长度不能超过12")
    @ApiModelProperty("区级区划编号")
    @Length(max= 12,message="编码长度不能超过12")
    private String districtCode;
    /**
    * 区级名称
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("区级名称")
    @Length(max= 32,message="编码长度不能超过32")
    private String districtName;
    /**
    * 详细地址
    */
    @Size(max= 200,message="编码长度不能超过200")
    @ApiModelProperty("详细地址")
    @Length(max= 200,message="编码长度不能超过200")
    private String detail;
    /**
    * 标签
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("标签")
    @Length(max= 100,message="编码长度不能超过100")
    private String label;
    /**
    * 默认 0 否 1是
    */
    @ApiModelProperty("默认 0 否 1是")
    private Integer isDefault;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
    /**
    * 创建人
    */
    @ApiModelProperty("创建人")
    private Long createUser;
    /**
    * 修改人
    */
    @ApiModelProperty("修改人")
    private Long updateUser;
    /**
    * 是否删除
    */
    @ApiModelProperty("是否删除")
    private Integer isDeleted;

    /**
    * 主键
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 用户id
    */
    private void setUserId(Long userId){
    this.userId = userId;
    }

    /**
    * 收货人
    */
    private void setConsignee(String consignee){
    this.consignee = consignee;
    }

    /**
    * 性别 0 女 1 男
    */
    private void setSex(Integer sex){
    this.sex = sex;
    }

    /**
    * 手机号
    */
    private void setPhone(String phone){
    this.phone = phone;
    }

    /**
    * 省级区划编号
    */
    private void setProvinceCode(String provinceCode){
    this.provinceCode = provinceCode;
    }

    /**
    * 省级名称
    */
    private void setProvinceName(String provinceName){
    this.provinceName = provinceName;
    }

    /**
    * 市级区划编号
    */
    private void setCityCode(String cityCode){
    this.cityCode = cityCode;
    }

    /**
    * 市级名称
    */
    private void setCityName(String cityName){
    this.cityName = cityName;
    }

    /**
    * 区级区划编号
    */
    private void setDistrictCode(String districtCode){
    this.districtCode = districtCode;
    }

    /**
    * 区级名称
    */
    private void setDistrictName(String districtName){
    this.districtName = districtName;
    }

    /**
    * 详细地址
    */
    private void setDetail(String detail){
    this.detail = detail;
    }

    /**
    * 标签
    */
    private void setLabel(String label){
    this.label = label;
    }

    /**
    * 默认 0 否 1是
    */
    private void setIsDefault(Integer isDefault){
    this.isDefault = isDefault;
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
    * 用户id
    */
    private Long getUserId(){
    return this.userId;
    }

    /**
    * 收货人
    */
    private String getConsignee(){
    return this.consignee;
    }

    /**
    * 性别 0 女 1 男
    */
    private Integer getSex(){
    return this.sex;
    }

    /**
    * 手机号
    */
    private String getPhone(){
    return this.phone;
    }

    /**
    * 省级区划编号
    */
    private String getProvinceCode(){
    return this.provinceCode;
    }

    /**
    * 省级名称
    */
    private String getProvinceName(){
    return this.provinceName;
    }

    /**
    * 市级区划编号
    */
    private String getCityCode(){
    return this.cityCode;
    }

    /**
    * 市级名称
    */
    private String getCityName(){
    return this.cityName;
    }

    /**
    * 区级区划编号
    */
    private String getDistrictCode(){
    return this.districtCode;
    }

    /**
    * 区级名称
    */
    private String getDistrictName(){
    return this.districtName;
    }

    /**
    * 详细地址
    */
    private String getDetail(){
    return this.detail;
    }

    /**
    * 标签
    */
    private String getLabel(){
    return this.label;
    }

    /**
    * 默认 0 否 1是
    */
    private Integer getIsDefault(){
    return this.isDefault;
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
