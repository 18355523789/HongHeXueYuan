package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.ClassCourse;

import java.util.List;

/**
 * 班级课程服务接口
 *
 * @author yeletian
 * @since 2025/10/09
 */
public interface ClassCourseService {

    /**
     * 根据班级ID查询课程列表
     *
     * @param classId 班级ID
     * @return 课程列表
     */
    List<ClassCourse> listByClassId(Long classId);

    /**
     * 添加课程到班级
     *
     * @param classCourse 班级课程关联
     * @return 班级课程关联
     */
    ClassCourse create(ClassCourse classCourse);

    /**
     * 从班级中移除课程
     *
     * @param classId 班级ID
     * @param courseId 课程ID
     */
    void delete(Long classId, Long courseId);

    /**
     * 批量更新班级课程
     *
     * @param classId 班级ID
     * @param courseIds 课程ID列表
     */
    void updateClassCourses(Long classId, List<Long> courseIds);
}
