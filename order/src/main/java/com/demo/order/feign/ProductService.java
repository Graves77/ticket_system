package com.demo.order.feign;


import com.demo.common.utils.R;
import com.demo.order.entity.ProductEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient( "product")
public interface ProductService {

    @RequestMapping(value ="/product/reduct")
    R reduct(@RequestParam(value = "productId") Integer productId);

    /**
     * 通过trainID查票
     */
    @RequestMapping(value = "/train_query")
    public ProductEntity train_query(@RequestParam(value = "trainId") String Id);
}
