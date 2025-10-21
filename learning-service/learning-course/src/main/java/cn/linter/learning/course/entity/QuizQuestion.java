package cn.linter.learning.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 題目實體類
 *
 * @author yeletian
 * @since 2025/10/08
 */
@Data
@ToString
@EqualsAndHashCode
public class QuizQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 題目ID
     */
    private Long id;
    /**
     * 課程ID
     */
    private Long courseId;
    /**
     * 題目內容
     */
    private String questionText;
    /**
     * 題目類型：single(單選), multiple(多選), judge(判斷)
     */
    private String questionType;
    /**
     * 正確答案
     */
    private String correctAnswer;
    /**
     * 答案解析
     */
    private String explanation;
    /**
     * 難度等級：1-簡單，2-中等，3-困難
     */
    private Integer difficultyLevel;
    /**
     * 創建時間
     */
    private LocalDateTime createTime;
    /**
     * 修改時間
     */
    private LocalDateTime updateTime;
    /**
     * 選項列表
     */
    private List<QuizOption> options;

}
