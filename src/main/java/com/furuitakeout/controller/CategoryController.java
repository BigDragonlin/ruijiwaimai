package com.furuitakeout.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.furuitakeout.common.R;
import com.furuitakeout.domain.Category;
import com.furuitakeout.service.impl.CategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@Api("分类管理")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @ApiParam("添加分类")
    @PostMapping("/category")
    @ResponseBody
    R<String> categorySave(@RequestBody Category category){
        log.info("category save:{}",category.toString());
        categoryService.save(category);
        return R.success("添加成功");
    }

    @ApiParam("显示分类")
    @GetMapping("/category/page")
    @ResponseBody
    public R<Page> categoryShow(@RequestParam Integer pageSize,@RequestParam Integer page){
        final Page<Category> pageInfo = new Page<>(page,pageSize);
        categoryService.page(pageInfo);
        return R.success(pageInfo);
    }


    @ApiParam("删除分类")
    @DeleteMapping("/category")
    @ResponseBody
    public R<String> deleteCategory(Long id){
        log.info("删除分类：{}",id);
        categoryService.remove(id);
        return R.success("删除成功");
    }

    @ApiParam("修改分类")
    @PutMapping("/category")
    @ResponseBody
    R<String> categoryUpdate(@RequestBody Category category){
        log.info("category save:{}",category.toString());
        categoryService.updateById(category);
        return R.success("修改成功");
    }
}
