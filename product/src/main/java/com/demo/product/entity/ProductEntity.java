package com.demo.product.entity;

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
 * @date 2023-01-07 16:01:58
 */
@Data
@TableName("product")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 始发站
	 */
	private String originatingStation;
	/**
	 * 经停站
	 */
	private String stopoverStation;
	/**
	 * 到达站
	 */
	private String arrivalStation;
	/**
	 * 载客容量
	 */
	private Integer passengerCapacity;
	/**
	 * 出发时间
	 */
	private Date startTime;
	/**
	 * 车次(标识码)
	 */
	private String trainNumber;
	/**
	 * 到达时间
	 */
	private Date endTime;
	/**
	 * 删除状态【0->未删除；1->已删除】
	 */
	private Integer deleteStatus;

}
