package com.demo.order.controller;

import java.util.Arrays;
import java.util.Map;

import com.demo.order.feign.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order.entity.OrderEntity;
import com.demo.order.service.OrderService;
import com.demo.common.utils.PageUtils;
import com.demo.common.utils.R;



/**
 * 
 *
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 15:58:47
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    //@GlobalTransactional
    @RequestMapping("/buy_ticket")
    public R buy_ticket(@RequestBody OrderEntity order){

        orderService.buy_ticket(order);
        return R.ok();
    }

    @RequestMapping("/reduct_test")
    public R reduct_test(@RequestParam(value = "productId") Integer productId){

        productService.reduct(productId);
        return R.ok();
    }
    @RequestMapping("/trainid_test")
    public R trainid_test(@RequestParam(value = "productId") String productId){

        productService.train_query(productId);
        return R.ok();
    }

    @RequestMapping("/one")
    public R one(@RequestParam(value = "productId") Integer productId){

        OrderEntity order = orderService.getById(productId);
        return R.ok().put("order", order);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:order:info")
    public R info(@PathVariable("id") Integer id){
        OrderEntity order = orderService.getById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:order:save")
    public R save(@RequestBody OrderEntity order){
        orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:order:update")
    public R update(@RequestBody OrderEntity order){
        orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:order:delete")
    public R delete(@RequestBody Integer[] ids){
        orderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}
