package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.QuizQuestion;
import cn.linter.learning.course.entity.UserQuizRecord;

import java.util.List;

/**
 * 題目服務接口
 *
 * @author yeletian
 * @since 2025/07/15
 */
public interface QuizQuestionService {

    /**
     * 通過ID查詢單個題目
     *
     * @param id 題目ID
     * @return 單個題目
     */
    QuizQuestion queryById(Long id);

    /**
     * 通過課程ID查詢所有題目
     *
     * @param courseId 課程ID
     * @param difficultyLevel 難度等級
     * @return 題目列表
     */
    List<QuizQuestion> listByCourseId(Long courseId, Integer difficultyLevel);

    /**
     * 通過課程ID隨機查詢指定數量的題目
     *
     * @param courseId 課程ID
     * @param limit 限制數量
     * @param difficultyLevel 難度等級
     * @return 題目列表
     */
    List<QuizQuestion> listRandomByCourseId(Long courseId, Integer limit, Integer difficultyLevel);

    /**
     * 新增題目
     *
     * @param quizQuestion 題目實例
     * @return 題目實例
     */
    QuizQuestion create(QuizQuestion quizQuestion);

    /**
     * 更新題目
     *
     * @param quizQuestion 題目實例
     * @return 題目實例
     */
    QuizQuestion update(QuizQuestion quizQuestion);

    /**
     * 刪除題目
     *
     * @param id 題目ID
     * @return 是否成功
     */
    boolean delete(Long id);

    /**
     * 提交答案並記錄
     *
     * @param questionId 題目ID
     * @param userAnswer 用戶答案
     * @param userName 用戶名
     * @return 答題結果
     */
    UserQuizRecord submitAnswer(Long questionId, String userAnswer, String userName);

}
