package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.ClassMember;

import java.util.List;

/**
 * 班級成員服務接口
 *
 * @author yeletian
 * @since 2025/10/09
 */
public interface ClassMemberService {

    /**
     * 通過ID查詢班級成員
     *
     * @param id 記錄ID
     * @return 班級成員
     */
    ClassMember queryById(Long id);

    /**
     * 通過班級ID查詢所有成員
     *
     * @param classId 班級ID
     * @return 成員列表
     */
    List<ClassMember> listByClassId(Long classId);

    /**
     * 通過用戶名查詢加入的班級
     *
     * @param userName 用戶名
     * @return 班級列表
     */
    List<ClassMember> listByUserName(String userName);

    /**
     * 查詢用戶是否已加入班級
     *
     * @param classId 班級ID
     * @param userName 用戶名
     * @return 班級成員記錄
     */
    ClassMember queryByClassIdAndUserName(Long classId, String userName);

    /**
     * 統計班級成員數量
     *
     * @param classId 班級ID
     * @return 成員數量
     */
    int countByClassId(Long classId);

    /**
     * 加入班級
     *
     * @param classId 班級ID
     * @param userName 用戶名
     * @return 班級成員記錄
     */
    ClassMember joinClass(Long classId, String userName);

    /**
     * 退出班級
     *
     * @param classId 班級ID
     * @param userName 用戶名
     * @return 是否成功
     */
    boolean exitClass(Long classId, String userName);

    /**
     * 創建班級成員記錄
     *
     * @param classMember 班級成員
     * @return 班級成員記錄
     */
    ClassMember create(ClassMember classMember);

    /**
     * 更新班級成員記錄
     *
     * @param classMember 班級成員
     * @return 班級成員記錄
     */
    ClassMember update(ClassMember classMember);

    /**
     * 刪除班級成員記錄
     *
     * @param id 記錄ID
     * @return 是否成功
     */
    boolean delete(Long id);
}
