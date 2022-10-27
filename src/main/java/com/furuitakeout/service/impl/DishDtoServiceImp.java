package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.domain.Dish;
import com.furuitakeout.dto.DishDto;
import com.furuitakeout.mapper.DishDtoMapper;
import com.furuitakeout.mapper.DishMapper;
import com.furuitakeout.service.DishDtoService;
import com.furuitakeout.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishDtoServiceImp extends ServiceImpl<DishDtoMapper, DishDto>
        implements DishDtoService {
}
