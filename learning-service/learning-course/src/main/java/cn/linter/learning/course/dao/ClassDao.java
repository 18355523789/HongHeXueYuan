package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 班级数据访问对象
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Mapper
public interface ClassDao {

    /**
     * 根据ID查询班级
     *
     * @param id 班级ID
     * @return 班级
     */
    Class queryById(@Param("id") Long id);

    /**
     * 查询班级列表
     *
     * @param enabled 是否启用
     * @param orderBy 排序方式：average_score-按评分, create_time-按时间
     * @return 班级列表
     */
    List<Class> list(@Param("enabled") Boolean enabled, @Param("orderBy") String orderBy);

    /**
     * 创建班级
     *
     * @param classEntity 班级
     * @return 影响行数
     */
    int create(@Param("classEntity") Class classEntity);

    /**
     * 更新班级
     *
     * @param classEntity 班级
     * @return 影响行数
     */
    int update(@Param("classEntity") Class classEntity);

    /**
     * 删除班级
     *
     * @param id 班级ID
     * @return 影响行数
     */
    int delete(@Param("id") Long id);

    /**
     * 增加学员数量
     *
     * @param id 班级ID
     * @return 影响行数
     */
    int incrementStudentCount(@Param("id") Long id);

    /**
     * 更新平均评分
     *
     * @param id 班级ID
     * @param averageScore 平均评分
     * @return 影响行数
     */
    int updateAverageScore(@Param("id") Long id, @Param("averageScore") Double averageScore);
}
