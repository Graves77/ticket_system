package com.demo.product.dao;

import com.demo.product.entity.ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 16:01:58
 */
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {

    @Select("select * from `product` where train_number= #{trainNumber}")
    ProductEntity selectByNum(@Param("trainNumber")String trainNumber);

    @Select("select * from `product` where arrival_station=#{arrivalStation}")
    List<ProductEntity> queryByAl(@Param("arrivalStation")String arrivalStation);

    @Select("select * from `product` where train_number=#{Id} limit 1")
    ProductEntity selectBytrainId(@Param("Id")String Id);

    @Select("select * from `product` where originating_station=#{startStation}")
    List<ProductEntity> queryStart(@Param("startStation")String startStation);

    @Select("SELECT * FROM `product` WHERE train_number= #{train}")
    ProductEntity queryByNumber(@Param("train")String train);
}
