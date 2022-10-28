package com.furuitakeout.controller;


import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.furuitakeout.common.R;
import com.furuitakeout.domain.Category;
import com.furuitakeout.domain.Dish;
import com.furuitakeout.domain.Setmeal;
import com.furuitakeout.dto.DishDto;
import com.furuitakeout.dto.SetMealDto;
import com.furuitakeout.service.impl.CategoryServiceImpl;
import com.furuitakeout.service.impl.DishServiceImpl;
import com.furuitakeout.service.impl.SetmealServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api("套餐管理")
@Slf4j
public class SetMealController {

    @Autowired
    SetmealServiceImpl setmealService;

    @Autowired
    DishServiceImpl dishService;

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/setmeal/page")
    @ApiParam("展示套餐页")
    R<Page> pageShow(Integer page, Integer pageSize) {
        final Page<SetMealDto> setMealDtoPage = new Page<>(page,pageSize);
        final LambdaQueryWrapper<Setmeal> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.orderByAsc(Setmeal::getUpdateTime);
        final List<Setmeal> list = setmealService.list(dishLambdaQueryWrapper);
        List<SetMealDto> newSetMeal = list.stream().map((item) -> {
            final Long categoryId = item.getCategoryId();
            final SetMealDto setMealDto = new SetMealDto();
            setMealDto.setCategoryName(categoryService.getById(categoryId).getName());
            BeanUtils.copyProperties(item,setMealDto);
            return setMealDto;
        }).collect(Collectors.toList());
        setMealDtoPage.setRecords(newSetMeal);
        return R.success(setMealDtoPage);
    }

    @ApiParam("套餐页套餐停止和开启")
    @PostMapping("/setmeal/status/{status}")
    R<String> haltSale(@PathVariable("status") Integer status, Long ids ){
        log.info("套餐页套餐停止和开启停止和开启 status:{}，ids：{}",status,ids);
        final Setmeal setmeal = new Setmeal();
        setmeal.setId(ids);
        setmeal.setStatus(status);
        setmealService.updateById(setmeal);
        return R.success("状态改变成功");
    }

    @ApiParam("套餐页套餐删除")
    @DeleteMapping("/setmeal")
    R<String> deleteDish(Long ids){
        setmealService.removeById(ids);
        return R.success("逻辑删除成功");
    }


    @ApiParam("添加套餐页添加菜品回显")
    @GetMapping("/dish/list")
    R<List<Dish>> showFoods(Long categoryId) {
        log.info("回显的category：{}",categoryId);
        final LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,categoryId).orderByDesc(Dish::getUpdateTime);
        final List<Dish> list = dishService.list(dishLambdaQueryWrapper);
        return R.success(list);
    }

    @ApiParam("添加套餐")
    @PostMapping("/setmeal")
    R<String> setMealAdd(@RequestBody SetMealDto setMealDto){
        final Boolean save = setmealService.saveWithDishCategory(setMealDto);
        return R.success(save?"添加成功":"添加失败");
    }

    @ApiParam("修改套餐页的回显")
    @GetMapping("/setmeal/{id}")
    R<SetMealDto> showSetmeal(@PathVariable("id") Long id){
        SetMealDto setMealDto =setmealService.updateSetmealByID(id);
        return R.success(setMealDto);
    }
    
    @ApiParam("修改套餐")
    @PutMapping("setmeal")
    R<String> setmealUpdate(@RequestBody SetMealDto setMealDto) {
        Boolean update =setmealService.updateWithCaDi(setMealDto);
        return R.success(update?"修改成功":"修改失败");
    }

}
