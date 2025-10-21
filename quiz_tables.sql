-- 題目表
create table quiz_question
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

-- 選項表
create table quiz_option
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

-- 用戶答題記錄表
create table user_quiz_record
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

-- 添加外鍵約束
alter table quiz_question add constraint fk_quiz_question_course foreign key (course_id) references course(id);
alter table quiz_option add constraint fk_quiz_option_question foreign key (question_id) references quiz_question(id);
alter table user_quiz_record add constraint fk_user_quiz_record_user foreign key (user_name) references user(username);
alter table user_quiz_record add constraint fk_user_quiz_record_question foreign key (question_id) references quiz_question(id);

-- 添加索引
create index idx_quiz_question_course on quiz_question(course_id);
create index idx_quiz_option_question on quiz_option(question_id);
create index idx_user_quiz_record_user on user_quiz_record(user_name);
create index idx_user_quiz_record_question on user_quiz_record(question_id);
