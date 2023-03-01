package com.demo.order.service.impl;

import com.demo.order.entity.ProductEntity;
import com.demo.order.feign.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.utils.PageUtils;
import com.demo.common.utils.Query;

import com.demo.order.dao.OrderDao;
import com.demo.order.entity.OrderEntity;
import com.demo.order.service.OrderService;

import javax.annotation.Resource;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Autowired
    private ProductService productService;

    @Override
    //@GlobalTransactional
    public void buy_ticket(OrderEntity order)
    {
        orderDao.insert(order);
        ProductEntity product = productService.train_query(order.getProductNumber());
        productService.reduct(product.getId());
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }


}