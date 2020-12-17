package com.skyc.demo.merchants.controller;

import com.skyc.demo.merchants.po.StoreAddress;
import com.skyc.demo.merchants.service.StoreAddressService;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/address")
public class StoreAddressCon {

    @Autowired
    StoreAddressService storeAddressService;

    @PostMapping("/insertAddress")
    public int insertAddress(@RequestBody StoreAddress storeAddress){
        storeAddress.setId(UUIDUtils.getUUID(16));
        storeAddress.setAddTime(GetNowDate.getDetailStringDate());
        return storeAddressService.insertAddress(storeAddress);
    }

    @GetMapping("/selectById")
    public StoreAddress selectById(@PathParam("id") String id){
        return storeAddressService.selectById(id);
    }

    @GetMapping("/selectAllByStoreId")
    public List<StoreAddress> selectAllByStoreId(@PathParam("storeId") String storeId){
        return storeAddressService.selectAllByStoreId(storeId);
    }

    @GetMapping("/selectAllNormal")
    public List<StoreAddress> selectAllNormal(@PathParam("storeId") String storeId){
        return storeAddressService.selectAllNormal(storeId);
    }

    @PostMapping("/updateAddress")
    public int updateAddress(@RequestBody StoreAddress storeAddress){
        return storeAddressService.updateAddress(storeAddress);
    }

    @GetMapping("/deleteAddress")
    public int deleteAddress(@PathParam("id") String id){
        return storeAddressService.deleteAddress(id);
    }
}
