package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.ClassEvaluation;

import java.util.List;

/**
 * 班级评价服务接口
 *
 * @author yeletian
 * @since 2025/10/09
 */
public interface ClassEvaluationService {

    /**
     * 根据班级ID查询评价列表
     *
     * @param classId 班级ID
     * @return 评价列表
     */
    List<ClassEvaluation> listByClassId(Long classId);

    /**
     * 创建评价
     *
     * @param evaluation 评价
     * @param username 用户名
     * @return 评价
     */
    ClassEvaluation create(ClassEvaluation evaluation, String username);

    /**
     * 更新评价
     *
     * @param evaluation 评价
     * @return 评价
     */
    ClassEvaluation update(ClassEvaluation evaluation);

    /**
     * 删除评价
     *
     * @param id 评价ID
     */
    void delete(Long id);
}
