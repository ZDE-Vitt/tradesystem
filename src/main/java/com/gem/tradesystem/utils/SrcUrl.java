package com.gem.tradesystem.utils;

import com.gem.tradesystem.config.DownloadProperties;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.service.SucaiService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

@Component
public class SrcUrl {
    @Autowired
    private SucaiService sucaiService;

    @Autowired
    private DownloadProperties downloadProperties;

    //获取素材中图片路径
    public String getSrcUrl(Sucai sucai) throws UnsupportedEncodingException {
        String url= URLEncoder.encode(sucai.getSave(),"utf-8");
        String[] suffix=url.split("\\.");
        String attname= URLEncoder.encode(sucai.getName(),"utf-8").replace("+","%20");

        String domain=downloadProperties.getDomain();
        String accesskey= downloadProperties.getAccessKey();
        String secretkey= downloadProperties.getSecretKey();

        url=domain+"/"+url;//baseurl

        long expire=86400L;//过期时间 一天
//        String baseurl=domain+"/小兰.jpg?attname=124.jpg";
        Auth auth = Auth.create(accesskey, secretkey);
        String f_url=auth.privateDownloadUrl(url,expire);

        //        sucai.setSave(url);

        return f_url;
    }

    public String getUrl(String url) throws UnsupportedEncodingException {
        url= URLEncoder.encode(url,"utf-8");
        String[] suffix=url.split("\\.");
//        String attname= URLEncoder.encode(sucai.getName(),"utf-8").replace("+","%20");

        String domain=downloadProperties.getDomain();
        String accesskey= downloadProperties.getAccessKey();
        String secretkey= downloadProperties.getSecretKey();

        url=domain+"/"+url;//baseurl

        long expire=86400L;//过期时间 一天
//        String baseurl=domain+"/小兰.jpg?attname=124.jpg";
        Auth auth = Auth.create(accesskey, secretkey);
        String f_url=auth.privateDownloadUrl(url,expire);

        //        sucai.setSave(url);

        return f_url;
    }


    public String uploadFile(MultipartFile file) throws UnsupportedEncodingException {
        String domain=downloadProperties.getDomain();
        String bucket=downloadProperties.getBucket();
        String accesskey= downloadProperties.getAccessKey();
        String secretkey= downloadProperties.getSecretKey();
        Auth auth = Auth.create(accesskey, secretkey);
//        String localFilePath ="D:\\123.png";
        String upToken=auth.uploadToken(bucket);
        Configuration cfg=new Configuration(Region.region0());
        UploadManager uploadManager=new UploadManager(cfg);
//        String key=null;

        System.out.println(upToken);
        try {
            String originalFilename = file.getOriginalFilename();
            // 文件后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileKey = UUID.randomUUID().toString() + suffix;
            Response response = uploadManager.put(file.getInputStream(), fileKey, upToken, null, null);
//            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
            return fileKey;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        srcUrl.downloadFile();
        return "error";
    }

}
