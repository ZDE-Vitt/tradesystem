package com.gem.tradesystem.service.impl;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.SucaiMapper;
import com.gem.tradesystem.service.SucaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucaiServiceImpl implements SucaiService {
    @Autowired
    private SucaiMapper sucaiMapper;

    @Override
    public Sucai getOneById(Integer id) {
        Sucai sucai=sucaiMapper.getOneById(id);
        return sucai;
    }

    @Override
    public Integer getCount() {
        Integer count=sucaiMapper.getCount();
        return count;
    }

    @Override
    public Integer getSubMenuCount(String typename) {
        Integer count=sucaiMapper.getSubMenuCount(typename);
        return count;
    }

    @Override
    public Integer getMenuCount(String typename) {
        Integer count=sucaiMapper.getMenuCount(typename);
        return count;
    }

    @Override
    public List<String> getMenu() {
        List<String> typelist= sucaiMapper.getMenu();
//        typelist.forEach(System.out::println);
        return typelist;
    }

    @Override
    public List<String> getAllSubMenu() {
        List<String> typelist= sucaiMapper.getAllSubMenu();
        return typelist;
    }

    @Override
    public List<Sucai> getList() {
        List<Sucai> list=sucaiMapper.getList();
        return list;
    }

    @Override
    public List<String> getSubMenu(String typename) {
        List<String> typelist= sucaiMapper.getSubMenu(typename);
        return typelist;
    }

    @Override
    public List<Sucai> getSubMenuList(String typename) {
        List<Sucai> slist=sucaiMapper.getSubMenuList(typename);
        return slist;
    }

    @Override
    public List<Sucai> getMenuList(String typename) {
        List<Sucai> slist=sucaiMapper.getMenuList(typename);
        return slist;
    }

    @Override
    public List<Sucai> getPageList(Integer page, Integer size) {
        List<Sucai> slist=sucaiMapper.getPageList(page,size);
        return slist;
    }

    @Override
    public List<Sucai> getSubMenuPageList(String typename, Integer page, Integer size) {
        List<Sucai> slist=sucaiMapper.getSubMenuPageList(typename,page,size);
        return slist;
    }

    @Override
    public List<Sucai> getMenuPageList(String typename, Integer page, Integer size) {
        List<Sucai> slist=sucaiMapper.getMenuPageList(typename,page,size);
        return slist;
    }

    @Override
    public List<String> getTags(Integer sucaiid) {
        List<String> taglist=sucaiMapper.getTags(sucaiid);
        return taglist;
    }

    @Override
    public String getPMenu(String typename) {
        String pMenu=sucaiMapper.getPMenu(typename);
        return pMenu;
    }

    @Override
    public List<Sucai> getSearchList(String search) {
        List<Sucai> slist=sucaiMapper.getSearchList(search);
        return slist;
    }

    @Override
    public Integer getSearchCount(String search) {
        Integer num=sucaiMapper.getSearchCount(search);
        return num;
    }

    @Override
    public List<Sucai> getSearchPageList(String search, Integer page, Integer size) {
        List<Sucai> slist=sucaiMapper.getSearchPageList(search,page,size);
        return slist;
    }

    @Override
    public List<Sucai> getTopSale() {
        List<Sucai> slist=sucaiMapper.getTopSale();
        return slist;
    }

    @Override
    public List<Sucai> getTopFav() {
        List<Sucai> slist=sucaiMapper.getTopFav();
        return slist;
    }

    @Override
    public int updateFav(Integer id) {
        int i=sucaiMapper.updateFav(id);
        return i;
    }

    @Override
    public int insertOneFav(Integer sucaiid, Integer userid) {
        int i=sucaiMapper.insertOneFav(sucaiid,userid);
        return i;
    }

    @Override
    public int updateDelFav(Integer id) {
        int i=sucaiMapper.updateDelFav(id);
        return i;
    }

    @Override
    public int deleteOneFav(Integer sucaiid, Integer userid) {
        int i=sucaiMapper.deleteOneFav(sucaiid,userid);
        return i;
    }

    @Override
    public List<Integer> getUserFavList(Integer userid) {
        List<Integer> sucaiList=sucaiMapper.getUserFavList(userid);
        return sucaiList;
    }

    @Override
    public Integer addToCar(Integer sucaiid, Integer userid) {
        Integer i=sucaiMapper.addToCar(sucaiid,userid);
        return i;
    }

    @Override
    public List<Integer> getUserShoppingCar(Integer id) {
        List<Integer> shoppingcar=sucaiMapper.getUserShoppingCar(id);
        return shoppingcar;
    }

    @Override
    public Integer getDownload(Integer sucaiid, Integer userid) {
        Integer i=sucaiMapper.getDownload(sucaiid,userid);
        return i;
    }

    @Override
    public Integer getOneDownload(Integer sucaiid, Integer userid) {
        Integer i=sucaiMapper.getOneDownload(sucaiid,userid);
        return i;
    }

    @Override
    public Integer insertOneDownload(Integer sucaiid, Integer userid) {
        Integer i=sucaiMapper.insertOneDownload(sucaiid,userid);
        return i;
    }

    @Override
    public int updateDown(Integer id) {
        int i=sucaiMapper.updateDown(id);
        return i;
    }

//    @Override
//    public Sucai getOneSu(Integer id) {
//        Sucai su=sucaiMapper.getOneSu(id);
//        return su;
//    }


}
