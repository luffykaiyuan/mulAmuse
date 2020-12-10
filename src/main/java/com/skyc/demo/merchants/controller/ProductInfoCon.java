package com.skyc.demo.merchants.controller;

import com.skyc.demo.merchants.po.ProductInfo;
import com.skyc.demo.merchants.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductInfoCon {

    @Autowired
    ProductInfoService productInfoService;

    @GetMapping("/selectProductByStore")
    public List<ProductInfo> selectProductByStore(@PathParam(value = "/storeId") String storeId){
        return productInfoService.selectProductByStore(storeId);
    }

    @GetMapping("/selectProductById")
    public ProductInfo selectProductById(@PathParam(value = "/id") String id){
        return productInfoService.selectProductById(id);
    }

    @GetMapping("/selectIndexProduct")
    public List<ProductInfo> selectIndexProduct(){
        return productInfoService.selectIndexProduct();
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
    public int deleteProduct(@PathParam("/id") String id){
        return productInfoService.deleteProduct(id);
    }
}
