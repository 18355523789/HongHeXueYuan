package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Page;
import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.common.utils.JwtUtil;
import cn.linter.learning.course.entity.ClassCourse;
import cn.linter.learning.course.service.ClassCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级课程控制器
 *
 * @author yeletian
 * @since 2025/10/07
 */
@RestController
@RequestMapping("classes/{classId}/courses")
public class ClassCourseController {

    private final ClassCourseService classCourseService;

    public ClassCourseController(ClassCourseService classCourseService) {
        this.classCourseService = classCourseService;
    }

    @GetMapping
    public Result<Page<ClassCourse>> listClassCourses(@PathVariable("classId") Long classId,
                                                     @RequestParam(defaultValue = "1") int pageNum,
                                                     @RequestParam(defaultValue = "10") int pageSize) {
        List<ClassCourse> courses = classCourseService.listByClassId(classId);
        
        // 手动分页
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, courses.size());
        List<ClassCourse> pageCourses = courses.subList(start, end);
        
        return Result.of(ResultStatus.SUCCESS, Page.of(pageCourses, (long) courses.size()));
    }

    @PostMapping
    public Result<ClassCourse> addCourseToClass(@PathVariable("classId") Long classId,
                                               @RequestBody ClassCourse classCourse,
                                               @RequestHeader("Authorization") String token) {
        classCourse.setClassId(classId);
        return Result.of(ResultStatus.SUCCESS, classCourseService.create(classCourse));
    }

    @PostMapping("batch")
    public ResultStatus batchUpdateClassCourses(@PathVariable("classId") Long classId,
                                              @RequestBody UpdateClassCoursesRequest request,
                                              @RequestHeader("Authorization") String token) {
        classCourseService.updateClassCourses(classId, request.getCourseIds());
        return ResultStatus.SUCCESS;
    }

    @DeleteMapping("{courseId}")
    public ResultStatus removeCourseFromClass(@PathVariable("classId") Long classId,
                                             @PathVariable("courseId") Long courseId) {
        classCourseService.delete(classId, courseId);
        return ResultStatus.SUCCESS;
    }

    @PutMapping
    public ResultStatus updateClassCourses(@PathVariable("classId") Long classId,
                                         @RequestBody UpdateClassCoursesRequest request,
                                         @RequestHeader("Authorization") String token) {
        classCourseService.updateClassCourses(classId, request.getCourseIds());
        return ResultStatus.SUCCESS;
    }

    @PostMapping("update")
    public ResultStatus updateClassCoursesByPost(@PathVariable("classId") Long classId,
                                               @RequestBody UpdateClassCoursesRequest request,
                                               @RequestHeader("Authorization") String token) {
        classCourseService.updateClassCourses(classId, request.getCourseIds());
        return ResultStatus.SUCCESS;
    }

    /**
     * 更新班級課程請求
     */
    public static class UpdateClassCoursesRequest {
        private List<Long> courseIds;

        public List<Long> getCourseIds() {
            return courseIds;
        }

        public void setCourseIds(List<Long> courseIds) {
            this.courseIds = courseIds;
        }
    }
}
