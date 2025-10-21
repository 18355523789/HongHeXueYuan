package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.ClassCourseDao;
import cn.linter.learning.course.entity.ClassCourse;
import cn.linter.learning.course.service.ClassCourseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级课程服务实现类
 *
 * @author yeletian
 * @since 2025/10/09
 */
@Service
public class ClassCourseServiceImpl implements ClassCourseService {

    private final ClassCourseDao classCourseDao;

    public ClassCourseServiceImpl(ClassCourseDao classCourseDao) {
        this.classCourseDao = classCourseDao;
    }

    @Override
    public List<ClassCourse> listByClassId(Long classId) {
        return classCourseDao.listByClassId(classId);
    }

    @Override
    public ClassCourse create(ClassCourse classCourse) {
        classCourse.setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setEnabled(true);
        classCourseDao.create(classCourse);
        return classCourse;
    }

    @Override
    public void delete(Long classId, Long courseId) {
        classCourseDao.delete(classId, courseId);
    }

    @Override
    public void updateClassCourses(Long classId, List<Long> courseIds) {
        // 先删除该班级的所有课程关联
        classCourseDao.deleteByClassId(classId);
        
        // 重新添加新的课程关联
        if (courseIds != null && !courseIds.isEmpty()) {
            for (int i = 0; i < courseIds.size(); i++) {
                ClassCourse classCourse = new ClassCourse()
                        .setClassId(classId)
                        .setCourseId(courseIds.get(i))
                        .setOrderIndex(i + 1)
                        .setEnabled(true)
                        .setCreateTime(LocalDateTime.now())
                        .setUpdateTime(LocalDateTime.now());
                classCourseDao.create(classCourse);
            }
        }
    }
}
