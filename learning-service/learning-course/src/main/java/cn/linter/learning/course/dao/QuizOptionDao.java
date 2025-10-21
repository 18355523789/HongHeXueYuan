package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.QuizOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 選項數據庫訪問層
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Mapper
public interface QuizOptionDao {

    /**
     * 通過ID查詢單個選項
     *
     * @param id 選項ID
     * @return 單個選項
     */
    QuizOption selectById(Long id);

    /**
     * 通過題目ID查詢所有選項
     *
     * @param questionId 題目ID
     * @return 選項列表
     */
    List<QuizOption> listByQuestionId(Long questionId);

    /**
     * 新增選項
     *
     * @param quizOption 選項實例
     * @return 影響行數
     */
    int insert(QuizOption quizOption);

    /**
     * 更新選項
     *
     * @param quizOption 選項實例
     * @return 影響行數
     */
    int update(QuizOption quizOption);

    /**
     * 刪除選項
     *
     * @param id 選項ID
     * @return 影響行數
     */
    int delete(Long id);

    /**
     * 通過題目ID刪除所有選項
     *
     * @param questionId 題目ID
     * @return 影響行數
     */
    int deleteByQuestionId(Long questionId);

}
