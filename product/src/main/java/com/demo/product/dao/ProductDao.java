package com.demo.product.dao;

import com.demo.product.entity.ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 16:01:58
 */
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
	
}
