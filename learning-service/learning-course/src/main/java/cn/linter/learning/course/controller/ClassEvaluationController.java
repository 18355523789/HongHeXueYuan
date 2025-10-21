package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Page;
import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.common.utils.JwtUtil;
import cn.linter.learning.course.entity.ClassEvaluation;
import cn.linter.learning.course.service.ClassEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级评价控制器
 *
 * @author yeletian
 * @since 2025/10/09
 */
@RestController
@RequestMapping("classes/{classId}/evaluations")
public class ClassEvaluationController {

    private final ClassEvaluationService classEvaluationService;

    public ClassEvaluationController(ClassEvaluationService classEvaluationService) {
        this.classEvaluationService = classEvaluationService;
    }

    @GetMapping
    public Result<Page<ClassEvaluation>> listClassEvaluations(@PathVariable("classId") Long classId,
                                                             @RequestParam(defaultValue = "1") int pageNum,
                                                             @RequestParam(defaultValue = "10") int pageSize) {
        List<ClassEvaluation> evaluations = classEvaluationService.listByClassId(classId);
        
        // 手动分页
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, evaluations.size());
        List<ClassEvaluation> pageEvaluations = evaluations.subList(start, end);
        
        return Result.of(ResultStatus.SUCCESS, Page.of(pageEvaluations, (long) evaluations.size()));
    }

    @PostMapping
    public Result<ClassEvaluation> createEvaluation(@PathVariable("classId") Long classId,
                                                   @RequestBody ClassEvaluation evaluation,
                                                   @RequestHeader("Authorization") String token) {
        evaluation.setClassId(classId);
        return Result.of(ResultStatus.SUCCESS, classEvaluationService.create(evaluation, JwtUtil.getUsername(token)));
    }

    @PutMapping
    public Result<ClassEvaluation> updateEvaluation(@RequestBody ClassEvaluation evaluation) {
        return Result.of(ResultStatus.SUCCESS, classEvaluationService.update(evaluation));
    }

    @DeleteMapping("{id}")
    public ResultStatus deleteEvaluation(@PathVariable("id") Long id) {
        classEvaluationService.delete(id);
        return ResultStatus.SUCCESS;
    }
}
