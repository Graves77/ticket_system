package com.demo.member.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.demo.common.exception.BizCodeEnum;
import com.demo.member.utils.JwtUtils;
import com.demo.member.valid.loginGroup;
import com.demo.member.valid.registerGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.demo.member.entity.UserEntity;
import com.demo.member.service.UserService;
import com.demo.common.utils.PageUtils;
import com.demo.common.utils.R;



/**
 * 
 *
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:53:35
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping("/test")
    public R test(){
        return R.ok("测试成功");
    }


    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public R login(@Validated({loginGroup.class})@RequestBody UserEntity user){

        if(userService.login(user)){
            //用户登录
            //生成token
            String token = jwtUtils.generateToken(user.getPhone());
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("expire", jwtUtils.getExpire());
            return R.ok(map);
        }
        else return R.error(BizCodeEnum.LOGIN_ACCOUNT_PASSWORD_INVALID.getCode(),BizCodeEnum.LOGIN_ACCOUNT_PASSWORD_INVALID.getMsg());
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public R register(@Validated({registerGroup.class}) @RequestBody UserEntity user){
        Integer exit = userService.selectByPhone(user.getPhone());
        if(exit!=null){
            return R.error(BizCodeEnum.PHONE_EXISTS_EXCEPTION.getCode(), BizCodeEnum.PHONE_EXISTS_EXCEPTION.getMsg());
        }
        else
        {
            user.setStatus(0);
            userService.save(user);
            return R.ok("注册成功");
        }

    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:user:info")
    public R info(@PathVariable("id") Integer id){
		UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:user:update")
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:user:delete")
    public R delete(@RequestBody Integer[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
