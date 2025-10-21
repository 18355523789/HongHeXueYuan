package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.QuizOptionDao;
import cn.linter.learning.course.dao.QuizQuestionDao;
import cn.linter.learning.course.dao.UserQuizRecordDao;
import cn.linter.learning.course.entity.QuizOption;
import cn.linter.learning.course.entity.QuizQuestion;
import cn.linter.learning.course.entity.UserQuizRecord;
import cn.linter.learning.course.service.QuizQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 題目服務實現類
 *
 * @author yeletian
 * @since 2025/07/15
 */
@Service
public class QuizQuestionServiceImpl implements QuizQuestionService {

    private final QuizQuestionDao quizQuestionDao;
    private final QuizOptionDao quizOptionDao;
    private final UserQuizRecordDao userQuizRecordDao;

    public QuizQuestionServiceImpl(QuizQuestionDao quizQuestionDao, QuizOptionDao quizOptionDao, UserQuizRecordDao userQuizRecordDao) {
        this.quizQuestionDao = quizQuestionDao;
        this.quizOptionDao = quizOptionDao;
        this.userQuizRecordDao = userQuizRecordDao;
    }

    @Override
    public QuizQuestion queryById(Long id) {
        QuizQuestion question = quizQuestionDao.selectById(id);
        if (question != null) {
            question.setOptions(quizOptionDao.listByQuestionId(id));
        }
        return question;
    }

    @Override
    public List<QuizQuestion> listByCourseId(Long courseId, Integer difficultyLevel) {
        List<QuizQuestion> questions = quizQuestionDao.listByCourseId(courseId, difficultyLevel);
        for (QuizQuestion question : questions) {
            question.setOptions(quizOptionDao.listByQuestionId(question.getId()));
        }
        return questions;
    }

    @Override
    public List<QuizQuestion> listRandomByCourseId(Long courseId, Integer limit, Integer difficultyLevel) {
        List<QuizQuestion> questions = quizQuestionDao.listRandomByCourseId(courseId, limit, difficultyLevel);
        for (QuizQuestion question : questions) {
            question.setOptions(quizOptionDao.listByQuestionId(question.getId()));
        }
        return questions;
    }

    @Override
    @Transactional
    public QuizQuestion create(QuizQuestion quizQuestion) {
        LocalDateTime now = LocalDateTime.now();
        quizQuestion.setCreateTime(now);
        quizQuestion.setUpdateTime(now);
        quizQuestionDao.insert(quizQuestion);
        
        // 插入選項
        if (quizQuestion.getOptions() != null && !quizQuestion.getOptions().isEmpty()) {
            for (QuizOption option : quizQuestion.getOptions()) {
                option.setQuestionId(quizQuestion.getId());
                option.setCreateTime(now);
                option.setUpdateTime(now);
                quizOptionDao.insert(option);
            }
        }
        
        return quizQuestion;
    }

    @Override
    @Transactional
    public QuizQuestion update(QuizQuestion quizQuestion) {
        quizQuestion.setUpdateTime(LocalDateTime.now());
        quizQuestionDao.update(quizQuestion);
        
        // 更新選項
        if (quizQuestion.getOptions() != null) {
            // 先刪除舊選項
            quizOptionDao.deleteByQuestionId(quizQuestion.getId());
            // 再插入新選項
            LocalDateTime now = LocalDateTime.now();
            for (QuizOption option : quizQuestion.getOptions()) {
                option.setQuestionId(quizQuestion.getId());
                option.setCreateTime(now);
                option.setUpdateTime(now);
                quizOptionDao.insert(option);
            }
        }
        
        return quizQuestionDao.selectById(quizQuestion.getId());
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        // 先刪除選項
        quizOptionDao.deleteByQuestionId(id);
        // 再刪除題目
        return quizQuestionDao.delete(id) > 0;
    }

    @Override
    @Transactional
    public UserQuizRecord submitAnswer(Long questionId, String userAnswer, String userName) {
        QuizQuestion question = quizQuestionDao.selectById(questionId);
        if (question == null) {
            throw new RuntimeException("題目不存在");
        }
        
        // 檢查答案是否正確
        boolean isCorrect = question.getCorrectAnswer().equals(userAnswer);
        
        // 查詢是否已有記錄
        UserQuizRecord existingRecord = userQuizRecordDao.selectByUserNameAndQuestionId(userName, questionId);
        
        LocalDateTime now = LocalDateTime.now();
        if (existingRecord != null) {
            // 更新現有記錄
            existingRecord.setUserAnswer(userAnswer);
            existingRecord.setIsCorrect(isCorrect ? 1 : 0);
            existingRecord.setAnswerTime(now);
            existingRecord.setUpdateTime(now);
            userQuizRecordDao.update(existingRecord);
            return existingRecord;
        } else {
            // 創建新記錄
            UserQuizRecord record = new UserQuizRecord();
            record.setUserName(userName);
            record.setQuestionId(questionId);
            record.setUserAnswer(userAnswer);
            record.setIsCorrect(isCorrect ? 1 : 0);
            record.setAnswerTime(now);
            record.setCreateTime(now);
            record.setUpdateTime(now);
            userQuizRecordDao.insert(record);
            return record;
        }
    }

}
