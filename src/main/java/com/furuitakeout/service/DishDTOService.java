package com.furuitakeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furuitakeout.dto.DishDTO;

public interface DishDTOService extends IService<DishDTO> {
    void saveWithFlavors(DishDTO dishDTO);
}
