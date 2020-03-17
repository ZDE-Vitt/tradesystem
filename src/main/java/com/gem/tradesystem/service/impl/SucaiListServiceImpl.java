package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.mapper.DictMapper;
import com.gem.tradesystem.mapper.SucaiMapper;
import com.gem.tradesystem.mapper.TagMapper;
import com.gem.tradesystem.service.SucaiListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/11 22:21
 * @Description:
 */
@Service
public class SucaiListServiceImpl implements SucaiListService {

    @Autowired
    private SucaiMapper sucaiMapper;

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Page<Sucai> selectList(Integer curr, Integer limit, Integer status, Integer userid) {
        Page<Sucai> page = new Page<>(curr,limit);

        QueryWrapper<Sucai> wrapper = new QueryWrapper<>();
        wrapper.eq("status",status);
        wrapper.eq("userid",userid);
        wrapper.orderByDesc("createtime");

        page = sucaiMapper.selectPage(page,wrapper);

        for (Sucai sucai:page.getRecords()) {

            sucai.setFormatTime(new SimpleDateFormat("yyyy年MM月dd日").format(sucai.getCreatetime()));

            if (sucai.getStatus() == 1){
                sucai.setStatusname("审核中");
            }
            if (sucai.getStatus() == 2){
                sucai.setStatusname("审核未通过");
            }
            if (sucai.getStatus() == 3){
                sucai.setStatusname("审核通过");
            }
        }

        return page;
    }

    @Override
    public Integer sucaiupload(Sucai sucai,String tagname, String width, String heigth , HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        sucai.setNum(new SimpleDateFormat("yyMMddHHmm").format(new Date()));
        sucai.setSize(width + "X" + heigth);
        sucai.setCreatetime(new Date());
        sucai.setAuthor(user.getUsername());
        sucai.setUserid(user.getId());
        sucai.setStatus(1);
        sucai.setTagid(tagMapper.getid(tagname));

        int index = sucai.getSave().lastIndexOf('.');
        sucai.setSuffix(sucai.getSave().substring(index+1,sucai.getSave().length()));

        Integer row = sucaiMapper.insert(sucai);

        QueryWrapper<Sucai> wrapper = new QueryWrapper<>();
        wrapper.eq("num",sucai.getNum());
        wrapper.eq("name",sucai.getName());

        Sucai sucaiid = sucaiMapper.selectOne(wrapper);

        tagMapper.addInJb(sucaiid.getId(), sucai.getTagid());

        return row;
    }

    @Override
    public Integer shenHeNum(Integer userid) {
        QueryWrapper<Sucai> wrapper = new QueryWrapper<>();
        wrapper.eq("status" , 1);
        wrapper.eq("userid",userid);
        return sucaiMapper.selectCount(wrapper);
    }

    @Override
    public Integer passNum(Integer userid) {
        QueryWrapper<Sucai> wrapper = new QueryWrapper<>();
        wrapper.eq("status" , 2);
        wrapper.eq("userid",userid);
        return sucaiMapper.selectCount(wrapper);
    }

    @Override
    public Integer inpassNum(Integer userid) {
        QueryWrapper<Sucai> wrapper = new QueryWrapper<>();
        wrapper.eq("status" , 3);
        wrapper.eq("userid",userid);
        return sucaiMapper.selectCount(wrapper);
    }

    @Override
    public Map<String, Integer> getNum(Integer userid) {
        QueryWrapper<Sucai> shenhewrapper = new QueryWrapper<>();
        shenhewrapper.eq("status" , 1);
        shenhewrapper.eq("userid",userid);
        Integer sHNum = sucaiMapper.selectCount(shenhewrapper);

        QueryWrapper<Sucai> inpassWrapper = new QueryWrapper<>();
        inpassWrapper.eq("status" , 2);
        inpassWrapper.eq("userid",userid);
        Integer inpNum = sucaiMapper.selectCount(inpassWrapper);

        QueryWrapper<Sucai> passWrapper = new QueryWrapper<>();
        passWrapper.eq("status" , 3);
        passWrapper.eq("userid",userid);
        Integer pNum = sucaiMapper.selectCount(passWrapper);


        Map<String , Integer> num = new HashMap<>();
        num.put("shenhenum",sHNum);
        num.put("inpassnum",inpNum);
        num.put("passnum",pNum);

        return num;
    }

    @Override
    public Integer deleteOne(Integer id) {
        return sucaiMapper.deleteById(id);
    }
}
