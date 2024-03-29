package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.domain.AddressBook;
import com.furuitakeout.service.AddressBookService;
import com.furuitakeout.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2022-10-22 04:11:02
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




