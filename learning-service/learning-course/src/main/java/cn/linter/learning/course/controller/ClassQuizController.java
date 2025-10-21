package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Page;
import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.common.utils.JwtUtil;
import cn.linter.learning.course.entity.ClassQuiz;
import cn.linter.learning.course.service.ClassQuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级测试控制器
 *
 * @author yeletian
 * @since 2025/10/09
 */
@RestController
@RequestMapping("classes/{classId}/quiz")
public class ClassQuizController {

    private final ClassQuizService classQuizService;

    public ClassQuizController(ClassQuizService classQuizService) {
        this.classQuizService = classQuizService;
    }

    @GetMapping
    public Result<Page<ClassQuiz>> listClassQuizzes(@PathVariable("classId") Long classId,
                                                    @RequestParam(defaultValue = "1") int pageNum,
                                                    @RequestParam(defaultValue = "10") int pageSize) {
        List<ClassQuiz> quizzes = classQuizService.listByClassId(classId);
        
        // 手动分页
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, quizzes.size());
        List<ClassQuiz> pageQuizzes = quizzes.subList(start, end);
        
        return Result.of(ResultStatus.SUCCESS, Page.of(pageQuizzes, (long) quizzes.size()));
    }

    @GetMapping("{id}")
    public Result<ClassQuiz> getQuiz(@PathVariable("id") Long id) {
        return Result.of(ResultStatus.SUCCESS, classQuizService.queryById(id));
    }

    @PostMapping
    public Result<ClassQuiz> createQuiz(@PathVariable("classId") Long classId,
                                       @RequestBody ClassQuiz quiz,
                                       @RequestHeader("Authorization") String token) {
        quiz.setClassId(classId);
        return Result.of(ResultStatus.SUCCESS, classQuizService.create(quiz, JwtUtil.getUsername(token)));
    }

    @PutMapping
    public Result<ClassQuiz> updateQuiz(@RequestBody ClassQuiz quiz) {
        return Result.of(ResultStatus.SUCCESS, classQuizService.update(quiz));
    }

    @DeleteMapping("{id}")
    public ResultStatus deleteQuiz(@PathVariable("id") Long id) {
        classQuizService.delete(id);
        return ResultStatus.SUCCESS;
    }

    @PostMapping("{id}/attempt")
    public ResultStatus attemptQuiz(@PathVariable("id") Long id) {
        classQuizService.incrementAttemptCount(id);
        return ResultStatus.SUCCESS;
    }
}
