package com.furuitakeout.service;

import com.furuitakeout.domain.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.furuitakeout.dto.DishDto;

/**
* @author Administrator
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2022-10-22 04:11:02
*/
public interface DishService extends IService<Dish> {
    void saveWithFlavors(DishDto dishDto);

    void updateWithFlavors(DishDto dishDto);
}
