package com.furuitakeout.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.furuitakeout.common.R;
import com.furuitakeout.domain.AddressBook;
import com.furuitakeout.domain.ShoppingCart;
import com.furuitakeout.service.impl.ShoppingCartServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@Api("购物车")
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    ShoppingCartServiceImpl shoppingCartService;

    @ApiOperation("展现购物车")
    @GetMapping("/list")
    R<List<ShoppingCart>> listAddressBook(HttpServletRequest request){
        final Long userID = (Long) request.getSession().getAttribute("userLoginSession");
        final LambdaQueryWrapper<ShoppingCart> shoppingCartLambdaQueryWrapper = new LambdaQueryWrapper<>();
        shoppingCartLambdaQueryWrapper.eq(ShoppingCart::getUserId,userID);
        final List<ShoppingCart> list = shoppingCartService.list(shoppingCartLambdaQueryWrapper);
        return R.success(list);
    }
}
