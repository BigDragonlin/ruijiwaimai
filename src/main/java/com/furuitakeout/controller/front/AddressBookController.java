package com.furuitakeout.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.furuitakeout.common.R;
import com.furuitakeout.domain.AddressBook;
import com.furuitakeout.service.impl.AddressBookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@Api("地址簿")
@RequestMapping("/addressBook")
public class AddressBookController {


    @Autowired
    AddressBookServiceImpl addressBookService;

    @ApiOperation("展现地址篇")
    @GetMapping("/list")
    R<List<AddressBook>> listAddressBook(HttpServletRequest request){
        final Long userID = (Long) request.getSession().getAttribute("userLoginSession");
        final LambdaQueryWrapper<AddressBook> addressBookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        addressBookLambdaQueryWrapper.eq(AddressBook::getUserId,userID);
        final List<AddressBook> list = addressBookService.list(addressBookLambdaQueryWrapper);
        return R.success(list);
    }

    @ApiOperation("设置默认地址")
    @PutMapping("/default")
    R<String> setDefult(@RequestBody AddressBook addressBook){
        final LambdaQueryWrapper<AddressBook> addressBookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        addressBookLambdaQueryWrapper.eq(AddressBook::getIsDefault,1);
        final AddressBook addressBook1 = new AddressBook();
        addressBook1.setIsDefault(0);
        addressBookService.update(addressBook1,addressBookLambdaQueryWrapper);

        final AddressBook book = addressBookService.getById(addressBook.getId());
        book.setIsDefault(1);
        addressBookService.updateById(book);
        return R.success("设置成功");
    }
}
