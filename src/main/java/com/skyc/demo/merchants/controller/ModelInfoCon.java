package com.skyc.demo.merchants.controller;

import com.skyc.demo.merchants.po.ModelInfo;
import com.skyc.demo.merchants.service.ModelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/model")
public class ModelInfoCon {

    @Autowired
    ModelInfoService modelInfoService;

    @PostMapping("/insertModel")
    public int insertModel(@RequestBody ModelInfo modelInfo){
        return modelInfoService.insertModel(modelInfo);
    }

    @GetMapping("/selectModelByProduct")
    public List<ModelInfo> selectModelByProduct(@PathParam("/productId") String productId){
        return modelInfoService.selectModelByProduct(productId);
    }

    @PostMapping("/updateModel")
    public int updateModel(@RequestBody ModelInfo modelInfo){
        return modelInfoService.updateModel(modelInfo);
    }

    @GetMapping("/deleteModel")
    public int deleteModel(@PathParam("/id") String id){
        return modelInfoService.deleteModel(id);
    }
}
