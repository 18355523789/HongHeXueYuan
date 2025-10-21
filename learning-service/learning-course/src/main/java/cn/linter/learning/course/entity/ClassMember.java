package cn.linter.learning.course.entity;

import java.time.LocalDateTime;

/**
 * 班級成員實體類
 *
 * @author yeletian
 * @since 2025/10/08
 */
public class ClassMember {

    /**
     * 記錄ID
     */
    private Long id;

    /**
     * 班級ID
     */
    private Long classId;

    /**
     * 用戶名
     */
    private String userName;

    /**
     * 加入時間
     */
    private LocalDateTime joinTime;

    /**
     * 狀態：0-已退出，1-正常
     */
    private Integer status;

    /**
     * 創建時間
     */
    private LocalDateTime createTime;

    /**
     * 修改時間
     */
    private LocalDateTime updateTime;

    /**
     * 創建者
     */
    private String creator;

    /**
     * 更新者
     */
    private String updater;


    public ClassMember() {
    }

    public Long getId() {
        return id;
    }

    public ClassMember setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getClassId() {
        return classId;
    }

    public ClassMember setClassId(Long classId) {
        this.classId = classId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ClassMember setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public LocalDateTime getJoinTime() {
        return joinTime;
    }

    public ClassMember setJoinTime(LocalDateTime joinTime) {
        this.joinTime = joinTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ClassMember setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ClassMember setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ClassMember setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ClassMember setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getUpdater() {
        return updater;
    }

    public ClassMember setUpdater(String updater) {
        this.updater = updater;
        return this;
    }


    @Override
    public String toString() {
        return "ClassMember{" +
                "id=" + id +
                ", classId=" + classId +
                ", userName='" + userName + '\'' +
                ", joinTime=" + joinTime +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", creator='" + creator + '\'' +
                ", updater='" + updater + '\'' +
                '}';
    }
}
