package com.demo.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:58:47
 */
@Data
@TableName("order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * member id

	 */
	private Integer memberId;
	/**
	 * 订单号
	 */
	private String orderSn;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 收货人电话
	 */
	private String receiverPhone;
	/**
	 * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
	 */
	private Integer status;
	/**
	 * 删除状态【0->未删除；1->已删除】
	 */
	private Integer deleteStatus;
	/**
	 * 车次名
	 */
	private String productNumber;

}
