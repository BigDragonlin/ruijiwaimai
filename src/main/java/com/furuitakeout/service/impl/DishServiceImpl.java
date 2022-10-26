package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.service.DishService;
import com.furuitakeout.mapper.DishMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2022-10-22 04:11:02
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{

}




