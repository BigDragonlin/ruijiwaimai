package com.furuitakeout.controller;

import com.furuitakeout.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
@Api("文件的上传和下载")
public class CommonController {

    @Value("${reggie.path}")
    String path;

    @ApiParam("文件的上传")
    @PostMapping("/upload")
    R<String> upload(MultipartFile file){
        //这个file是临时文件，需要转存，否则本次请求后临时文件将会被删除
        //拿到文件的原始名字
        final String originalFilename = file.getOriginalFilename();
        //拿到文件的后缀名字
        final String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //从新组合名字
        String fileName = UUID.randomUUID().toString()+suffix;

        //创建一个目录，看传文件的时候，接受文件的目录在不在；
        final File filePath = new File(path);
        if (!filePath.exists()){
            //如果文件路径不存在。创建文件路径
            filePath.mkdir();
        }

        try {
            //把前端文件进行转存
            file.transferTo(new File(filePath+"\\"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }

    @ApiParam("文件的下载")
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try {
            //输入流，通过输入流读取文件内容  这里的name是前台用户需要下载的文件的文件名
            //new File(basePath + name) 是为了从存储图片的地方获取用户需要的图片对象
            final File file = new File(path + name);
            FileInputStream fileInputStream = new FileInputStream(file);
            //输出流，通过输出流将文件写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();

            //设置写回去的文件类型
            response.setContentType("image/jpeg");

            //定义缓存区，准备读写文件
            int len  = 0 ;
            byte[] buff = new byte[1024];
            while ((len = fileInputStream.read(buff)) != -1){
                outputStream.write(buff,0,len);
                outputStream.flush();
            }
            //关流
            outputStream.close();
            fileInputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
