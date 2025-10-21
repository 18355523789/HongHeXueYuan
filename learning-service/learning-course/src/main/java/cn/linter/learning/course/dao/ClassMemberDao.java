package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.ClassMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 班級成員DAO接口
 *
 * @author yeletian
 * @since 2025/10/07
 */
@Mapper
public interface ClassMemberDao {

    /**
     * 通過ID查詢班級成員
     *
     * @param id 記錄ID
     * @return 班級成員
     */
    ClassMember selectById(@Param("id") Long id);

    /**
     * 通過班級ID查詢所有成員
     *
     * @param classId 班級ID
     * @return 成員列表
     */
    List<ClassMember> listByClassId(@Param("classId") Long classId);

    /**
     * 通過用戶名查詢加入的班級
     *
     * @param userName 用戶名
     * @return 班級列表
     */
    List<ClassMember> listByUserName(@Param("userName") String userName);

    /**
     * 查詢用戶是否已加入班級
     *
     * @param classId 班級ID
     * @param userName 用戶名
     * @return 班級成員記錄
     */
    ClassMember selectByClassIdAndUserName(@Param("classId") Long classId, @Param("userName") String userName);

    /**
     * 統計班級成員數量
     *
     * @param classId 班級ID
     * @return 成員數量
     */
    int countByClassId(@Param("classId") Long classId);

    /**
     * 新增班級成員
     *
     * @param classMember 班級成員
     * @return 影響行數
     */
    int insert(ClassMember classMember);

    /**
     * 更新班級成員
     *
     * @param classMember 班級成員
     * @return 影響行數
     */
    int update(ClassMember classMember);

    /**
     * 刪除班級成員
     *
     * @param id 記錄ID
     * @return 影響行數
     */
    int delete(@Param("id") Long id);

    /**
     * 用戶退出班級
     *
     * @param classId 班級ID
     * @param userName 用戶名
     * @return 影響行數
     */
    int exitClass(@Param("classId") Long classId, @Param("userName") String userName);
}
