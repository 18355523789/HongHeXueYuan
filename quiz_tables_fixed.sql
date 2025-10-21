-- 修復版本的刷題功能數據庫腳本
-- 解決外鍵約束錯誤問題

-- 1. 首先為user表的username字段創建索引（如果不存在）
CREATE INDEX IF NOT EXISTS idx_user_username ON user(username);

-- 2. 創建題目表
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

-- 3. 創建選項表
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

-- 4. 創建用戶答題記錄表
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

-- 5. 添加外鍵約束（在創建索引後）
ALTER TABLE quiz_question ADD CONSTRAINT fk_quiz_question_course 
    FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE quiz_option ADD CONSTRAINT fk_quiz_option_question 
    FOREIGN KEY (question_id) REFERENCES quiz_question(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_quiz_record ADD CONSTRAINT fk_user_quiz_record_user 
    FOREIGN KEY (user_name) REFERENCES user(username) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_quiz_record ADD CONSTRAINT fk_user_quiz_record_question 
    FOREIGN KEY (question_id) REFERENCES quiz_question(id) ON DELETE CASCADE ON UPDATE CASCADE;

-- 6. 添加索引以提高查詢性能
CREATE INDEX IF NOT EXISTS idx_quiz_question_course ON quiz_question(course_id);
CREATE INDEX IF NOT EXISTS idx_quiz_question_type ON quiz_question(question_type);
CREATE INDEX IF NOT EXISTS idx_quiz_question_difficulty ON quiz_question(difficulty_level);

CREATE INDEX IF NOT EXISTS idx_quiz_option_question ON quiz_option(question_id);
CREATE INDEX IF NOT EXISTS idx_quiz_option_key ON quiz_option(option_key);

CREATE INDEX IF NOT EXISTS idx_user_quiz_record_user ON user_quiz_record(user_name);
CREATE INDEX IF NOT EXISTS idx_user_quiz_record_question ON user_quiz_record(question_id);
CREATE INDEX IF NOT EXISTS idx_user_quiz_record_time ON user_quiz_record(answer_time);
