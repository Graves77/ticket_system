package com.demo.member.controller;


import com.demo.common.utils.R;
import com.demo.member.entity.ProductEntity;
import com.demo.member.feign.ProductFeignService;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserFeignController {

    @Autowired
    ProductFeignService productFeignService;

    /**
     * 目的地查询
     * @return
     */
    @RequestMapping("/queryArrival")
        public R QueryArrival(@RequestParam("arrivalStation")String arrivalStation){
        List<ProductEntity> productEntities = productFeignService.queryArrival(arrivalStation);
        if(productEntities.size()==0){
            return R.error("查询为空");
        }
        else return R.ok().put("arrivalStations", productEntities);
    }


    @RequestMapping("/usertest")
    public R usertest(){
        return productFeignService.producttest();
    }

    /**
     * 起点查询
     * @return
     */
    @RequestMapping( "/queryStart")
    public R QueryStart(@RequestParam("startstation")String startstation){
        List<ProductEntity> productEntities = productFeignService.queryStart(startstation);
        if(productEntities.size()==0){
            return R.error("查询为空");
        }
        else return R.ok().put("startstations", productEntities);
    }

    /**
     * 车次
     * @return
     */
    @RequestMapping("/queryNumber")
    public R QueryNumber(@RequestParam("trainNumber")String trainNumber){
        ProductEntity product = productFeignService.queryNumber(trainNumber);
        if(product==null){
            return R.error("查询为空");
        }
        else return R.ok().put("productEntity", product);
    }
}
