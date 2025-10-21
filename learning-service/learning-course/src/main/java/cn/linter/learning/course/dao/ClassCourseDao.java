package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.ClassCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 班级课程关联数据访问对象
 *
 * @author yeletian
 * @since 2025/10/08
 */
@Mapper
public interface ClassCourseDao {

    /**
     * 根据班级ID查询课程列表
     *
     * @param classId 班级ID
     * @return 课程列表
     */
    List<ClassCourse> listByClassId(@Param("classId") Long classId);

    /**
     * 添加课程到班级
     *
     * @param classCourse 班级课程关联
     * @return 影响行数
     */
    int create(@Param("classCourse") ClassCourse classCourse);

    /**
     * 从班级中移除课程
     *
     * @param classId 班级ID
     * @param courseId 课程ID
     * @return 影响行数
     */
    int delete(@Param("classId") Long classId, @Param("courseId") Long courseId);

    /**
     * 删除班级的所有课程关联
     *
     * @param classId 班级ID
     * @return 影响行数
     */
    int deleteByClassId(@Param("classId") Long classId);
}
