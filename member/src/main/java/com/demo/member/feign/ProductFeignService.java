package com.demo.member.feign;

import com.demo.common.utils.R;
import com.demo.member.entity.ProductEntity;
import com.demo.member.fallback.ProductFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ticket-product",fallback = ProductFeignServiceFallBack.class)
public interface ProductFeignService {

    /**
     * 终点查询
     * @param arrivalStation
     * @return
     */
    @RequestMapping("/admin/product/queryArrival")
    List<ProductEntity> queryArrival(@RequestParam("arrivalStation")String arrivalStation);

    /**
     * 测试
     * @return
     */
    @RequestMapping("/admin/product/producttest")
    R  producttest();

    /**
     * 起点查询
     */
    @RequestMapping("/admin/product/queryStart")
    List<ProductEntity> queryStart(@RequestParam("startstation")String startstation);

    /**
     * 班次查询
     */
    @RequestMapping("/admin/product/queryNumber")
    ProductEntity queryNumber(@RequestParam("train")String train);
}
