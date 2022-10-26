package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.common.myException.CustomerException;
import com.furuitakeout.domain.Category;
import com.furuitakeout.domain.Dish;
import com.furuitakeout.domain.Setmeal;
import com.furuitakeout.service.CategoryService;
import com.furuitakeout.mapper.CategoryMapper;
import com.furuitakeout.service.DishService;
import com.furuitakeout.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
* @createDate 2022-10-22 04:11:02
*/
@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    DishService dishService;

    @Autowired
    SetmealService setmealService;

    @Override
    public void remove(Long id) {
        log.info("重写CategoryServiceImpl remove，id={}",id);
        final LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategory_id,id);
        final List<Dish> list = dishService.list(dishLambdaQueryWrapper);
        if (list.size()>0){
            throw new CustomerException("种类中包含菜品");
        }

        final LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategory_id,id);
        final List<Setmeal> list1 = setmealService.list(setmealLambdaQueryWrapper);
        if (list1.size()>0){
            throw new CustomerException("种类中包含套餐");
        }
        super.removeById(id);
    }
}




