package com.furuitakeout.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDTO extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;  //后面要用的

    private Integer copies;  //后面要用的
}



