package com.recruitment.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@Service
public class OssService {
    /**
     * 实现上传功能
     *
     * @param multipartFile：上传的文佳
     * @param dir:上传的             根目录 在controller写死
     * @return : fail or fileUrl
     */
    public String upLoadFile(MultipartFile multipartFile, String dir) {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tPGn7K9s5MK67HRc6Tm";
        String accessKeySecret = "ixdUwJidLUrohbl22W9CCAYwRBanOV";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "wen-second";

        // 创建OSSClient实例。
        OSS ossClient;
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
//            1. 获取文件上传的流
            InputStream inputStream = multipartFile.getInputStream();//云端上传适用
//            InputStream inputStream = Files.newInputStream(multipartFile.toPath());//本地上传适用

//            2.创建日期目录
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String dataPath = simpleDateFormat.format(new Date());
//            3.获取文件名字
            String originalFilename = multipartFile.getOriginalFilename();//文件原始名字云端上传适用
//            String originalFilename = multipartFile.getName();//文件原始名字云端上传适用
            String fileName = UUID.randomUUID().toString();
            assert originalFilename != null;
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newName = fileName + substring;
//            4.文件路径
            String fileUrl = dir + "/" + dataPath + "/" + newName;

//            5.文件上传到 阿里云服务器
            ossClient.putObject(bucketName, fileUrl, inputStream);
//            6.返回文件存储路径
            return "https://" + bucketName + "." + endpoint + "/" + fileUrl;
//        } catch (OSSException oe)
        } catch (OSSException | IOException oe) {
//            System.out.println("Caught an OSSException, which means your request made it to OSS, "
//                    + "but was rejected with an error response for some reason.");
//            System.out.println("Error Message:" + oe.getErrorMessage());
//            System.out.println("Error Code:" + oe.getErrorCode());
//            System.out.println("Request ID:" + oe.getRequestId());
//            System.out.println("Host ID:" + oe.getHostId());
            return "fail";
//        } catch (ClientException ce) {
//            System.out.println("Caught an ClientException, which means the client encountered "
//                    + "a serious internal problem while trying to communicate with OSS, "
//                    + "such as not being able to access the network.");
//            System.out.println("Error Message:" + ce.getMessage());
//            return "fail";
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 文件下载功能 暂时未能实现
     * @param url
     * @return
     */
//    public String downloadFile (String url){
//        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
//        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = "LTAI5tPGn7K9s5MK67HRc6Tm";
//        String accessKeySecret = "ixdUwJidLUrohbl22W9CCAYwRBanOV";
//        // 填写Bucket名称，例如examplebucket。
//        String bucketName = "wen-second";
//        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
//        String objectName = url;
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        try {
//            // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
//            OSSObject ossObject = ossClient.getObject(bucketName, objectName);
//            // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
//            InputStream content = ossObject.getObjectContent();
//            if (content != null) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//                while (true) {
//                    String line = reader.readLine();
//                    if (line == null) break;
//                    System.out.println("\n" + line);
//                }
//                // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
//                content.close();
//            }
//            return "该功能尚未完成";//
//        } catch (OSSException | ClientException | IOException e) {
//            return "fail";
//            System.out.println("Caught an OSSException, which means your request made it to OSS, "
//                    + "but was rejected with an error response for some reason.");
//            System.out.println("Error Message:" + oe.getErrorMessage());
//            System.out.println("Error Code:" + oe.getErrorCode());
//            System.out.println("Request ID:" + oe.getRequestId());
//            System.out.println("Host ID:" + oe.getHostId());
//        } catch (ClientException | IOException ce) {
//            System.out.println("Caught an ClientException, which means the client encountered "
//                    + "a serious internal problem while trying to communicate with OSS, "
//                    + "such as not being able to access the network.");
//            System.out.println("Error Message:" + ce.getMessage());
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//        }
//    }
}


