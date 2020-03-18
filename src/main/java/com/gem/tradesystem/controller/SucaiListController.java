package com.gem.tradesystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.config.DownloadProperties;
import com.gem.tradesystem.config.UploadProperties;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.SucaiListService;
import com.gem.tradesystem.service.UploadFile;
import com.gem.tradesystem.service.impl.UploadFileQiniu;
import com.gem.tradesystem.utils.ImageCensor;
import com.gem.tradesystem.utils.SrcUrl;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/11 23:15
 * @Description:
 */
@Controller
@RequestMapping("/sucailist")
public class SucaiListController {
    @Autowired
    private SucaiListService sucaiListService;
    @Autowired
    UploadProperties uploadProperties;
    @Autowired
    DownloadProperties downloadProperties;
    @Autowired
    private SrcUrl srcUrl;
    @Autowired
    private ImageCensor imageCensor;


    @RequestMapping("/sucaialllist")
    public String sucaialllist() {
        return "user_sucai";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Page<Sucai> sucailist(Integer curr, Integer limit, Integer status, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (null == curr) curr = 1;
        if (null == limit) limit = 5;
        if (null == status) status = 3;

        return sucaiListService.selectList(curr, limit, status, user.getId());
    }

/*    @ResponseBody
    @RequestMapping("/sucaiupload")
    public Integer sucaiupload(Sucai sucai,String biaoqianid ,String biaoqaindiy ,String width,String heigth,HttpServletRequest request){
        Integer row = sucaiListService.sucaiupload(sucai,biaoqianid,biaoqaindiy,width,heigth,request);
        return row;
    }*/

    @ResponseBody
    @RequestMapping("/sucaiupload")
    public Map<String, Integer> sucaiupload(Sucai sucai, String tagname, String width, String heigth, HttpServletRequest request) {

        System.out.println("sucai=================>" + sucai);

        Integer row = sucaiListService.sucaiupload(sucai, tagname, width, heigth, request);
        User user = (User) request.getSession().getAttribute("user");
        Map<String, Integer> map = sucaiListService.getNum(user.getId());
        map.put("row", row);
        return map;
    }

/*    @ResponseBody
    @RequestMapping("/file")
    public Map<String , String> fileUpload(MultipartFile file) {

        UploadFile uploadFile = new UploadFileQiniu(uploadProperties.getQiniu());
        String avatar = uploadFile.uploadFile(file);
        Map<String , String> map = new HashMap<>();
        map.put("url",avatar);
        return map;
    }*/

    @ResponseBody
    @RequestMapping("/file")
    public Map<String, String> fileUpload(MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        String avatar = null;
        String status = "ok";

        //验证预览图
        JSONObject response = imageCensor.imageCensorOne(file);

        if (response.get("conclusionType").toString().equals("1")) {
            UploadFile uploadFile = new UploadFileQiniu(uploadProperties.getQiniu());
            avatar = uploadFile.uploadFile(file);
            map.put("status", status);
            map.put("url", avatar);
        } else {
            status = "error";
            map.put("status", status);
            JSONArray jsonArray = response.getJSONArray("data");
            jsonArray.getJSONObject(0).get("msg");
            map.put("msg", jsonArray.getJSONObject(0).get("msg").toString());
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/file2")
    public Map<String, String> fileUpload2(MultipartFile file) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String avatar = null;
        String d_url = null;
        String status = "ok";

        //验证原图
        JSONObject response = imageCensor.imageCensorOne(file);

        if (response.get("conclusionType").toString().equals("1")) {
            avatar = srcUrl.uploadFile(file);
            d_url = srcUrl.getUrl(avatar);
            map.put("status", status);
            map.put("url", avatar);
            map.put("iurl", d_url);
        } else {
            status = "error";
            map.put("status", status);
            JSONArray jsonArray = response.getJSONArray("data");
            jsonArray.getJSONObject(0).get("msg");
            map.put("msg", jsonArray.getJSONObject(0).get("msg").toString());
        }

        return map;
    }


    @ResponseBody
    @RequestMapping("/getNum")
    public Map<String, Integer> getNum(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return sucaiListService.getNum(user.getId());
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Page<Sucai> deleteone(Integer curr, Integer limit, Integer id, Integer status, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        sucaiListService.deleteOne(id);


        return sucaiListService.selectList(curr, limit, status, user.getId());
    }


}
