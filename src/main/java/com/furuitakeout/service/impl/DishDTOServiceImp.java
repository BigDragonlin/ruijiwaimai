package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.dto.DishDTO;
import com.furuitakeout.mapper.DishDTOMapper;
import com.furuitakeout.service.DishDTOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DishDTOServiceImp extends ServiceImpl<DishDTOMapper, DishDTO>
        implements DishDTOService {

    @Autowired
    DishFlavorServiceImpl dishFlavorService;

    @Override
    @Transactional
    public void saveWithFlavors(DishDTO dishDTO) {
        log.info("存dto+{}",dishDTO.toString());
        this.save(dishDTO);
        final List<DishFlavor> flavors = dishDTO.getFlavors();
        final Long categoryID = dishDTO.getId();
        for (DishFlavor dishFlavor:flavors
             ) {
            dishFlavor.setDish_id(categoryID);
            dishFlavorService.save(dishFlavor);
            log.info("存dishFlavor+{}",dishFlavor.toString());
        }
    }
}
