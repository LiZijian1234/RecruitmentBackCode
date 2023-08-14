package com.recruitment.controller;

import com.recruitment.service.impl.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping(value = "/OSSOpration", consumes = "multipart/form-data")
public class OSSOperationController {
    @Autowired
    private OssService ossService;
/**
 * 实现 图片 上传功能 暂时不用太费劲了
 */
//    @PostMapping(value = "/upload/img")
////@PostMapping
//    public Result upLoadImgFile(@RequestParam("file") MultipartFile[] multipartFile)  {
////        if( multipartFile.isEmpty()) {
////            return new Result(Code.isEmpty, false, Code.isEmpty_msg);
////        }
//        Object res = ossService.upLoadFile(multipartFile,"img");
//        if (res.equals("fail")) {
//            return new Result(Code.upLoadImgFile_err, res, Code.upLoadImgFile_err_msg);
//        } else {
//            return new Result(Code.upLoadImgFile_ok, res, Code.upLoadImgFile_ok_msg);
//        }
//
//    }
    /**
     * 实现 文件 上传功能
     */
    @PostMapping(value = "/upload/file")
//@PostMapping
    public Result upLoadFile( @RequestParam("files") MultipartFile[] multipartFileArrary)  {
//        if( multipartFile.isEmpty()) {
//            return new Result(Code.isEmpty, false, Code.isEmpty_msg);
//        }
        String[] uploadResult =new String[multipartFileArrary.length];
        for (int i = 0; i < multipartFileArrary.length; i++) {
            Object res = ossService.upLoadFile(multipartFileArrary[i],"file");// dir 是OSS bucket 中根目录名称
            if (res.equals("fail")) {
                uploadResult[i]= Code.upLoadFile_err_msg;
//                return new Result(Code.upLoadFile_err, res, Code.upLoadFile_err_msg);
            } else {
                uploadResult[i]= (String) res;
//                return new Result(Code.upLoadFile_ok, res, Code.upLoadFile_ok_msg);
            }
        }
        return new Result(Code.upLoadFile_ok, uploadResult, Code.upLoadFile_ok_msg);


    }
}
