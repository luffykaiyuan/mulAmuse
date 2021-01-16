package com.skyc.demo.user.service;

import com.skyc.demo.developers.dao.QuartzInfoMapper;
import com.skyc.demo.developers.po.QuartzInfo;
import com.skyc.demo.user.dao.SupervipInfoMapper;
import com.skyc.demo.user.po.OrderInfo;
import com.skyc.demo.user.po.SupervipInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import com.skyc.demo.util.quartz.CronSchedulerJob;
import com.skyc.demo.util.quartz.ScheduledJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class SupervipInfoService {

    @Autowired
    SupervipInfoMapper supervipInfoMapper;

    @Autowired
    CronSchedulerJob scheduleJobs;

    @Autowired
    QuartzInfoMapper quartzInfoMapper;

    public int insertSuperVIP(SupervipInfo supervipInfo) throws Exception {
        supervipInfo.setId(UUIDUtils.getUUID(16));

        QuartzInfo quartzInfo = new QuartzInfo();
        String id = UUIDUtils.getUUID(16);
        quartzInfo.setId(id);
        quartzInfo.setClassName(ScheduledJob.class.toString());
        quartzInfo.setJobname(supervipInfo.getUserId());
        quartzInfo.setJobgroup(id);
        quartzInfo.setTriggername(supervipInfo.getId());
        quartzInfo.setTriggergroup(id);
        quartzInfo.setCronExpression("0 0 0 " + GetNowDate.getStringDay() + "/30 * ? ");
        quartzInfo.setRemainTime(supervipInfo.getHaveNumber() / 6 - 1);
        quartzInfo.setDescription("用户" + supervipInfo.getUserId() + "成为会员");
        quartzInfoMapper.insertQuartz(quartzInfo);
        System.out.println(GetNowDate.getDetailStringDate());
        if (quartzInfo.getRemainTime() > 0){
            scheduleJobs.scheduleAddJobs(quartzInfo.getJobname(), quartzInfo.getJobgroup(),
                    quartzInfo.getTriggername(), quartzInfo.getTriggergroup(), quartzInfo.getCronExpression(), id);
        }

        if (supervipInfo.getHaveNumber() > 6){
            supervipInfo.setHaveNumber(supervipInfo.getHaveNumber()/6);
        }
        return supervipInfoMapper.insertSuperVIP(supervipInfo);
    }

    public boolean checkOrder(OrderInfo orderInfo, HttpServletRequest request){
        HttpSession session = request.getSession();
        String orderPrice = String.valueOf( (int) (orderInfo.getOrderPrice() * 100));
        session.setAttribute("orderPrice", orderPrice);
        session.setAttribute("openid", orderInfo.getOpenid());
        return true;
    }

    public int updateSuperVIP(SupervipInfo supervipInfo){
        return supervipInfoMapper.updateSuperVIP(supervipInfo);
    }

    public SupervipInfo selectByUserId(String userId){
        return supervipInfoMapper.selectByUserId(userId);
    }

}
