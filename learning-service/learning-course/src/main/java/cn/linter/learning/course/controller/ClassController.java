package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Page;
import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.common.utils.JwtUtil;
import cn.linter.learning.course.entity.Class;
import cn.linter.learning.course.service.ClassService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级控制器
 *
 * @author yeletian
 * @since 2025/10/08
 */
@RestController
@RequestMapping("classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("{id}")
    public Result<Class> queryClass(@PathVariable("id") Long id) {
        return Result.of(ResultStatus.SUCCESS, classService.queryById(id));
    }

    @GetMapping
    public Result<Page<Class>> listClasses(@RequestParam(defaultValue = "1") int pageNum, 
                                          @RequestParam(defaultValue = "10") int pageSize,
                                          @RequestParam(required = false) Boolean enabled,
                                          @RequestParam(required = false) String orderBy) {
        List<Class> classes = classService.list(enabled, orderBy);
        
        // 手动分页
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, classes.size());
        List<Class> pageClasses = classes.subList(start, end);
        
        return Result.of(ResultStatus.SUCCESS, Page.of(pageClasses, (long) classes.size()));
    }

    @PostMapping
    public Result<Class> createClass(@RequestBody Class classEntity, @RequestHeader("Authorization") String token) {
        return Result.of(ResultStatus.SUCCESS, classService.create(classEntity, JwtUtil.getUsername(token)));
    }

    @PutMapping
    public Result<Class> updateClass(@RequestBody Class classEntity) {
        return Result.of(ResultStatus.SUCCESS, classService.update(classEntity));
    }

    @DeleteMapping("{id}")
    public ResultStatus deleteClass(@PathVariable("id") Long id) {
        classService.delete(id);
        return ResultStatus.SUCCESS;
    }

    @PostMapping("{id}/enroll")
    public ResultStatus enrollClass(@PathVariable("id") Long id) {
        classService.incrementStudentCount(id);
        return ResultStatus.SUCCESS;
    }
}
