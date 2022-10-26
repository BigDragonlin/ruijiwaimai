package com.furuitakeout.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.furuitakeout.common.R;
import com.furuitakeout.dto.DishDTO;
import com.furuitakeout.service.impl.CategoryServiceImpl;
import com.furuitakeout.service.impl.DishDTOServiceImp;
import com.furuitakeout.service.impl.DishServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("菜品管理")
@Slf4j
public class DishController {

    @Autowired
    DishServiceImpl dishService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    DishDTOServiceImp dishDTOServiceImp;


    @GetMapping("/dish/page")
    @ApiParam("展示菜品页")
    R<Page> pageShow(Integer page, Integer pageSize) {
        final Page<Dish> pageInfo = new Page<Dish>(page, pageSize);
        log.info("菜品页page:{},pageSize:{}", page, pageSize);
        final LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.orderByAsc(Dish::getUpdate_time);
        dishService.page(pageInfo, dishLambdaQueryWrapper);
        return R.success(pageInfo);
    }

    @ApiParam("菜品页菜品停止和开启")
    @PostMapping("/dish/status/{status}")
    R<String> haltSale(@PathVariable("status") Integer status, Long ids) {
        log.info("菜品页菜品停止和开启 status:{}，ids：{}", status, ids);
        final Dish dish = new Dish();
        dish.setStatus(status);
        dish.setId(ids);
        dishService.updateById(dish);
        return R.success("状态改变成功");
    }

    @ApiParam("菜品页菜品删除")
    @DeleteMapping("/dish")
    R<String> deleteDish(Long ids) {
        dishService.removeById(ids);
        return R.success("删除成功");
    }

    @ApiParam("展现添加菜品中的菜品分类")
    @GetMapping("/category/list")
    R<List<Category>> listCategory(Integer type){
        log.info("展现添加菜品中的菜品分类::{}",type);
        final LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getType,type);
        final List<Category> list = categoryService.list(categoryLambdaQueryWrapper);
        return R.success(list);
    }

    @ApiParam("添加菜品")
    @PostMapping("/dish")
    R<String> dishAdd(@RequestBody DishDTO dishDTO){
        log.info("dishdto info:{}",dishDTO.toString());
        dishDTOServiceImp.saveWithFlavors(dishDTO);
        return R.success("添加成功");
    }

}
