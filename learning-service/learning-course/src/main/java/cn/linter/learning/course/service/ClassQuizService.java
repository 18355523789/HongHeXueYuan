package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.ClassQuiz;

import java.util.List;

/**
 * 班级测试服务接口
 *
 * @author yeletian
 * @since 2025/10/09
 */
public interface ClassQuizService {

    /**
     * 根据班级ID查询测试列表
     *
     * @param classId 班级ID
     * @return 测试列表
     */
    List<ClassQuiz> listByClassId(Long classId);

    /**
     * 根据ID查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    ClassQuiz queryById(Long id);

    /**
     * 创建测试
     *
     * @param quiz 测试
     * @param username 创建者用户名
     * @return 测试
     */
    ClassQuiz create(ClassQuiz quiz, String username);

    /**
     * 更新测试
     *
     * @param quiz 测试
     * @return 测试
     */
    ClassQuiz update(ClassQuiz quiz);

    /**
     * 删除测试
     *
     * @param id 测试ID
     */
    void delete(Long id);

    /**
     * 增加尝试次数
     *
     * @param id 测试ID
     */
    void incrementAttemptCount(Long id);
}
