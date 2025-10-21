package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.ClassMemberDao;
import cn.linter.learning.course.entity.ClassMember;
import cn.linter.learning.course.service.ClassMemberService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 班級成員服務實現類
 *
 * @author yeletian
 * @since 2025/10/09
 */
@Service
public class ClassMemberServiceImpl implements ClassMemberService {

    private final ClassMemberDao classMemberDao;

    public ClassMemberServiceImpl(ClassMemberDao classMemberDao) {
        this.classMemberDao = classMemberDao;
    }

    @Override
    public ClassMember queryById(Long id) {
        return classMemberDao.selectById(id);
    }

    @Override
    public List<ClassMember> listByClassId(Long classId) {
        return classMemberDao.listByClassId(classId);
    }

    @Override
    public List<ClassMember> listByUserName(String userName) {
        return classMemberDao.listByUserName(userName);
    }

    @Override
    public ClassMember queryByClassIdAndUserName(Long classId, String userName) {
        return classMemberDao.selectByClassIdAndUserName(classId, userName);
    }

    @Override
    public int countByClassId(Long classId) {
        return classMemberDao.countByClassId(classId);
    }

    @Override
    public ClassMember joinClass(Long classId, String userName) {
        // 檢查是否已經加入
        ClassMember existingMember = classMemberDao.selectByClassIdAndUserName(classId, userName);
        if (existingMember != null) {
            if (existingMember.getStatus() == 0) {
                // 如果之前退出過，重新激活
                existingMember.setStatus(1);
                existingMember.setJoinTime(LocalDateTime.now());
                existingMember.setUpdateTime(LocalDateTime.now());
                existingMember.setUpdater(userName);
                classMemberDao.update(existingMember);
                return existingMember;
            } else {
                // 已經在班級中
                return existingMember;
            }
        }

        // 創建新的成員記錄
        ClassMember classMember = new ClassMember()
                .setClassId(classId)
                .setUserName(userName)
                .setJoinTime(LocalDateTime.now())
                .setStatus(1)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setCreator(userName)
                .setUpdater(userName);

        classMemberDao.insert(classMember);
        return classMember;
    }

    @Override
    public boolean exitClass(Long classId, String userName) {
        return classMemberDao.exitClass(classId, userName) > 0;
    }

    @Override
    public ClassMember create(ClassMember classMember) {
        LocalDateTime now = LocalDateTime.now();
        classMember.setCreateTime(now);
        classMember.setUpdateTime(now);
        classMemberDao.insert(classMember);
        return classMember;
    }

    @Override
    public ClassMember update(ClassMember classMember) {
        classMember.setUpdateTime(LocalDateTime.now());
        classMemberDao.update(classMember);
        return classMemberDao.selectById(classMember.getId());
    }

    @Override
    public boolean delete(Long id) {
        return classMemberDao.delete(id) > 0;
    }
}
