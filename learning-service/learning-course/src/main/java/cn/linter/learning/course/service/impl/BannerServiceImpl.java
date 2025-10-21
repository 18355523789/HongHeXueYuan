package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.BannerDao;
import cn.linter.learning.course.entity.Banner;
import cn.linter.learning.course.service.BannerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    private final BannerDao bannerDao;

    public BannerServiceImpl(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

    @Override
    public Banner queryById(Long id) {
        return bannerDao.selectById(id);
    }

    @Override
    public List<Banner> list(Boolean enabled) {
        return bannerDao.list(enabled);
    }

    @Override
    public Banner create(Banner banner) {
        LocalDateTime now = LocalDateTime.now();
        banner.setCreateTime(now);
        banner.setUpdateTime(now);
        if (banner.getEnabled() == null) banner.setEnabled(true);
        if (banner.getSort() == null) banner.setSort(0);
        bannerDao.insert(banner);
        return banner;
    }

    @Override
    public Banner update(Banner banner) {
        banner.setUpdateTime(LocalDateTime.now());
        bannerDao.update(banner);
        return bannerDao.selectById(banner.getId());
    }

    @Override
    public boolean delete(Long id) {
        return bannerDao.delete(id) > 0;
    }
}


