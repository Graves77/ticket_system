package com.demo.order.dao;

import com.demo.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:58:47
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
