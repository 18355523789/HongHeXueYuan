-- 班級成員關聯表
CREATE TABLE class_member
(
    id bigint auto_increment comment '記錄ID'
        primary key,
    class_id bigint not null comment '班級ID',
    user_name varchar(20) not null comment '用戶名',
    join_time datetime not null comment '加入時間',
    status tinyint default 1 comment '狀態：0-已退出，1-正常',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間',
    creator varchar(20) null comment '創建者',
    updater varchar(20) null comment '更新者'
)
    comment '班級成員關聯表';

-- 添加索引
CREATE INDEX idx_class_member_class_id ON class_member(class_id);
CREATE INDEX idx_class_member_user_name ON class_member(user_name);
CREATE INDEX idx_class_member_status ON class_member(status);

-- 添加唯一約束，防止重複加入
ALTER TABLE class_member ADD CONSTRAINT uk_class_member_class_user UNIQUE (class_id, user_name);

-- 插入示例數據
INSERT INTO class_member (class_id, user_name, join_time, status, create_time, update_time, creator, updater) VALUES
(1, 'admin', '2024-01-15 10:00:00', 1, '2024-01-15 10:00:00', '2024-01-15 10:00:00', 'admin', 'admin'),
(1, 'student1', '2024-01-16 09:30:00', 1, '2024-01-16 09:30:00', '2024-01-16 09:30:00', 'student1', 'student1'),
(1, 'student2', '2024-01-17 14:20:00', 1, '2024-01-17 14:20:00', '2024-01-17 14:20:00', 'student2', 'student2'),
(2, 'admin', '2024-01-18 11:15:00', 1, '2024-01-18 11:15:00', '2024-01-18 11:15:00', 'admin', 'admin'),
(2, 'student3', '2024-01-19 16:45:00', 1, '2024-01-19 16:45:00', '2024-01-19 16:45:00', 'student3', 'student3'),
(3, 'student4', '2024-01-20 08:30:00', 1, '2024-01-20 08:30:00', '2024-01-20 08:30:00', 'student4', 'student4');
