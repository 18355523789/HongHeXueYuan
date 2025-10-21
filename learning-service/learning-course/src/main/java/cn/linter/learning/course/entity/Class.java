package cn.linter.learning.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 班级实体
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 班级名称
     */
    @NotBlank(message = "班级名称不能为空")
    private String name;

    /**
     * 班级描述
     */
    private String description;

    /**
     * 封面图片
     */
    private String coverPicture;

    /**
     * 价格
     */
    @NotNull(message = "价格不能为空")
    private Double price;

    /**
     * 课程数量
     */
    private Integer courseCount;

    /**
     * 学员数量
     */
    private Integer studentCount;

    /**
     * 平均评分
     */
    private Double averageScore;

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
