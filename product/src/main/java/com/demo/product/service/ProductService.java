package com.demo.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.product.entity.ProductEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 16:01:58
 */
public interface ProductService extends IService<ProductEntity> {

    PageUtils queryPage(Map<String, Object> params);

    ProductEntity selectBynumber(String trainNumber);


    List<ProductEntity> queryByArrival(String arrivalStation);

    List<ProductEntity> queryByStart(String StartStation);

    ProductEntity queryByNumber(String train);
}

