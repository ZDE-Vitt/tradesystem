package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.Jifeng;
import com.gem.tradesystem.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Fei Peng
 * @CreateDate: 2020/3/10 16:42
 * @Description:
 */
@Component
public interface JifengMapper {
    @Select("select * from jifeng")
    List<Jifeng> getJifeng();

    @Select("select account from user where id = #{id}")
    int getJifengById(Integer id);

    @Update("update user set account = account + #{jifeng} where id = #{id}")
    boolean updateJifeng(Integer id,Integer jifeng);

}
