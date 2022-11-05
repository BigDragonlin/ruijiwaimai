package com.furuitakeout.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import java.util.*;
import com.aliyuncs.dysmsapi.model.v20170525.*;

public class AliyunSengMsg {

    public void sendMsg(String yourAccessKeyID,String yourAccessKeySecret,String Phone,String TemplateCode,String TemplateParam,String SignName) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", yourAccessKeyID, yourAccessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(Phone);
        request.setSignName(SignName);
        request.setTemplateCode(TemplateCode);
        request.setTemplateParam(TemplateParam);

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

        }
}
