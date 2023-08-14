package com.recruitment.controller;

import com.github.kevinsawicki.http.HttpRequest;
import com.recruitment.config.GaoDeMapConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/GaoDeMap")

public class GaoDeMap {
    /**
     * 地理编码 根据地址 获得 经纬度
     */
    @GetMapping("/geographicalDecode/{address}")
    public Result geographicalDecode(@PathVariable String address) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("key", GaoDeMapConfig.key);
//        data.put("jscode", GaoDeMapConfig.JsCode);
        data.put("output", GaoDeMapConfig.ReturnDataType);
        data.put("address", address);//国家、省份、城市、区县、城镇、乡村、街道、门牌号码、屋邨、大厦
        String response = HttpRequest.get("https://restapi.amap.com/v3/geocode/geo").form(data).body();
//        return response.toString();

        JSONObject outData = null;
//        try {
//            JSONObject rootObject = new JSONObject(response);//将json字符串转换为json对
////        根据机构进行转换
//            JSONArray  geocodesArray = rootObject.getJSONArray("geocodes");
//            JSONObject sonObject  =geocodesArray.getJSONObject(0);
//            String locationDecode = sonObject.getString("location");
////        将结果放在json里
//            outData = new JSONObject();
//            outData.put("locationDecode",locationDecode);
//            return outData.toString();
//        } catch (JSONException e) {
//            return  Code.geographicalDecode_err_msg;
//        }

//        返回data为字符串 暂时不用
        try {
            JSONObject rootObject = new JSONObject(response);//将json字符串转换为json对
//        根据机构进行转换
            JSONArray geocodesArray = rootObject.getJSONArray("geocodes");
            JSONObject sonObject = geocodesArray.getJSONObject(0);
            String locationDecode = sonObject.getString("location");
//        将结果放在json里
            outData = new JSONObject();
            outData.put("locationDecode", locationDecode);
            return new Result(Code.geographicalDecode_ok, locationDecode, Code.geographicalDecode_ok_msg);
        } catch (JSONException e) {
            return new Result(Code.geographicalDecode_err, false, Code.geographicalDecode_err_msg);
        }


    }

    /**
     * 逆地理编码 根据经纬度 获得 地址
     */
    @GetMapping("/inverseGeographicalDecode/{addressDecode}")
    public Result inverseGeographicalDecode(@PathVariable String addressDecode) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("key", GaoDeMapConfig.key);
////        data.put("jscode", GaoDeMapConfig.JsCode);
//        data.put("output", GaoDeMapConfig.ReturnDataType);
        data.put("location", addressDecode);//经纬度
        String response = HttpRequest.get("https://restapi.amap.com/v3/geocode/regeo").form(data).body();
        JSONObject outData = null;
        try {
            JSONObject rootObject = new JSONObject(response);//将json字符串转换为json对
//            System.out.println(rootObject);
//        根据结构进行转换
            JSONObject regeocode = rootObject.getJSONObject("regeocode");
//            System.out.println(regeocode);
            String address = regeocode.getString("formatted_address");
//            System.out.println(address);
//            JSONArray geocodesArray = rootObject.getJSONArray("geocodes");
//            JSONObject sonObject = geocodesArray.getJSONObject(0);
//            String address = rootObject.getString("formatted_address");
//        将结果放在json里
            outData = new JSONObject();
            outData.put("address", address);
            return new Result(Code.inverseGeographicalDecode_ok, address, Code.inverseGeographicalDecode_ok_msg);
        } catch (JSONException e) {
            return new Result(Code.inverseGeographicalDecode_err, false, Code.inverseGeographicalDecode_err_msg);
        }
//        return response;


    }
}