package com.skyc.demo.developers.po;

public class QuartzInfo {
    private String id;

    private String className;

    private String jobname;

    private String jobgroup;

    private String triggername;

    private String triggergroup;

    private String cronExpression;

    private Integer remainTime;

    private String description;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public String getJobgroup() {
        return jobgroup;
    }

    public void setJobgroup(String jobgroup) {
        this.jobgroup = jobgroup == null ? null : jobgroup.trim();
    }

    public String getTriggername() {
        return triggername;
    }

    public void setTriggername(String triggername) {
        this.triggername = triggername == null ? null : triggername.trim();
    }

    public String getTriggergroup() {
        return triggergroup;
    }

    public void setTriggergroup(String triggergroup) {
        this.triggergroup = triggergroup == null ? null : triggergroup.trim();
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    public Integer getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(Integer remainTime) {
        this.remainTime = remainTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}