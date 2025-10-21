-- 簡化版本的刷題功能數據庫腳本（無外鍵約束）
-- 避免外鍵約束錯誤，使用應用層保證數據一致性

-- 1. 創建題目表
CREATE TABLE IF NOT EXISTS quiz_question
(
    id bigint auto_increment comment '題目ID'
        primary key,
    course_id bigint not null comment '課程ID',
    question_text text not null comment '題目內容',
    question_type varchar(10) not null comment '題目類型：single(單選), multiple(多選), judge(判斷)',
    correct_answer varchar(500) not null comment '正確答案',
    explanation text null comment '答案解析',
    difficulty_level tinyint default 1 comment '難度等級：1-簡單，2-中等，3-困難',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間'
)
    comment '題目表';

-- 2. 創建選項表
CREATE TABLE IF NOT EXISTS quiz_option
(
    id bigint auto_increment comment '選項ID'
        primary key,
    question_id bigint not null comment '題目ID',
    option_text varchar(500) not null comment '選項內容',
    option_key varchar(2) not null comment '選項標識：A, B, C, D等',
    is_correct tinyint default 0 comment '是否正確選項：0-否，1-是',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間'
)
    comment '選項表';

-- 3. 創建用戶答題記錄表
CREATE TABLE IF NOT EXISTS user_quiz_record
(
    id bigint auto_increment comment '記錄ID'
        primary key,
    user_name varchar(20) not null comment '用戶名',
    question_id bigint not null comment '題目ID',
    user_answer varchar(500) null comment '用戶答案',
    is_correct tinyint not null comment '是否正確：0-錯誤，1-正確',
    answer_time datetime not null comment '答題時間',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間'
)
    comment '用戶答題記錄表';

-- 4. 添加索引以提高查詢性能
CREATE INDEX IF NOT EXISTS idx_quiz_question_course ON quiz_question(course_id);
CREATE INDEX IF NOT EXISTS idx_quiz_question_type ON quiz_question(question_type);
CREATE INDEX IF NOT EXISTS idx_quiz_question_difficulty ON quiz_question(difficulty_level);

CREATE INDEX IF NOT EXISTS idx_quiz_option_question ON quiz_option(question_id);
CREATE INDEX IF NOT EXISTS idx_quiz_option_key ON quiz_option(option_key);

CREATE INDEX IF NOT EXISTS idx_user_quiz_record_user ON user_quiz_record(user_name);
CREATE INDEX IF NOT EXISTS idx_user_quiz_record_question ON user_quiz_record(question_id);
CREATE INDEX IF NOT EXISTS idx_user_quiz_record_time ON user_quiz_record(answer_time);

-- 5. 插入示例數據
-- 單選題示例
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, 'Spring Boot中，以下哪個註解用於標記主配置類？', 'single', 'A', 'Spring Boot的主配置類需要使用@SpringBootApplication註解標記', 1, NOW(), NOW());

-- 獲取剛插入的題目ID
SET @question_id = LAST_INSERT_ID();

-- 插入選項
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '@SpringBootApplication', 'A', 1, NOW(), NOW()),
(@question_id, '@Configuration', 'B', 0, NOW(), NOW()),
(@question_id, '@Component', 'C', 0, NOW(), NOW()),
(@question_id, '@Service', 'D', 0, NOW(), NOW());

-- 多選題示例
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, '以下哪些是Spring Boot的優點？', 'multiple', 'A,B,C', 'Spring Boot具有自動配置、內嵌服務器、簡化配置等優點', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();

INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '自動配置', 'A', 1, NOW(), NOW()),
(@question_id, '內嵌服務器', 'B', 1, NOW(), NOW()),
(@question_id, '簡化配置', 'C', 1, NOW(), NOW()),
(@question_id, '需要手動配置所有組件', 'D', 0, NOW(), NOW());

-- 判斷題示例
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, 'Spring Boot是基於Spring Framework的微服務框架', 'judge', 'true', 'Spring Boot確實是基於Spring Framework構建的，用於快速開發微服務應用', 1, NOW(), NOW());

-- Vue.js相關題目
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, 'Vue.js中，以下哪個指令用於條件渲染？', 'single', 'B', 'v-if指令用於條件渲染，v-for用於列表渲染，v-model用於雙向綁定', 1, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();

INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'v-for', 'A', 0, NOW(), NOW()),
(@question_id, 'v-if', 'B', 1, NOW(), NOW()),
(@question_id, 'v-model', 'C', 0, NOW(), NOW()),
(@question_id, 'v-show', 'D', 0, NOW(), NOW());

-- Vue組件相關多選題
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, 'Vue組件中可以包含哪些部分？', 'multiple', 'A,B,C', 'Vue組件包含template、script、style三個部分', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();

INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'template', 'A', 1, NOW(), NOW()),
(@question_id, 'script', 'B', 1, NOW(), NOW()),
(@question_id, 'style', 'C', 1, NOW(), NOW()),
(@question_id, 'config', 'D', 0, NOW(), NOW());

-- JavaScript基礎題目
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, 'JavaScript中，let和var的區別是let具有塊級作用域', 'judge', 'true', 'let聲明的變量具有塊級作用域，而var聲明的變量具有函數作用域', 2, NOW(), NOW());

-- 數據庫相關題目
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, '以下哪個SQL語句用於查詢數據？', 'single', 'A', 'SELECT語句用於查詢數據，INSERT用於插入，UPDATE用於更新，DELETE用於刪除', 1, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();

INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'SELECT', 'A', 1, NOW(), NOW()),
(@question_id, 'INSERT', 'B', 0, NOW(), NOW()),
(@question_id, 'UPDATE', 'C', 0, NOW(), NOW()),
(@question_id, 'DELETE', 'D', 0, NOW(), NOW());

-- MyBatis相關題目
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, 'MyBatis中，以下哪些是正確的說法？', 'multiple', 'A,C', 'MyBatis是持久層框架，使用XML或註解配置SQL映射', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();

INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'MyBatis是持久層框架', 'A', 1, NOW(), NOW()),
(@question_id, 'MyBatis是前端框架', 'B', 0, NOW(), NOW()),
(@question_id, 'MyBatis使用XML配置SQL映射', 'C', 1, NOW(), NOW()),
(@question_id, 'MyBatis不支持事務管理', 'D', 0, NOW(), NOW());
