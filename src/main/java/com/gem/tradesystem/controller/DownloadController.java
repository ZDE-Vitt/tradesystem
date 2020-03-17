package com.gem.tradesystem.controller;

import com.gem.tradesystem.config.DownloadProperties;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.service.SucaiService;
import com.qiniu.util.Auth;
import com.qiniu.util.UrlSafeBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class DownloadController {
    @Autowired
    private SucaiService sucaiService;

    @Autowired
    private DownloadProperties downloadProperties;

    @RequestMapping("/download")
    public String download(Model model, HttpServletRequest request){
        String sid=request.getParameter("id");
        Integer id=Integer.parseInt(sid);
        Sucai sucai=sucaiService.getOneById(id);
        model.addAttribute("sucai",sucai);
        return "down_jifenbuzu_yuezu";
    }

    @RequestMapping("/addDownNum")
    @ResponseBody
    public Sucai addDownNum(Model model, HttpServletRequest request){
        String sid=request.getParameter("sid");
        Integer s_id=Integer.parseInt(sid);
        String uid=request.getParameter("uid");
        Integer u_id=Integer.parseInt(uid);
        Integer i=sucaiService.insertOneDownload(s_id,u_id);
        int j=sucaiService.updateDown(s_id);
        Sucai sucai=sucaiService.getOneById(s_id);
        return sucai;
    }


    @RequestMapping("/isPay")
    @ResponseBody
    public Integer isPay(Model model, HttpServletRequest request){
        String sid=request.getParameter("sid");
        Integer s_id=Integer.parseInt(sid);
        String uid=request.getParameter("uid");
        Integer u_id=Integer.parseInt(uid);
        Integer i=sucaiService.getOneDownload(s_id,u_id);
        return i;
    }

    @RequestMapping("/getDownUrl")
    @ResponseBody
    public String getDownUrl(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        String sid=request.getParameter("sid");
        Integer s_id=Integer.parseInt(sid);
        Sucai sucai=sucaiService.getOneById(s_id);
        String url=URLEncoder.encode(sucai.getSave(),"utf-8");

        String[] suffix=url.split("\\.");
        String attname= URLEncoder.encode(sucai.getName(),"utf-8").replace("+","%20");
//        url=UrlSafeBase64.encodeToString(url);

        String domain=downloadProperties.getDomain();
        String accesskey= downloadProperties.getAccessKey();
        String secretkey= downloadProperties.getSecretKey();

        url=domain+"/"+url+"?attname="+attname+"."+suffix[1];//
//        url=domain+"/"+url;//使用异步方式时
//        url=UrlSafeBase64.encodeToString(url);
        long expire=60L;//过期时间，秒数
//        String baseurl=domain+"/小兰.jpg?attname=124.jpg";
        Auth auth = Auth.create(accesskey, secretkey);
        String f_url=auth.privateDownloadUrl(url,expire);
        System.out.println(f_url);

 //        sucai.setSave(url);

        return f_url;
    }

//    @RequestMapping("/getDownUrl")
//    @ResponseBody
//    public String getDownUrl(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
//        String sid=request.getParameter("sid");
//        Integer s_id=Integer.parseInt(sid);
//        Sucai sucai=sucaiService.getOneById(s_id);
////        String url=URLEncoder.encode(sucai.getSave(),"utf-8");
//        String url=sucai.getSave();
//
//
////        String[] suffix=url.split("\\.");
//        String attname= URLEncoder.encode(sucai.getName(),"utf-8").replace("+","%20");
////        url=UrlSafeBase64.encodeToString(url);
//
////        String domain=downloadProperties.getDomain();
////        String accesskey= downloadProperties.getAccessKey();
////        String secretkey= downloadProperties.getSecretKey();
//
////        url=domain+"/"+url+"?attname="+attname+"."+sucai.getSuffix();//
//        url=url+"?attname="+attname+"."+sucai.getSuffix();//
////        url=domain+"/"+url;//使用异步方式时
////        url=UrlSafeBase64.encodeToString(url);
////        long expire=60L;//过期时间，秒数
////        String baseurl=domain+"/小兰.jpg?attname=124.jpg";
////        Auth auth = Auth.create(accesskey, secretkey);
////        String f_url=auth.privateDownloadUrl(url,expire);
//        System.out.println(url);
//
//        //        sucai.setSave(url);
//
//        return url;
//    }


}
