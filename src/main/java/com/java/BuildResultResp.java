package com.java;



import java.io.Serializable;
import java.util.Date;

/**
 * @创建人 tengcc
 * @创建时间 2018/8/9
 * @描述 构建结果
 */
public class BuildResultResp implements Serializable {
    private static final long serialVersionUID = -5186563341105606707L;
    /**
     * 模块id
     */
    private Long moduleId;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 模块构建号
     */
    private Integer buildNum;
    /**
     * appid
     */
    private String appId;
    /**
     * 构建分支
     */
    private String buildBranch;
    /**
     * 构建开始时间
     */
    private Date startTime;
    /**
     * 构建结束时间
     */
    private Date endTime;
    /**
     * 构建耗时
     */
    private String costTime;
    /**
     * 构建状态 0:构建中 1：构建成功 2构建失败
     */
    private Integer status;
    /**
     * 构建人
     */
    private String userName;
    /**
     * 构建时用的提交Id
     */
    private String commitid;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(Integer buildNum) {
        this.buildNum = buildNum;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getBuildBranch() {
        return buildBranch;
    }

    public void setBuildBranch(String buildBranch) {
        this.buildBranch = buildBranch;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommitid() {
        return commitid;
    }

    public void setCommitid(String commitid) {
        this.commitid = commitid;
    }
}
