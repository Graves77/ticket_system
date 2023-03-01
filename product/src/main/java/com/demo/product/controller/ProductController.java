package com.demo.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.demo.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.product.entity.ProductEntity;
import com.demo.product.service.ProductService;
import com.demo.common.utils.PageUtils;
import com.demo.common.utils.R;

import javax.annotation.Resource;


/**
 * 
 *
 * @author Graves
 * @email Graves@gmail.com
 * @date 2023-01-07 16:01:58
 */
@RestController
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @Resource
    ProductDao productDao;
    /**
     * 通过trainID查票
     */
    @RequestMapping(value = "/train_query")
    public ProductEntity train_query(@RequestParam(value = "trainId") String Id){
        return productDao.selectBytrainId(Id);
    }

    /**
     * 买票
     */
    @RequestMapping(value = "/reduct")
    public R reduct(@RequestParam(value = "productId") Integer productId){
        ProductEntity product =  productService.getById(productId);
        if (product.getPassengerCapacity() > 0)
        {
            product.setPassengerCapacity(product.getPassengerCapacity()-1);
            productService.updateById(product);
            return R.ok();
        }
        else return R.error();

    }

    /**
     * 保存新的车票信息
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:product:save")
    public R save(@RequestBody ProductEntity product){
        if(productService.selectBynumber(product.getTrainNumber())==null){
            productService.save(product);
            return R.ok("保存成功");
        }
        else {
            return R.error("保存失败,已存在该车次");
        }

    }

    /**
     * 删除车次
     */
    @RequestMapping("/deleteNumber")
    //@RequiresPermissions("product:product:delete")
    public R deleteByNumber(@RequestParam(value = "train_number")String train_number){
        ProductEntity product = productService.selectBynumber(train_number);
        if(product==null) {
            return R.error("不存在该车次");
        }
        else  {
            productService.removeById(product.getId());
            return R.ok("该车次删除成功");
        }
    }

    /**
     * 修改车次
     */
    @RequestMapping("/updateNumber")
    //@RequiresPermissions("product:product:update")
    public R updateNumber(@RequestBody ProductEntity product){
        if(productService.updateById(product)){
        return R.ok("修改成功");
        }
        else return R.error("修改失败");
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:product:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:product:info")
    public R info(@PathVariable("id") Integer id){
		ProductEntity product = productService.getById(id);

        return R.ok().put("product", product);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:product:update")
    public R update(@RequestBody ProductEntity product){
		productService.updateById(product);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:product:delete")
    public R delete(@RequestBody Integer[] ids){
		productService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
