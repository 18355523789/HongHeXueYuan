package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerDao {

    Banner selectById(Long id);

    List<Banner> list(Boolean enabled);

    int insert(Banner banner);

    int update(Banner banner);

    int delete(Long id);
}


