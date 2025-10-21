-- 班级表
CREATE TABLE IF NOT EXISTS class (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    name VARCHAR(255) NOT NULL COMMENT '班级名称',
    description TEXT COMMENT '班级描述',
    cover_picture VARCHAR(500) COMMENT '封面图片',
    price DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '价格',
    course_count INT DEFAULT 0 COMMENT '课程数量',
    student_count INT DEFAULT 0 COMMENT '学员数量',
    average_score DECIMAL(3,2) DEFAULT 0.00 COMMENT '平均评分',
    enabled BOOLEAN DEFAULT TRUE COMMENT '是否启用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator VARCHAR(100) COMMENT '创建者',
    updater VARCHAR(100) COMMENT '更新者'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班级表';

-- 插入示例数据
INSERT INTO class (name, description, cover_picture, price, course_count, student_count, average_score, creator) VALUES
('前端開發入門班', '從零開始學習前端開發，包含HTML、CSS、JavaScript基礎知識', '/static/banners/banner1.jpg', 299.00, 12, 1250, 4.80, 'admin'),
('Vue.js 實戰班', '深入學習Vue.js框架，掌握現代前端開發技能', '/static/banners/banner2.jpg', 0.00, 8, 890, 4.90, 'admin'),
('全棧開發班', '學習前後端開發，成為全棧工程師', '/static/banners/banner3.jpg', 599.00, 20, 567, 4.70, 'admin'),
('Python 數據分析班', '學習Python進行數據分析和機器學習', '/static/banners/banner4.jpg', 399.00, 15, 678, 4.60, 'admin'),
('React 進階班', '深入學習React生態系統，掌握高級開發技巧', '/static/banners/banner5.jpg', 499.00, 10, 456, 4.85, 'admin'),
('Node.js 後端開發班', '學習Node.js進行後端開發，掌握全棧技能', '/static/banners/banner1.jpg', 599.00, 18, 789, 4.75, 'admin'),
('移動端開發班', '學習React Native和Flutter進行移動端開發', '/static/banners/banner2.jpg', 699.00, 16, 345, 4.65, 'admin'),
('雲計算與DevOps班', '學習雲計算平台和DevOps實踐', '/static/banners/banner3.jpg', 799.00, 22, 234, 4.55, 'admin');
