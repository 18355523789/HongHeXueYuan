package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.common.utils.JwtUtil;
import cn.linter.learning.course.entity.QuizQuestion;
import cn.linter.learning.course.entity.UserQuizRecord;
import cn.linter.learning.course.service.QuizQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 題目控制器
 *
 * @author yeletian
 * @since 2025/10/07
 */
@RestController
@RequestMapping("quiz")
public class QuizController {

    private final QuizQuestionService quizQuestionService;

    public QuizController(QuizQuestionService quizQuestionService) {
        this.quizQuestionService = quizQuestionService;
    }

    @GetMapping("all")
    public Result<List<QuizQuestion>> getAllQuizQuestions(@RequestParam(required = false) Long courseId,
                                                         @RequestParam(required = false) Integer difficultyLevel,
                                                         @RequestParam(required = false) String questionType,
                                                         @RequestParam(defaultValue = "1") int pageNum,
                                                         @RequestParam(defaultValue = "10") int pageSize) {
        // 如果指定了課程ID，返回該課程的題目
        if (courseId != null) {
            return Result.of(ResultStatus.SUCCESS, quizQuestionService.listByCourseId(courseId, difficultyLevel));
        }
        // 否則返回所有題目（這裡可以根據需要實現分頁）
        return Result.of(ResultStatus.SUCCESS, quizQuestionService.listByCourseId(null, difficultyLevel));
    }

    @GetMapping("{id}")
    public Result<QuizQuestion> queryQuizQuestion(@PathVariable("id") Long id) {
        return Result.of(ResultStatus.SUCCESS, quizQuestionService.queryById(id));
    }

    @GetMapping("course/{courseId}")
    public Result<List<QuizQuestion>> listQuizQuestionsByCourseId(@PathVariable("courseId") Long courseId,
                                                                  @RequestParam(required = false) Integer difficultyLevel) {
        return Result.of(ResultStatus.SUCCESS, quizQuestionService.listByCourseId(courseId, difficultyLevel));
    }

    @GetMapping("course/{courseId}/random")
    public Result<List<QuizQuestion>> listRandomQuizQuestionsByCourseId(@PathVariable("courseId") Long courseId,
                                                                       @RequestParam(defaultValue = "10") Integer limit,
                                                                       @RequestParam(required = false) Integer difficultyLevel) {
        return Result.of(ResultStatus.SUCCESS, quizQuestionService.listRandomByCourseId(courseId, limit, difficultyLevel));
    }

    @PostMapping
    public Result<QuizQuestion> createQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
        return Result.of(ResultStatus.SUCCESS, quizQuestionService.create(quizQuestion));
    }

    @PutMapping
    public Result<QuizQuestion> updateQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
        return Result.of(ResultStatus.SUCCESS, quizQuestionService.update(quizQuestion));
    }

    @DeleteMapping("{id}")
    public ResultStatus deleteQuizQuestion(@PathVariable("id") Long id) {
        quizQuestionService.delete(id);
        return ResultStatus.SUCCESS;
    }

    @PostMapping("{questionId}/submit")
    public Result<UserQuizRecord> submitAnswer(@PathVariable("questionId") Long questionId,
                                              @RequestBody AnswerRequest answerRequest,
                                              @RequestHeader("Authorization") String token) {
        String username = JwtUtil.getUsername(token);
        return Result.of(ResultStatus.SUCCESS, quizQuestionService.submitAnswer(questionId, answerRequest.getAnswer(), username));
    }

    /**
     * 答案提交請求類
     */
    public static class AnswerRequest {
        private String answer;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }

}
