package com.skyc.demo.util.quartz;


import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CronSchedulerJob {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public CronSchedulerJob(SchedulerFactoryBean schedulerFactoryBean) {
        this.schedulerFactoryBean = schedulerFactoryBean;
    }

    public void scheduleAddJobs(String jobName, String jobGroup, String triggerName, String triggerGrounp, String cron, String id) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        if (!scheduler.isShutdown()) {
            scheduler.start();
        }
        //构造job信息
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class) .withIdentity(jobName, jobGroup).build();
        // 表达式构造
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGrounp)
                .usingJobData("id",id).withSchedule(scheduleBuilder).build();

        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    public void scheduleSubJobs(String jobName, String jobGroupName, String triggerName, String triggerGroupName) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

        scheduler.pauseTrigger(triggerKey);// 停止触发器
        scheduler.unscheduleJob(triggerKey);// 移除触发器
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
    }
}
