package com.demo.product.controller;

import com.demo.common.utils.R;
import com.demo.product.dao.ProductDao;
import com.demo.product.entity.ProductEntity;
import com.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/admin/product")
public class UserQueryController {

    @Autowired
    private ProductService productService;

    @Resource
    ProductDao productDao;

    @RequestMapping("/producttest")
    public R  producttest(){
        return  R.ok("测试成功");
    }

    /**
     * 目的地查询
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryArrival")
    public List<ProductEntity> queryArrival(@RequestParam("arrivalStation")String arrivalStation){
        List<ProductEntity> arrivalStations= productService.queryByArrival(arrivalStation);
        return  arrivalStations;
    }

    /**
     * 起点查询
     */
    @RequestMapping("/queryStart")
    public List<ProductEntity> queryStart(@RequestParam("startstation")String startstation){
        List<ProductEntity> StartStations= productService.queryByStart(startstation);
        return StartStations;
    }

    /**
     * 班次查询
     */
    @RequestMapping("/queryNumber")
    public ProductEntity queryNumber(@RequestParam("train")String train){
        ProductEntity product = productService.queryByNumber(train);
        return product;

    }
}
