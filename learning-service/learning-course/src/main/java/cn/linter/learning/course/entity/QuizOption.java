package cn.linter.learning.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 選項實體類
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Data
@ToString
@EqualsAndHashCode
public class QuizOption implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 選項ID
     */
    private Long id;
    /**
     * 題目ID
     */
    private Long questionId;
    /**
     * 選項內容
     */
    private String optionText;
    /**
     * 選項標識：A, B, C, D等
     */
    private String optionKey;
    /**
     * 是否正確選項：0-否，1-是
     */
    private Integer isCorrect;
    /**
     * 創建時間
     */
    private LocalDateTime createTime;
    /**
     * 修改時間
     */
    private LocalDateTime updateTime;

}
