package com.skyc.demo.merchants.controller;

import com.skyc.demo.merchants.po.ProductInfo;
import com.skyc.demo.merchants.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductInfoCon {

    @Autowired
    ProductInfoService productInfoService;

    @GetMapping("/selectProductByStore")
    public List<ProductInfo> selectProductByStore(@RequestParam("/storeId") String storeId){
        return productInfoService.selectProductByStore(storeId);
    }

    @PostMapping("/insertProduct")
    public String insertProduct(@RequestBody ProductInfo productInfo){
        return productInfoService.insertProduct(productInfo);
    }

    @PostMapping("/updateProduct")
    public int updateProduct(@RequestBody ProductInfo productInfo){
        return productInfoService.updateProduct(productInfo);
    }

    @GetMapping("/deleteProduct")
    public int deleteProduct(@RequestParam("/id") String id){
        return productInfoService.deleteProduct(id);
    }
}
