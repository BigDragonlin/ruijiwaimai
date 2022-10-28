package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.domain.Category;
import com.furuitakeout.domain.Dish;
import com.furuitakeout.domain.Setmeal;
import com.furuitakeout.domain.SetmealDish;
import com.furuitakeout.dto.SetMealDto;
import com.furuitakeout.service.SetmealService;
import com.furuitakeout.mapper.SetmealMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【setmeal(套餐)】的数据库操作Service实现
* @createDate 2022-10-22 04:11:02
*/
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal>
    implements SetmealService{

    @Autowired
    SetmealDishServiceImpl setmealDishService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Override
    @Transactional
    public Boolean saveWithDishCategory(SetMealDto setMealDto) {
        this.save(setMealDto);
        final List<SetmealDish> setmealDishes = setMealDto.getSetmealDishes();
        List<SetmealDish> newSetMeal = setmealDishes.stream().map((item) -> {
            item.setSetmealId(setMealDto.getId().toString());
            return item;
        }).collect(Collectors.toList());
        final boolean saveBatch = setmealDishService.saveBatch(newSetMeal);
        return saveBatch;
    }

    @Override
    public SetMealDto updateSetmealByID(Long id) {
        final Setmeal setmeal = this.getById(id);
        final SetMealDto setMealDto = new SetMealDto();
        BeanUtils.copyProperties(setmeal,setMealDto);

        final String name = categoryService.getById(setmeal.getCategoryId()).getName();
        setMealDto.setCategoryName(name);

        final LambdaQueryWrapper<SetmealDish> setmealDishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealDishLambdaQueryWrapper.eq(SetmealDish::getSetmealId,id.toString()).eq(SetmealDish::getIsDeleted,0);
        final List<SetmealDish> setmealDishes = setmealDishService.list(setmealDishLambdaQueryWrapper);
        setMealDto.setSetmealDishes(setmealDishes);
        return setMealDto;
    }

    @Override
    public Boolean updateWithCaDi(SetMealDto setMealDto) {
        this.updateById(setMealDto);
        //找到setmealdish表中的关联setmealdish的字段，然后直接删除
        final LambdaQueryWrapper<SetmealDish> setmealDishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealDishLambdaQueryWrapper.eq(SetmealDish::getSetmealId,setMealDto.getId().toString());
        setmealDishService.remove(setmealDishLambdaQueryWrapper);

        //将setMealDto中的setmealdish字段添加到数据库中
        final List<SetmealDish> setmealDishes = setMealDto.getSetmealDishes();
        List<SetmealDish> dishes=setmealDishes.stream().map((item -> {
            item.setSetmealId(setMealDto.getId().toString());
            return item;
        })).collect(Collectors.toList());
        final boolean batch = setmealDishService.saveBatch(dishes);
        return batch;
    }
}




