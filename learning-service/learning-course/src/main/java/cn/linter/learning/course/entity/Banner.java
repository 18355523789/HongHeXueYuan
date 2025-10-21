package cn.linter.learning.course.entity;

import java.time.LocalDateTime;

/**
 * 公司宣傳圖實體
 */
public class Banner {

    private Long id;
    private String url;           // 圖片URL
    private String link;          // 點擊跳轉鏈接
    private String title;         // 標題/描述
    private Integer sort;         // 排序值，越小越前
    private Boolean enabled;      // 是否啟用
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Integer getSort() { return sort; }
    public void setSort(Integer sort) { this.sort = sort; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }
}


