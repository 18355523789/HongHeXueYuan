package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Page;
import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.common.utils.JwtUtil;
import cn.linter.learning.course.entity.ClassMember;
import cn.linter.learning.course.service.ClassMemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班級成員控制器
 *
 * @author yeletian
 * @since 2025/10/09
 */
@RestController
@RequestMapping("classes/{classId}/members")
public class ClassMemberController {

    private final ClassMemberService classMemberService;

    public ClassMemberController(ClassMemberService classMemberService) {
        this.classMemberService = classMemberService;
    }

    /**
     * 查詢班級成員列表
     */
    @GetMapping
    public Result<Page<ClassMember>> listClassMembers(@PathVariable("classId") Long classId,
                                                      @RequestParam(defaultValue = "1") int pageNum,
                                                      @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ClassMember> members = classMemberService.listByClassId(classId);
        PageInfo<ClassMember> pageInfo = PageInfo.of(members);
        return Result.of(ResultStatus.SUCCESS, Page.of(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 查詢用戶加入的班級
     */
    @GetMapping("user/{userName}")
    public Result<List<ClassMember>> listUserClasses(@PathVariable("userName") String userName) {
        List<ClassMember> classes = classMemberService.listByUserName(userName);
        return Result.of(ResultStatus.SUCCESS, classes);
    }

    /**
     * 查詢用戶是否已加入班級
     */
    @GetMapping("check/{userName}")
    public Result<ClassMember> checkMemberStatus(@PathVariable("classId") Long classId,
                                                @PathVariable("userName") String userName) {
        ClassMember member = classMemberService.queryByClassIdAndUserName(classId, userName);
        return Result.of(ResultStatus.SUCCESS, member);
    }

    /**
     * 統計班級成員數量
     */
    @GetMapping("count")
    public Result<Integer> countClassMembers(@PathVariable("classId") Long classId) {
        int count = classMemberService.countByClassId(classId);
        return Result.of(ResultStatus.SUCCESS, count);
    }

    /**
     * 加入班級
     */
    @PostMapping("join")
    public Result<ClassMember> joinClass(@PathVariable("classId") Long classId,
                                        @RequestHeader("Authorization") String token) {
        String userName = JwtUtil.getUsername(token);
        ClassMember member = classMemberService.joinClass(classId, userName);
        return Result.of(ResultStatus.SUCCESS, member);
    }

    /**
     * 退出班級
     */
    @PostMapping("exit")
    public ResultStatus exitClass(@PathVariable("classId") Long classId,
                                 @RequestHeader("Authorization") String token) {
        String userName = JwtUtil.getUsername(token);
        boolean success = classMemberService.exitClass(classId, userName);
        return success ? ResultStatus.SUCCESS : ResultStatus.ARGUMENT_NOT_VALID;
    }

    /**
     * 創建班級成員記錄（管理員用）
     */
    @PostMapping
    public Result<ClassMember> createClassMember(@PathVariable("classId") Long classId,
                                                @RequestBody ClassMember classMember,
                                                @RequestHeader("Authorization") String token) {
        classMember.setClassId(classId);
        classMember.setCreator(JwtUtil.getUsername(token));
        return Result.of(ResultStatus.SUCCESS, classMemberService.create(classMember));
    }

    /**
     * 更新班級成員記錄
     */
    @PutMapping
    public Result<ClassMember> updateClassMember(@RequestBody ClassMember classMember,
                                                @RequestHeader("Authorization") String token) {
        classMember.setUpdater(JwtUtil.getUsername(token));
        return Result.of(ResultStatus.SUCCESS, classMemberService.update(classMember));
    }

    /**
     * 刪除班級成員記錄
     */
    @DeleteMapping("{id}")
    public ResultStatus deleteClassMember(@PathVariable("id") Long id) {
        boolean success = classMemberService.delete(id);
        return success ? ResultStatus.SUCCESS : ResultStatus.ARGUMENT_NOT_VALID;
    }
}
