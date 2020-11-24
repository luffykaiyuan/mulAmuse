package com.skyc.demo.admin.service;

import com.skyc.demo.admin.dao.AdminInfoMapper;
import com.skyc.demo.admin.po.AdminInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminInfoService {

    @Autowired
    AdminInfoMapper adminInfoMapper;

    @Value("${insertSuc}")
    String insertSuc;
    @Value("${insertFAL}")
    String insertFAL;
    @Value("${updateSuc}")
    String updateSuc;
    @Value("${updateFal}")
    String updateFal;
    @Value("${checkUsername}")
    String checkUsername;
    @Value("${repeatUsername}")
    String repeatUsername;
    @Value("${checkPass}")
    String checkPass;

    public String insertAdmin(AdminInfo adminInfo){
        AdminInfo adminInfoOld = adminInfoMapper.selectByUsername(adminInfo.getAdminUsername());
        if (!"".equals(adminInfoOld.getAdminUsername()) && !"".equals(adminInfoOld.getAdminPassword())){
            adminInfo.setId(UUIDUtils.getUUID(16));
            adminInfo.setAddTime(GetNowDate.getStringDate());
            adminInfoMapper.insertAdmin(adminInfo);
            return insertSuc;
        }else {
            return repeatUsername;
        }
    }

    public AdminInfo selectById(String id){
        return adminInfoMapper.selectById(id);
    }


    public List<AdminInfo> selectAllAdmin(){
        return adminInfoMapper.selectAllAdmin();
    }


    public int updateAdmin(AdminInfo adminInfo){
        return adminInfoMapper.updateAdmin(adminInfo);
    }

    public String changePassword(AdminInfo adminInfo){
        int flag = adminInfoMapper.changePassword(adminInfo);
        if (flag > 0){
            return updateSuc;
        }else {
            return updateFal;
        }
    }

    public int deleteAdmin(String id){
        return adminInfoMapper.deleteAdmin(id);
    }

    public String loginAdmin(AdminInfo adminInfo){
        AdminInfo adminInfoOld = adminInfoMapper.selectByUsername(adminInfo.getId());
        if ("".equals(adminInfoOld.getAdminUsername())){
            return checkUsername;
        }else{
            if (adminInfoOld.equals(adminInfo.getAdminPassword())){
                return "";
            }else {
                return checkPass;
            }
        }
    }

}
