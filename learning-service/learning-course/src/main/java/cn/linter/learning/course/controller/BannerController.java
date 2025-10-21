package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.course.entity.Banner;
import cn.linter.learning.course.service.BannerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("banners")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping
    public Result<List<Banner>> list(@RequestParam(required = false) Boolean enabled) {
        return Result.of(ResultStatus.SUCCESS, bannerService.list(enabled));
    }

    @GetMapping("{id}")
    public Result<Banner> query(@PathVariable("id") Long id) {
        return Result.of(ResultStatus.SUCCESS, bannerService.queryById(id));
    }

    @PostMapping
    public Result<Banner> create(@RequestBody Banner banner) {
        return Result.of(ResultStatus.SUCCESS, bannerService.create(banner));
    }

    @PutMapping
    public Result<Banner> update(@RequestBody Banner banner) {
        return Result.of(ResultStatus.SUCCESS, bannerService.update(banner));
    }

    @DeleteMapping("{id}")
    public ResultStatus delete(@PathVariable("id") Long id) {
        bannerService.delete(id);
        return ResultStatus.SUCCESS;
    }
}


