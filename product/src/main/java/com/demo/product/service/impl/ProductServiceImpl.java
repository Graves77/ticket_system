package com.demo.product.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.utils.PageUtils;
import com.demo.common.utils.Query;

import com.demo.product.dao.ProductDao;
import com.demo.product.entity.ProductEntity;
import com.demo.product.service.ProductService;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductEntity> page = this.page(
                new Query<ProductEntity>().getPage(params),
                new QueryWrapper<ProductEntity>()
        );

        return new PageUtils(page);
    }



    @Override
    public ProductEntity selectBynumber(String trainNumber) {
        return productDao.selectByNum(trainNumber);
    }

    @Override
    public List<ProductEntity> queryByArrival(String arrivalStation) {
//        List<ProductEntity> productEntities =this.baseMapper.selectList(new QueryWrapper<ProductEntity>().
//                eq("arrival_station",arrivalStation));
        List<ProductEntity> productEntities = productDao.queryByAl(arrivalStation);
        return productEntities;
    }

    @Override
    public List<ProductEntity> queryByStart(String StartStation) {
        return productDao.queryStart(StartStation);
    }

    @Override
    public ProductEntity queryByNumber(String train) {
        return productDao.queryByNumber(train);
    }

}