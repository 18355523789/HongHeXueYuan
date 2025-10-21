package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.ClassEvaluationDao;
import cn.linter.learning.course.entity.ClassEvaluation;
import cn.linter.learning.course.service.ClassEvaluationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级评价服务实现类
 *
 * @author yeletian
 * @since 2025/10/09
 */
@Service
public class ClassEvaluationServiceImpl implements ClassEvaluationService {

    private final ClassEvaluationDao classEvaluationDao;

    public ClassEvaluationServiceImpl(ClassEvaluationDao classEvaluationDao) {
        this.classEvaluationDao = classEvaluationDao;
    }

    @Override
    public List<ClassEvaluation> listByClassId(Long classId) {
        return classEvaluationDao.listByClassId(classId);
    }

    @Override
    public ClassEvaluation create(ClassEvaluation evaluation, String username) {
        evaluation.setUsername(username)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        classEvaluationDao.create(evaluation);
        return evaluation;
    }

    @Override
    public ClassEvaluation update(ClassEvaluation evaluation) {
        evaluation.setUpdateTime(LocalDateTime.now());
        classEvaluationDao.update(evaluation);
        return evaluation;
    }

    @Override
    public void delete(Long id) {
        classEvaluationDao.delete(id);
    }
}
