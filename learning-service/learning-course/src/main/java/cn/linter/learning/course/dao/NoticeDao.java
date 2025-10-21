package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通知数据访问对象
 *
 * @author yeletian
 * @since 2025/10/09
 */
@Mapper
public interface NoticeDao {

    /**
     * 根据ID查询通知
     *
     * @param id 通知ID
     * @return 通知
     */
    Notice queryById(@Param("id") Long id);

    /**
     * 查询通知列表
     *
     * @param enabled 是否启用
     * @param orderBy 排序方式：popularity-按热度, create_time-按时间
     * @return 通知列表
     */
    List<Notice> list(@Param("enabled") Boolean enabled, @Param("orderBy") String orderBy);

    /**
     * 创建通知
     *
     * @param notice 通知
     * @return 影响行数
     */
    int create(@Param("notice") Notice notice);

    /**
     * 更新通知
     *
     * @param notice 通知
     * @return 影响行数
     */
    int update(@Param("notice") Notice notice);

    /**
     * 删除通知
     *
     * @param id 通知ID
     * @return 影响行数
     */
    int delete(@Param("id") Long id);

    /**
     * 增加浏览次数
     *
     * @param id 通知ID
     * @return 影响行数
     */
    int incrementViewCount(@Param("id") Long id);
}
