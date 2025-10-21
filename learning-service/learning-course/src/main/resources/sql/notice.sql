-- 通知表
CREATE TABLE IF NOT EXISTS notice (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    title VARCHAR(255) NOT NULL COMMENT '标题',
    summary TEXT COMMENT '摘要',
    content LONGTEXT COMMENT '内容',
    type VARCHAR(50) NOT NULL COMMENT '类型：notice-通知, guide-指南, event-活动, maintenance-维护, policy-政策',
    enabled BOOLEAN DEFAULT TRUE COMMENT '是否启用',
    view_count INT DEFAULT 0 COMMENT '浏览次数',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator VARCHAR(100) COMMENT '创建者',
    updater VARCHAR(100) COMMENT '更新者'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通知表';

-- 插入示例数据
INSERT INTO notice (title, summary, content, type, enabled, view_count, creator) VALUES
('公司年度培訓計劃發布', '2024年度員工培訓計劃已正式發布，包含多個專業技能提升課程...', '詳細的培訓計劃內容...', 'notice', TRUE, 1250, 'admin'),
('新員工入職指南', '歡迎新同事加入！請查看入職指南了解公司文化、制度和工作流程...', '入職指南詳細內容...', 'guide', TRUE, 890, 'admin'),
('技術分享會通知', '本週五下午2點將舉行技術分享會，主題：前端開發最佳實踐...', '技術分享會詳細信息...', 'event', TRUE, 567, 'admin'),
('系統維護公告', '本週末系統將進行例行維護，預計停機時間：週六晚10點至週日凌晨2點...', '系統維護詳細安排...', 'maintenance', TRUE, 234, 'admin'),
('員工福利政策更新', '公司員工福利政策已更新，新增多項福利項目，詳情請查看內部通知...', '福利政策更新詳情...', 'policy', TRUE, 678, 'admin');
