package com.demo.member.fallback;

import com.demo.common.utils.R;
import com.demo.member.entity.ProductEntity;
import com.demo.member.feign.ProductFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProductFeignServiceFallBack implements ProductFeignService {
    @Override
    public List<ProductEntity> queryArrival(String arrivalStation) {
        return null;
    }

    @Override
    public R producttest() {
        log.info("熔断方法调用..");
        return R.error(404,"消息太多");
    }

    @Override
    public List<ProductEntity> queryStart(String startstation) {
        return null;
    }

    @Override
    public ProductEntity queryNumber(String train) {
        return null;
    }
}
