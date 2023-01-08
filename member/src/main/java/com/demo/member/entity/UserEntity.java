package com.demo.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * 
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:53:35
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 0:普通用户  1:管理员
	 */
	private Integer status;

}
