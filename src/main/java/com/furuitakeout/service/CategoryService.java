package com.furuitakeout.service;

import com.furuitakeout.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2022-10-22 04:11:02
*/
public interface CategoryService extends IService<Category> {

    void remove(Long id);
}
