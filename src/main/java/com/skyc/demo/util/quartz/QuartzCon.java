package com.skyc.demo.util.quartz;

import com.skyc.demo.util.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testQuartz")
public class QuartzCon {

    @Autowired
    public CronSchedulerJob scheduleJobs;

    @RequestMapping("/doTest")
    public void doTest() throws Exception {
        scheduleJobs.scheduleAddJobs("job3", "jobGroup3", "trigger3", "grounp3", "0/10 * * * * ?", "3秒1次");
        scheduleJobs.scheduleAddJobs("job6", "jobGroup6", "trigger6", "grounp6", "0/20 * * * * ?", "6秒1次");
        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
    }

    @RequestMapping("/stopThree")
    public void stopThree() throws Exception {
        scheduleJobs.scheduleSubJobs("job6", "jobGroup6", "trigger6", "grounp6");
        System.out.println(">>>>>>>>>>>>>>>定时任务停止6<<<<<<<<<<<<<");
    }
}
