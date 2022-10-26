package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.service.OrdersService;
import com.furuitakeout.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2022-10-22 04:11:02
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




