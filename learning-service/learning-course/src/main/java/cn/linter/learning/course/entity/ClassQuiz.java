package cn.linter.learning.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 班级测试实体
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClassQuiz implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 班级ID
     */
    @NotNull(message = "班级ID不能为空")
    private Long classId;

    /**
     * 测试标题
     */
    @NotBlank(message = "测试标题不能为空")
    private String title;

    /**
     * 测试描述
     */
    private String description;

    /**
     * 题目数量
     */
    private Integer questionCount;

    /**
     * 测试时长（分钟）
     */
    private Integer duration;

    /**
     * 尝试次数
     */
    private Integer attemptCount;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 更新者
     */
    private String updater;

    public interface Create {
    }

    public interface Update {
    }
}
