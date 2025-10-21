package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.QuizQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 題目數據庫訪問層
 *
 * @author yeletian
 * @since 2025/07/15
 */
@Mapper
public interface QuizQuestionDao {

    /**
     * 通過ID查詢單個題目
     *
     * @param id 題目ID
     * @return 單個題目
     */
    QuizQuestion selectById(Long id);

    /**
     * 通過課程ID查詢所有題目
     *
     * @param courseId 課程ID
     * @param difficultyLevel 難度等級
     * @return 題目列表
     */
    List<QuizQuestion> listByCourseId(@Param("courseId") Long courseId, @Param("difficultyLevel") Integer difficultyLevel);

    /**
     * 通過課程ID隨機查詢指定數量的題目
     *
     * @param courseId 課程ID
     * @param limit 限制數量
     * @param difficultyLevel 難度等級
     * @return 題目列表
     */
    List<QuizQuestion> listRandomByCourseId(@Param("courseId") Long courseId, @Param("limit") Integer limit, @Param("difficultyLevel") Integer difficultyLevel);

    /**
     * 新增題目
     *
     * @param quizQuestion 題目實例
     * @return 影響行數
     */
    int insert(QuizQuestion quizQuestion);

    /**
     * 更新題目
     *
     * @param quizQuestion 題目實例
     * @return 影響行數
     */
    int update(QuizQuestion quizQuestion);

    /**
     * 刪除題目
     *
     * @param id 題目ID
     * @return 影響行數
     */
    int delete(Long id);

}
