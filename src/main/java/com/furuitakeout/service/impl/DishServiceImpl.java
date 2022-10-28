package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.domain.Dish;
import com.furuitakeout.domain.DishFlavor;
import com.furuitakeout.dto.DishDto;
import com.furuitakeout.service.DishService;
import com.furuitakeout.mapper.DishMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2022-10-22 04:11:02
*/
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{

    @Autowired
    DishFlavorServiceImpl dishFlavorService;

    @Override
    @Transactional
    public void saveWithFlavors(DishDto dishDto) {

        log.info("存dto+{}",dishDto.toString());
        this.save(dishDto);
        final List<DishFlavor> flavors = dishDto.getFlavors();
        final Long categoryID = dishDto.getId();
        for (DishFlavor dishFlavor:flavors
        ) {
            dishFlavor.setDishId(categoryID);
            dishFlavorService.save(dishFlavor);
        }
    }

    @Override
    @Transactional
    public void updateWithFlavors(DishDto dishDto) {
        this.updateById(dishDto);
        final LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(dishFlavorLambdaQueryWrapper);
        final List<DishFlavor> flavors = dishDto.getFlavors();
        //使用流把单个flavor更新到 dishFlavor中去
        List flavorsTotal = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavorsTotal);
    }
}




