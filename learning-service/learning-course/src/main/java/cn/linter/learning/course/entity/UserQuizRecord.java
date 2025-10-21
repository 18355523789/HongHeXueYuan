package cn.linter.learning.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用戶答題記錄實體類
 *
 * @author yeletian
 * @since 2025/07/15
 */
@Data
@ToString
@EqualsAndHashCode
public class UserQuizRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 記錄ID
     */
    private Long id;
    /**
     * 用戶名
     */
    private String userName;
    /**
     * 題目ID
     */
    private Long questionId;
    /**
     * 用戶答案
     */
    private String userAnswer;
    /**
     * 是否正確：0-錯誤，1-正確
     */
    private Integer isCorrect;
    /**
     * 答題時間
     */
    private LocalDateTime answerTime;
    /**
     * 創建時間
     */
    private LocalDateTime createTime;
    /**
     * 修改時間
     */
    private LocalDateTime updateTime;

}
