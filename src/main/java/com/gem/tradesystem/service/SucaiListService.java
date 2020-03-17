package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/11 22:19
 * @Description:
 */
public interface SucaiListService {

    Page<Sucai> selectList(Integer curr, Integer limit, Integer status, Integer userid);

    Integer sucaiupload(Sucai sucai, String width, String heigth,HttpServletRequest request);

    Integer shenHeNum(Integer userid);

    Integer passNum(Integer userid);

    Integer inpassNum(Integer userid);

    Map<String , Integer> getNum(Integer userid);

    Integer deleteOne(Integer id);
}
