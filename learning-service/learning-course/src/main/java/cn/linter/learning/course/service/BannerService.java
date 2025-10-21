package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.Banner;

import java.util.List;

public interface BannerService {
    Banner queryById(Long id);
    List<Banner> list(Boolean enabled);
    Banner create(Banner banner);
    Banner update(Banner banner);
    boolean delete(Long id);
}


