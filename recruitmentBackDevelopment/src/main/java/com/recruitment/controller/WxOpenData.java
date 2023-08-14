package com.recruitment.controller;

import com.github.kevinsawicki.http.HttpRequest;

import com.recruitment.config.WxMiniConfig;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(value = "/WxOpenData")
public class WxOpenData {
    /**
     * 利用临时ID 从微信平台获取 OpenId 和 头像地址 返回给前端
     */
    @GetMapping("/{js_code}")
    public String getWxOpenData(@PathVariable String js_code){
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", WxMiniConfig.AppId);
        data.put("secret", WxMiniConfig.AppSecret);
        data.put("js_code", js_code);
        data.put("grant_type", "authorization_code");

        String response = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(data).body();

        //JSONObject obj= JSON.parseObject(response);//将json字符串转换为json对
        return response.toString();
    }

}
