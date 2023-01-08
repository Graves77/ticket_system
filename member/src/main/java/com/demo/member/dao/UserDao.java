package com.demo.member.dao;

import com.demo.member.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * 
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:53:35
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    void save(@Param("password") String password, @Param("email") String email, @Param("phone") String  phone);

    @Select("SELECT `password`  from `user`  where phone=#{phone}")
    String findPassword(@Param("phone") String phone);


    @Select("SELECT 1 FROM `user` WHERE phone=#{phone} LIMIT 1")
    Integer selectUserByPhone(@Param("phone")String phone);


}
