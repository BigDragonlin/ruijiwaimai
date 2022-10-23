package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.domain.Category;
import com.furuitakeout.service.CategoryService;
import com.furuitakeout.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
* @createDate 2022-10-22 04:11:02
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




