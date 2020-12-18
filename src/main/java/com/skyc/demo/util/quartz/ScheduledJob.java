package com.skyc.demo.util.quartz;

import com.skyc.demo.developers.dao.QuartzInfoMapper;
import com.skyc.demo.developers.po.QuartzInfo;
import com.skyc.demo.merchants.po.StoreAddress;
import com.skyc.demo.user.dao.SupervipInfoMapper;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ScheduledJob implements Job {

    @Autowired
    QuartzInfoMapper quartzInfoMapper;

    @Autowired
    SupervipInfoMapper supervipInfoMapper;

    @Autowired
    public CronSchedulerJob scheduleJobs;

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        QuartzInfo quartzInfo = quartzInfoMapper.selectById(id);
        supervipInfoMapper.restartNumber(quartzInfo.getJobname());
        quartzInfo.setRemainTime(quartzInfo.getRemainTime() - 1);
        if (quartzInfo.getRemainTime() > 0){
            quartzInfoMapper.subTime(id);
        }else{
            quartzInfoMapper.overTime(id);
            try {
                scheduleJobs.scheduleSubJobs(quartzInfo.getJobname(), quartzInfo.getJobgroup(), quartzInfo.getTriggername(), quartzInfo.getTriggergroup());
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
        System.out.println(dateFormat.format(new Date()) + "-------------------" + quartzInfo.getDescription());
    }
}
