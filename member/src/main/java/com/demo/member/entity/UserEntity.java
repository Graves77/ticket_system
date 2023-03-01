package com.demo.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.demo.member.valid.loginGroup;
import com.demo.member.valid.registerGroup;
import lombok.Data;
import org.springframework.boot.jackson.JsonComponent;

import javax.validation.constraints.NotBlank;

/**
 * 
 * 
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:53:35
 */
@Data
@TableName("`user`")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空",groups = {registerGroup.class})
	private String name;
	/**
	 * 电话
	 */
	@NotBlank(message = "电话不能为空",groups = {loginGroup.class, registerGroup.class})
	private String phone;
	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空",groups = {loginGroup.class, registerGroup.class})
	private String password;
	/**
	 * 0:普通用户  1:管理员
	 */
	private Integer status;

}
