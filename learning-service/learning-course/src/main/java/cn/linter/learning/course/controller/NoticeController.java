package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Page;
import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.common.utils.JwtUtil;
import cn.linter.learning.course.entity.Notice;
import cn.linter.learning.course.service.NoticeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通知控制器
 *
 * @author yeletian
 * @since 2025/10/08
 */
@RestController
@RequestMapping("notices")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("{id}")
    public Result<Notice> queryNotice(@PathVariable("id") Long id) {
        // 增加浏览次数
        noticeService.incrementViewCount(id);
        return Result.of(ResultStatus.SUCCESS, noticeService.queryById(id));
    }

    @GetMapping
    public Result<Page<Notice>> listNotices(@RequestParam(defaultValue = "1") int pageNum, 
                                           @RequestParam(defaultValue = "10") int pageSize,
                                           @RequestParam(required = false) Boolean enabled,
                                           @RequestParam(required = false) String orderBy) {
        List<Notice> notices = noticeService.list(enabled, orderBy);
        
        // 手动分页
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, notices.size());
        List<Notice> pageNotices = notices.subList(start, end);
        
        return Result.of(ResultStatus.SUCCESS, Page.of(pageNotices, (long) notices.size()));
    }

    @PostMapping
    public Result<Notice> createNotice(@RequestBody Notice notice, @RequestHeader("Authorization") String token) {
        return Result.of(ResultStatus.SUCCESS, noticeService.create(notice, JwtUtil.getUsername(token)));
    }

    @PutMapping
    public Result<Notice> updateNotice(@RequestBody Notice notice) {
        return Result.of(ResultStatus.SUCCESS, noticeService.update(notice));
    }

    @DeleteMapping("{id}")
    public ResultStatus deleteNotice(@PathVariable("id") Long id) {
        noticeService.delete(id);
        return ResultStatus.SUCCESS;
    }
}
