package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.Notice;

import java.util.List;

/**
 * 通知服务接口
 *
 * @author yeletian
 * @since 2025/10/07
 */
public interface NoticeService {

    /**
     * 根据ID查询通知
     *
     * @param id 通知ID
     * @return 通知
     */
    Notice queryById(Long id);

    /**
     * 查询通知列表
     *
     * @param enabled 是否启用
     * @param orderBy 排序方式：popularity-按热度, create_time-按时间
     * @return 通知列表
     */
    List<Notice> list(Boolean enabled, String orderBy);

    /**
     * 创建通知
     *
     * @param notice 通知
     * @param username 创建者用户名
     * @return 通知
     */
    Notice create(Notice notice, String username);

    /**
     * 更新通知
     *
     * @param notice 通知
     * @return 通知
     */
    Notice update(Notice notice);

    /**
     * 删除通知
     *
     * @param id 通知ID
     */
    void delete(Long id);

    /**
     * 增加浏览次数
     *
     * @param id 通知ID
     */
    void incrementViewCount(Long id);
}
