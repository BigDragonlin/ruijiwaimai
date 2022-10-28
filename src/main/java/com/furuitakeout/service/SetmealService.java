package com.furuitakeout.service;

import com.furuitakeout.domain.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.furuitakeout.dto.SetMealDto;

/**
* @author Administrator
* @description 针对表【setmeal(套餐)】的数据库操作Service
* @createDate 2022-10-22 04:11:02
*/
public interface SetmealService extends IService<Setmeal> {
    Boolean saveWithDishCategory(SetMealDto setMealDto);

    SetMealDto updateSetmealByID(Long id);

    Boolean updateWithCaDi(SetMealDto setMealDto);
}
