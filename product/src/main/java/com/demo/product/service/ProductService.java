package com.demo.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.product.entity.ProductEntity;

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
}

