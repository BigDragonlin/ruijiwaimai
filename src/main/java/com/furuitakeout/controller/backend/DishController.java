package com.furuitakeout.controller.backend;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.furuitakeout.common.R;
import com.furuitakeout.domain.Category;
import com.furuitakeout.domain.Dish;
import com.furuitakeout.domain.DishFlavor;
import com.furuitakeout.dto.DishDto;
import com.furuitakeout.mapper.DishDtoMapper;
import com.furuitakeout.service.impl.CategoryServiceImpl;
import com.furuitakeout.service.impl.DishDtoServiceImp;
import com.furuitakeout.service.impl.DishFlavorServiceImpl;
import com.furuitakeout.service.impl.DishServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api("菜品管理")
@Slf4j
public class DishController {

    @Autowired
    DishServiceImpl dishService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    DishFlavorServiceImpl dishFlavorService;

    @Autowired
    DishDtoServiceImp dishDtoServiceImp;

    @GetMapping("/dish/page")
    @ApiParam("展示菜品页")
    R<Page> pageShow(Integer page, Integer pageSize) {
        //一步完成太麻烦
        final Page<Dish> pageInfo = new Page<Dish>(page, pageSize);
        final Page<DishDto> dishDtoPage = new Page();
        final LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.orderByDesc(Dish::getUpdateTime);
        dishService.page(pageInfo, dishLambdaQueryWrapper);
        //获取到page的数据，我们使用getRecords（）方法，获取分页数据的列表
        final List<Dish> records = pageInfo.getRecords();
        //我们获取dish的 records，将dish record的属性copy到dishDto上面去

        List<DishDto> dishDtoRecord = records.stream().map((item) -> {
            final Long categoryId = item.getCategoryId();
            final Category category = categoryService.getById(categoryId);
            final DishDto dishDto = new DishDto();
            dishDto.setCategoryName(category.getName());

            BeanUtils.copyProperties(item, dishDto);
            return dishDto;
//          Collectors.toList()难点.对流进行收集，变量填写返回值
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(dishDtoRecord);
        //将除了record属性外的所有属性都拷贝到新的dishDto Page中去
        BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");

        return R.success(dishDtoPage);
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
    R<List<Category>> listCategory(Integer type) {
        log.info("展现添加菜品中的菜品分类::{}", type);
        final LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getType, type).orderByAsc(Category::getUpdateTime);
        final List<Category> list = categoryService.list(categoryLambdaQueryWrapper);
        return R.success(list);
    }

    @ApiParam("添加菜品")
    @PostMapping("/dish")
    R<String> dishAdd(@RequestBody DishDto dishDTO) {
        log.info("dishdto info:{}", dishDTO.toString());
        dishService.saveWithFlavors(dishDTO);
        return R.success("添加成功");
    }

    @ApiParam("修改菜品")
    @PutMapping("/dish")
    R<String> dishUpdate(@RequestBody DishDto dishDTO) {
        log.info("dishdto info:{}", dishDTO.toString());
        dishService.updateWithFlavors(dishDTO);
        return R.success("修改成功");
    }

    @ApiParam("修改菜品页的回显")
    @GetMapping("/dish/{id}")
    R<DishDto> dishUpdate(@PathVariable("id") Long id){
        final Dish dish = dishService.getById(id);

        final Long categoryId = dish.getCategoryId();
        final Category category = categoryService.getById(categoryId);
        final String categoryName = category.getName();

        final LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId,id);
        final List<DishFlavor> dishFlavorList = dishFlavorService.list(dishFlavorLambdaQueryWrapper);

        final DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

        dishDto.setFlavors(dishFlavorList);
        dishDto.setCategoryName(categoryName);

        log.info("修改回显菜品的dishDto：{}",dishDto.toString());
        return R.success(dishDto);
    }

}
