package com.furuitakeout.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.furuitakeout.common.R;
import com.furuitakeout.domain.Dish;
import com.furuitakeout.domain.Setmeal;
import com.furuitakeout.service.impl.SetmealServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("套餐管理")
@Slf4j
public class SetMealController {

    @Autowired
    SetmealServiceImpl setmealService;


    @GetMapping("/setmeal/page")
    @ApiParam("展示套餐页")
    R<Page> pageShow(Integer page, Integer pageSize) {
        final Page<Setmeal> pageInfo = new Page<Setmeal>(page, pageSize);
        log.info("套餐页page:{},pageSize:{}", page, pageSize);
        final LambdaQueryWrapper<Setmeal> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.orderByAsc(Setmeal::getUpdate_time);
        setmealService.page(pageInfo, dishLambdaQueryWrapper);
        return R.success(pageInfo);
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
}
