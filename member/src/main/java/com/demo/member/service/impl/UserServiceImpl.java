package com.demo.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.utils.PageUtils;
import com.demo.common.utils.Query;

import com.demo.member.dao.UserDao;
import com.demo.member.entity.UserEntity;
import com.demo.member.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Boolean login(UserEntity user) {
        String phone = user.getPhone();
        String password = user.getPassword();
        String truePassword =userDao.findPassword(phone);
        //User userByPhone = userDao.selectUserByPhone(phone);
        if(password.equals(truePassword)){
            return true;
        }
        else return false;
    }

    @Override
    public Integer selectByPhone(String phone) {
        return userDao.selectUserByPhone(phone);
    }

}