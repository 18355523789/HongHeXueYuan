package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.UserQuizRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用戶答題記錄數據庫訪問層
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Mapper
public interface UserQuizRecordDao {

    /**
     * 通過ID查詢單個記錄
     *
     * @param id 記錄ID
     * @return 單個記錄
     */
    UserQuizRecord selectById(Long id);

    /**
     * 通過用戶名查詢所有記錄
     *
     * @param userName 用戶名
     * @return 記錄列表
     */
    List<UserQuizRecord> listByUserName(String userName);

    /**
     * 通過題目ID查詢所有記錄
     *
     * @param questionId 題目ID
     * @return 記錄列表
     */
    List<UserQuizRecord> listByQuestionId(Long questionId);

    /**
     * 通過用戶名和題目ID查詢記錄
     *
     * @param userName 用戶名
     * @param questionId 題目ID
     * @return 記錄
     */
    UserQuizRecord selectByUserNameAndQuestionId(@Param("userName") String userName, @Param("questionId") Long questionId);

    /**
     * 新增記錄
     *
     * @param userQuizRecord 記錄實例
     * @return 影響行數
     */
    int insert(UserQuizRecord userQuizRecord);

    /**
     * 更新記錄
     *
     * @param userQuizRecord 記錄實例
     * @return 影響行數
     */
    int update(UserQuizRecord userQuizRecord);

    /**
     * 刪除記錄
     *
     * @param id 記錄ID
     * @return 影響行數
     */
    int delete(Long id);

}
