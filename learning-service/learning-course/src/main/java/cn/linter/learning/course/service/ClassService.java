package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.Class;

import java.util.List;

/**
 * 班级服务接口
 *
 * @author yeletian
 * @since 2025/10/08
 */
public interface ClassService {

    /**
     * 根据ID查询班级
     *
     * @param id 班级ID
     * @return 班级
     */
    Class queryById(Long id);

    /**
     * 查询班级列表
     *
     * @param enabled 是否启用
     * @param orderBy 排序方式：average_score-按评分, create_time-按时间
     * @return 班级列表
     */
    List<Class> list(Boolean enabled, String orderBy);

    /**
     * 创建班级
     *
     * @param classEntity 班级
     * @param username 创建者用户名
     * @return 班级
     */
    Class create(Class classEntity, String username);

    /**
     * 更新班级
     *
     * @param classEntity 班级
     * @return 班级
     */
    Class update(Class classEntity);

    /**
     * 删除班级
     *
     * @param id 班级ID
     */
    void delete(Long id);

    /**
     * 增加学员数量
     *
     * @param id 班级ID
     */
    void incrementStudentCount(Long id);

    /**
     * 更新平均评分
     *
     * @param id 班级ID
     * @param averageScore 平均评分
     */
    void updateAverageScore(Long id, Double averageScore);
}
