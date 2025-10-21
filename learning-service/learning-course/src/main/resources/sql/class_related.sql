-- 班级课程关联表
CREATE TABLE IF NOT EXISTS class_course (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    class_id BIGINT NOT NULL COMMENT '班级ID',
    course_id BIGINT NOT NULL COMMENT '课程ID',
    order_index INT DEFAULT 0 COMMENT '课程顺序',
    enabled BOOLEAN DEFAULT TRUE COMMENT '是否启用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator VARCHAR(100) COMMENT '创建者',
    updater VARCHAR(100) COMMENT '更新者',
    UNIQUE KEY uk_class_course (class_id, course_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班级课程关联表';

-- 班级评价表
CREATE TABLE IF NOT EXISTS class_evaluation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    class_id BIGINT NOT NULL COMMENT '班级ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    username VARCHAR(100) COMMENT '用户名',
    user_avatar VARCHAR(500) COMMENT '用户头像',
    score INT NOT NULL COMMENT '评分(1-5)',
    content TEXT COMMENT '评价内容',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班级评价表';

-- 班级测试表
CREATE TABLE IF NOT EXISTS class_quiz (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    class_id BIGINT NOT NULL COMMENT '班级ID',
    title VARCHAR(255) NOT NULL COMMENT '测试标题',
    description TEXT COMMENT '测试描述',
    question_count INT DEFAULT 0 COMMENT '题目数量',
    duration INT DEFAULT 0 COMMENT '测试时长(分钟)',
    attempt_count INT DEFAULT 0 COMMENT '尝试次数',
    enabled BOOLEAN DEFAULT TRUE COMMENT '是否启用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator VARCHAR(100) COMMENT '创建者',
    updater VARCHAR(100) COMMENT '更新者'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班级测试表';

-- 插入示例数据

-- 班级课程关联数据
INSERT INTO class_course (class_id, course_id, order_index, creator) VALUES
(1, 1, 1, 'admin'),
(1, 2, 2, 'admin'),
(1, 3, 3, 'admin'),
(2, 4, 1, 'admin'),
(2, 5, 2, 'admin'),
(3, 6, 1, 'admin'),
(3, 7, 2, 'admin'),
(3, 8, 3, 'admin');

-- 班级评价数据
INSERT INTO class_evaluation (class_id, user_id, username, user_avatar, score, content) VALUES
(1, 1, '張三', '', 5, '課程內容很豐富，老師講解詳細，適合初學者學習。'),
(1, 2, '李四', '', 4, '整體不錯，但希望能增加更多實戰項目。'),
(1, 3, '王五', '', 5, '非常棒的課程，學到了很多實用的技能。'),
(2, 4, '趙六', '', 5, 'Vue.js 課程講解得很清楚，推薦！'),
(2, 5, '孫七', '', 4, '課程質量很高，值得學習。'),
(3, 6, '周八', '', 5, '全棧開發課程很全面，收穫很大。');

-- 班级测试数据
INSERT INTO class_quiz (class_id, title, description, question_count, duration, attempt_count, creator) VALUES
(1, 'HTML基礎測試', '測試HTML基礎知識掌握程度', 20, 30, 156, 'admin'),
(1, 'CSS樣式測試', '測試CSS樣式設計能力', 25, 45, 134, 'admin'),
(2, 'Vue.js 基礎測試', '測試Vue.js基礎知識', 30, 60, 89, 'admin'),
(2, 'Vue.js 進階測試', '測試Vue.js進階知識', 35, 75, 67, 'admin'),
(3, '全棧開發綜合測試', '測試全棧開發綜合能力', 50, 120, 45, 'admin'),
(3, '後端API設計測試', '測試後端API設計能力', 25, 60, 23, 'admin');
