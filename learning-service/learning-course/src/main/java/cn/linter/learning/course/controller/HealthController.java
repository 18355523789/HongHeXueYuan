package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 健康檢查控制器
 *
 * @author yeletian
 * @since 2025/10/07
 */
@RestController
@RequestMapping("health")
public class HealthController {

    @GetMapping
    public Result<Map<String, Object>> health() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "course-service");
        health.put("timestamp", LocalDateTime.now());
        health.put("quiz", "QuizController is available");
        return Result.of(ResultStatus.SUCCESS, health);
    }

    @GetMapping("quiz")
    public Result<String> quizHealth() {
        return Result.of(ResultStatus.SUCCESS, "Quiz API is working");
    }
}
