package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.ClassQuizDao;
import cn.linter.learning.course.entity.ClassQuiz;
import cn.linter.learning.course.service.ClassQuizService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级测试服务实现类
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Service
public class ClassQuizServiceImpl implements ClassQuizService {

    private final ClassQuizDao classQuizDao;

    public ClassQuizServiceImpl(ClassQuizDao classQuizDao) {
        this.classQuizDao = classQuizDao;
    }

    @Override
    public List<ClassQuiz> listByClassId(Long classId) {
        return classQuizDao.listByClassId(classId);
    }

    @Override
    public ClassQuiz queryById(Long id) {
        return classQuizDao.queryById(id);
    }

    @Override
    public ClassQuiz create(ClassQuiz quiz, String username) {
        quiz.setCreator(username)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setAttemptCount(0)
                .setEnabled(true);
        classQuizDao.create(quiz);
        return quiz;
    }

    @Override
    public ClassQuiz update(ClassQuiz quiz) {
        quiz.setUpdateTime(LocalDateTime.now());
        classQuizDao.update(quiz);
        return quiz;
    }

    @Override
    public void delete(Long id) {
        classQuizDao.delete(id);
    }

    @Override
    public void incrementAttemptCount(Long id) {
        classQuizDao.incrementAttemptCount(id);
    }
}
