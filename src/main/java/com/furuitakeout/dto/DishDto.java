package com.furuitakeout.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.furuitakeout.domain.Dish;
import com.furuitakeout.domain.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//@TableName("dishDto")
public class DishDto extends Dish {

    @TableField(exist = false)
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;  //后面要用的

    private Integer copies;  //后面要用的
}



