package com.demo.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.order.entity.OrderEntity;

import java.util.Map;

/**
 * 
 *
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:58:47
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void buy_ticket(OrderEntity order);
}

