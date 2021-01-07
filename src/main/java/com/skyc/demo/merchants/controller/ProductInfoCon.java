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

    @GetMapping("/selectIndexProductByStore")
    public List<ProductInfo> selectIndexProductByStore(@PathParam(value = "/storeId") String storeId){
        return productInfoService.selectIndexProductByStore(storeId);
    }

    @GetMapping("/selectSuperProductByStore")
    public List<ProductInfo> selectSuperProductByStore(@PathParam(value = "/storeId") String storeId){
        return productInfoService.selectSuperProductByStore(storeId);
    }

    @GetMapping("/selectProductById")
    public ProductInfo selectProductById(@PathParam(value = "/id") String id){
        return productInfoService.selectProductById(id);
    }

    @GetMapping("/selectIndexProduct")
    public List<ProductInfo> selectIndexProduct(){
        return productInfoService.selectIndexProduct();
    }

    @GetMapping("/selectSuperProduct")
    public List<ProductInfo> selectSuperProduct(@PathParam(value = "/userId") String userId){
        return productInfoService.selectSuperProduct(userId);
    }

    @GetMapping("/selectIndexOneBig")
    public List<ProductInfo> selectIndexOneBig(){
        return productInfoService.selectIndexOneBig();
    }

    @GetMapping("/selectIndexOneBigShow")
    public List<ProductInfo> selectIndexOneBigShow(){
        return productInfoService.selectIndexOneBigShow();
    }

    @GetMapping("/selectIndexOne")
    public List<ProductInfo> selectIndexOne(){
        return productInfoService.selectIndexOne();
    }

    @GetMapping("/selectIndexOneShow")
    public List<ProductInfo> selectIndexOneShow(){
        return productInfoService.selectIndexOneShow();
    }

    @GetMapping("/selectIndexTwo")
    public List<ProductInfo> selectIndexTwo(){
        return productInfoService.selectIndexTwo();
    }

    @GetMapping("/selectIndexTwoShow")
    public List<ProductInfo> selectIndexTwoShow(){
        return productInfoService.selectIndexTwoShow();
    }

    @PostMapping("/insertProduct")
    public String insertProduct(@RequestBody ProductInfo productInfo){
        return productInfoService.insertProduct(productInfo);
    }

    @PostMapping("/updateProduct")
    public int updateProduct(@RequestBody ProductInfo productInfo){
        return productInfoService.updateProduct(productInfo);
    }

    @PostMapping("/updateBig")
    public int updateBig(@RequestBody ProductInfo productInfo){
        return productInfoService.updateBig(productInfo);
    }

    @PostMapping("/updateOne")
    public int updateOne(@RequestBody List<ProductInfo> productInfo){
        return productInfoService.updateOne(productInfo);
    }

    @GetMapping("/deleteProduct")
    public int deleteProduct(@PathParam("/id") String id){
        return productInfoService.deleteProduct(id);
    }
}
