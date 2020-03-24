package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.SucaiService;
import com.gem.tradesystem.service.UserSettingService;
import com.gem.tradesystem.utils.SrcUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private SucaiService sucaiService;
    @Autowired
    private SrcUrl srcUrl;
    @Autowired
    private UserSettingService userSettingService;

    @RequestMapping("/detail")
    public String detail(Integer id,HttpServletRequest request,Model model,HttpSession session) throws UnsupportedEncodingException {
//        String sid=request.getParameter("id");
        User user = new User();
        User sucaiuser = new User();
        Sucai sucai = new Sucai();
        String menuName=request.getParameter("menu");
        String submenuName=request.getParameter("submenu");
        if(menuName!=null&&!("".equals(menuName))){
            model.addAttribute("menu",menuName);
        }
        if(submenuName!=null&&!("".equals(submenuName))){
            model.addAttribute("submenu",submenuName);
        }

        if(id!=null){
//            Integer id=Integer.parseInt(sid);
            sucai=sucaiService.getOneById(id);

            //用户不做修改时
            model.addAttribute("save",sucai.getSave());

            String srcurl=srcUrl.getSrcUrl(sucai);//动态拼接数据库中存储的路径后
            sucai.setSave(srcurl);
//            System.out.println(sucai);
            List<String> taglist=sucaiService.getTags(id);

            //已登录用户的收藏已否
            user= (User) request.getSession().getAttribute("user");

            //获取作者信息
            sucaiuser = userSettingService.selectUserById(sucai.getUserid());

            if(user!=null){
                Integer uid=user.getId();
                List<Integer> user_favlist =sucaiService.getUserFavList(uid);
                model.addAttribute("favlist",user_favlist);
                //已登录的用户的购物车
                List<Integer> user_shopcar=sucaiService.getUserShoppingCar(uid);
                model.addAttribute("shopcar",user_shopcar);
            }
            model.addAttribute("sucai",sucai);
            model.addAttribute("taglist",taglist);
            model.addAttribute("user",sucaiuser);

        }

        if(null != user){
            if (user.getId() == sucai.getUserid()){
                List<String> subtag= sucaiService.getAllSubMenu();
                model.addAttribute("tags",subtag);
                return "pro_edit";
            }else return "pro_detail";
        }else {
            return "pro_detail";
        }
    }

    @RequestMapping("/list")//显示pro_list.html
    public String list(Integer curr, HttpServletRequest request, Model model,HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException {
        //页码
        Integer current=1;
        if(curr!=null)
        current=curr;

        Integer pageSize=10;//每页显示数目
        Integer index=(current-1)*pageSize;

        Integer count=sucaiService.getCount();//默认显示所有素材，总数

        List<String> menus= sucaiService.getMenu();
        List<String> submenu=sucaiService.getAllSubMenu();

        List<Sucai> list=sucaiService.getPageList(index,pageSize);//获取显示列表

        String menu=request.getParameter("menu");
        if(menu!=null&&!("".equals(menu))){
            if("全部".equals(menu)){
                //所有素材都显示
            }else{//否则显示相应的menu下的素材
                submenu=sucaiService.getSubMenu(menu);
                count=sucaiService.getMenuCount(menu);
                list=sucaiService.getMenuPageList(menu,index,pageSize);
            }
            model.addAttribute("menu_active",menu);
        }else{
            model.addAttribute("menu_active","全部");
        }

        String submenuname=request.getParameter("submenu");
        System.out.println(submenuname);
        if(submenuname!=null&&!("".equals(submenuname))){
            list=sucaiService.getSubMenuPageList(submenuname,index,pageSize);
            list.forEach(System.out::println);
            count=sucaiService.getSubMenuCount(submenuname);
            System.out.println(count);
            model.addAttribute("submenu_active",submenuname);
        }

        //搜索结果
        String search=request.getParameter("search");

        if(search!=null&&!("".equals(search))){
            search=search.replaceAll("\\s+", "");
            list=sucaiService.getSearchPageList(search,index,pageSize);
            System.out.println("search=======>"+search);
            count=sucaiService.getSearchCount(search);
            if(count==0)
                model.addAttribute("seachTip","暂无查询结果！");
        }
        System.out.println(count);
        Integer pageNum=((count-1)/pageSize)+1;//总页数
        if(count==0)
            model.addAttribute("seachTip","暂无该类型的素材！");

        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已登录用户的收藏已否
            Integer uid=user.getId();
            List<Integer> user_favlist =sucaiService.getUserFavList(uid);
            model.addAttribute("favlist",user_favlist);
            //已登录的用户的购物车
            List<Integer> user_shopcar=sucaiService.getUserShoppingCar(uid);
            model.addAttribute("shopcar",user_shopcar);
        }

        for(Sucai s:list){
            String srcurl=srcUrl.getSrcUrl(s);//动态拼接数据库中存储的路径后
            s.setSave(srcurl);
        }


        model.addAttribute("menus",menus);
        model.addAttribute("submenus",submenu);
        model.addAttribute("list",list);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("curr",current);
        model.addAttribute("total",count);
        model.addAttribute("search",search);


//        Cookie cookie=new Cookie("downloadToken",downloadToken);

//        System.out.println("pageNum"+pageNum);
//        System.out.println("pageSize"+pageSize);
//        System.out.println("current"+current);
//        System.out.println("total"+count);
//        System.out.println("current"+current);

        //尝试进行点赞操作，暂时写死用户
//        if(session.getAttribute("user")==null)
//        {
//            User user=new User();
//            user.setUsername("xzz");
//            session.setAttribute("user",user);
//        }
//        else{
//            System.out.println(session.getAttribute("user"));
//        }


        return "pro_list";
    }

    @RequestMapping("/taglist")//处理异步请求获取素材的标签
    @ResponseBody
    public List<String> taglist(HttpServletRequest request){
        String sid=request.getParameter("sid");
        Integer id=Integer.parseInt(sid);
        List<String> taglist= sucaiService.getTags(id);
        return taglist;
    }

    @RequestMapping("/fav/addfav")//处理点赞
    @ResponseBody
    public Sucai addfav(HttpSession session, HttpServletRequest request) throws IOException {
        System.out.println("进入了controller");
        Integer sid=Integer.parseInt(request.getParameter("sid"));
        User user= (User) session.getAttribute("user");
        //用户未登录
        if(user==null){
            return null;
        }
        else{
            Integer uid=user.getId();
            String favflag=request.getParameter("fav");
            if("true".equals(favflag)){
                //要取消点赞
                sucaiService.updateDelFav(sid);
                sucaiService.deleteOneFav(sid,uid);
            }else{
                //进行点赞
                sucaiService.updateFav(sid);
                sucaiService.insertOneFav(sid,uid);
            }
            Sucai sucai=sucaiService.getOneById(sid);
            return sucai;
        }
    }


//    @RequestMapping("/sublist")
//    @ResponseBody
//    public List<String> sublist(HttpServletRequest request,Model model){
////        List<String> menus= sucaiService.getMenu();
//        List<String> submenu=sucaiService.getAllSubMenu();
//        System.out.println(request.getParameter("menu"));
//        if(request.getParameter("menu")!=null&&!("".equals(request.getParameter("menu")))){
//            if("全部".equals(request.getParameter("menu"))){
//                submenu= sucaiService.getAllSubMenu();
//                List<Sucai> list=sucaiService.getList();
//                model.addAttribute("list",list);
//            }else{
//                submenu=sucaiService.getSubMenu(request.getParameter("menu"));
//                List<Sucai> list=sucaiService.getMenuList(request.getParameter("menu"));
//                model.addAttribute("list",list);
//            }
//        }
//        return submenu;
//    }


}
