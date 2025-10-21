package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.NoticeDao;
import cn.linter.learning.course.entity.Notice;
import cn.linter.learning.course.service.NoticeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 通知服务实现类
 *
 * @author yeletian
 * @since 2025/10/08
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDao noticeDao;

    public NoticeServiceImpl(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    @Override
    public Notice queryById(Long id) {
        return noticeDao.queryById(id);
    }

    @Override
    public List<Notice> list(Boolean enabled, String orderBy) {
        return noticeDao.list(enabled, orderBy);
    }

    @Override
    public Notice create(Notice notice, String username) {
        notice.setCreator(username)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setViewCount(0)
                .setEnabled(true);
        noticeDao.create(notice);
        return notice;
    }

    @Override
    public Notice update(Notice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        noticeDao.update(notice);
        return notice;
    }

    @Override
    public void delete(Long id) {
        noticeDao.delete(id);
    }

    @Override
    public void incrementViewCount(Long id) {
        noticeDao.incrementViewCount(id);
    }
}
