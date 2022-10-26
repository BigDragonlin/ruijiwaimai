package com.furuitakeout.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 地址管理
 * @TableName address_book
 */
@TableName(value ="address_book")
@Data
public class AddressBook implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 收货人
     */
    @TableField(value = "consignee")
    private String consignee;

    /**
     * 性别 0 女 1 男
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 省级区划编号
     */
    @TableField(value = "province_code")
    private String province_code;

    /**
     * 省级名称
     */
    @TableField(value = "province_name")
    private String province_name;

    /**
     * 市级区划编号
     */
    @TableField(value = "city_code")
    private String city_code;

    /**
     * 市级名称
     */
    @TableField(value = "city_name")
    private String city_name;

    /**
     * 区级区划编号
     */
    @TableField(value = "district_code")
    private String district_code;

    /**
     * 区级名称
     */
    @TableField(value = "district_name")
    private String district_name;

    /**
     * 详细地址
     */
    @TableField(value = "detail")
    private String detail;

    /**
     * 标签
     */
    @TableField(value = "label")
    private String label;

    /**
     * 默认 0 否 1是
     */
    @TableField(value = "is_default")
    private Integer is_default;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime update_time;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    private Long create_user;

    /**
     * 修改人
     */
    @TableField(value = "update_user")
    private Long update_user;

    /**
     * 是否删除
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;

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
        AddressBook other = (AddressBook) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getConsignee() == null ? other.getConsignee() == null : this.getConsignee().equals(other.getConsignee()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getProvince_code() == null ? other.getProvince_code() == null : this.getProvince_code().equals(other.getProvince_code()))
            && (this.getProvince_name() == null ? other.getProvince_name() == null : this.getProvince_name().equals(other.getProvince_name()))
            && (this.getCity_code() == null ? other.getCity_code() == null : this.getCity_code().equals(other.getCity_code()))
            && (this.getCity_name() == null ? other.getCity_name() == null : this.getCity_name().equals(other.getCity_name()))
            && (this.getDistrict_code() == null ? other.getDistrict_code() == null : this.getDistrict_code().equals(other.getDistrict_code()))
            && (this.getDistrict_name() == null ? other.getDistrict_name() == null : this.getDistrict_name().equals(other.getDistrict_name()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
            && (this.getIs_default() == null ? other.getIs_default() == null : this.getIs_default().equals(other.getIs_default()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getCreate_user() == null ? other.getCreate_user() == null : this.getCreate_user().equals(other.getCreate_user()))
            && (this.getUpdate_user() == null ? other.getUpdate_user() == null : this.getUpdate_user().equals(other.getUpdate_user()))
            && (this.getIs_deleted() == null ? other.getIs_deleted() == null : this.getIs_deleted().equals(other.getIs_deleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getConsignee() == null) ? 0 : getConsignee().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getProvince_code() == null) ? 0 : getProvince_code().hashCode());
        result = prime * result + ((getProvince_name() == null) ? 0 : getProvince_name().hashCode());
        result = prime * result + ((getCity_code() == null) ? 0 : getCity_code().hashCode());
        result = prime * result + ((getCity_name() == null) ? 0 : getCity_name().hashCode());
        result = prime * result + ((getDistrict_code() == null) ? 0 : getDistrict_code().hashCode());
        result = prime * result + ((getDistrict_name() == null) ? 0 : getDistrict_name().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        result = prime * result + ((getIs_default() == null) ? 0 : getIs_default().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getCreate_user() == null) ? 0 : getCreate_user().hashCode());
        result = prime * result + ((getUpdate_user() == null) ? 0 : getUpdate_user().hashCode());
        result = prime * result + ((getIs_deleted() == null) ? 0 : getIs_deleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", consignee=").append(consignee);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", province_code=").append(province_code);
        sb.append(", province_name=").append(province_name);
        sb.append(", city_code=").append(city_code);
        sb.append(", city_name=").append(city_name);
        sb.append(", district_code=").append(district_code);
        sb.append(", district_name=").append(district_name);
        sb.append(", detail=").append(detail);
        sb.append(", label=").append(label);
        sb.append(", is_default=").append(is_default);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", create_user=").append(create_user);
        sb.append(", update_user=").append(update_user);
        sb.append(", is_deleted=").append(is_deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}