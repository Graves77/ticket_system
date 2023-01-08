package com.demo.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.member.entity.UserEntity;

import java.util.Map;

/**
 * 
 *
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:53:35
 */
public interface UserService extends IService<UserEntity> {

    Boolean login(UserEntity user);

    Integer selectByPhone(String phone);

    PageUtils queryPage(Map<String, Object> params);
}

