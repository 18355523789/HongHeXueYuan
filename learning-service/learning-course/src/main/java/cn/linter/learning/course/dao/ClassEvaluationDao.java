package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.ClassEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 班级评价数据访问对象
 *
 * @author yeletian
 * @since 2025/10/09
 */
@Mapper
public interface ClassEvaluationDao {

    /**
     * 根据班级ID查询评价列表
     *
     * @param classId 班级ID
     * @return 评价列表
     */
    List<ClassEvaluation> listByClassId(@Param("classId") Long classId);

    /**
     * 创建评价
     *
     * @param evaluation 评价
     * @return 影响行数
     */
    int create(@Param("evaluation") ClassEvaluation evaluation);

    /**
     * 更新评价
     *
     * @param evaluation 评价
     * @return 影响行数
     */
    int update(@Param("evaluation") ClassEvaluation evaluation);

    /**
     * 删除评价
     *
     * @param id 评价ID
     * @return 影响行数
     */
    int delete(@Param("id") Long id);
}
