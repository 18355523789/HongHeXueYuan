package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.ClassQuiz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 班级测试数据访问对象
 *
 * @author yeletian
 * @since 2025/10/08
 */
@Mapper
public interface ClassQuizDao {

    /**
     * 根据班级ID查询测试列表
     *
     * @param classId 班级ID
     * @return 测试列表
     */
    List<ClassQuiz> listByClassId(@Param("classId") Long classId);

    /**
     * 根据ID查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    ClassQuiz queryById(@Param("id") Long id);

    /**
     * 创建测试
     *
     * @param quiz 测试
     * @return 影响行数
     */
    int create(@Param("quiz") ClassQuiz quiz);

    /**
     * 更新测试
     *
     * @param quiz 测试
     * @return 影响行数
     */
    int update(@Param("quiz") ClassQuiz quiz);

    /**
     * 删除测试
     *
     * @param id 测试ID
     * @return 影响行数
     */
    int delete(@Param("id") Long id);

    /**
     * 增加尝试次数
     *
     * @param id 测试ID
     * @return 影响行数
     */
    int incrementAttemptCount(@Param("id") Long id);
}
