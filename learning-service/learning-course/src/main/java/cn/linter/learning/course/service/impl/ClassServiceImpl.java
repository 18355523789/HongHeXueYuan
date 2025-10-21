package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.ClassDao;
import cn.linter.learning.course.entity.Class;
import cn.linter.learning.course.service.ClassService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级服务实现类
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Service
public class ClassServiceImpl implements ClassService {

    private final ClassDao classDao;

    public ClassServiceImpl(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public Class queryById(Long id) {
        return classDao.queryById(id);
    }

    @Override
    public List<Class> list(Boolean enabled, String orderBy) {
        return classDao.list(enabled, orderBy);
    }

    @Override
    public Class create(Class classEntity, String username) {
        classEntity.setCreator(username)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setStudentCount(0)
                .setAverageScore(0.0)
                .setEnabled(true);
        classDao.create(classEntity);
        return classEntity;
    }

    @Override
    public Class update(Class classEntity) {
        classEntity.setUpdateTime(LocalDateTime.now());
        classDao.update(classEntity);
        return classEntity;
    }

    @Override
    public void delete(Long id) {
        classDao.delete(id);
    }

    @Override
    public void incrementStudentCount(Long id) {
        classDao.incrementStudentCount(id);
    }

    @Override
    public void updateAverageScore(Long id, Double averageScore) {
        classDao.updateAverageScore(id, averageScore);
    }
}
