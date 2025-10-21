# 刷題功能使用說明

## 功能概述

刷題功能已成功集成到SpringBoot和Vue學習平台中，用戶可以在課程頁面進行題目練習，支持單選、多選和判斷題三種類型。

## 功能特點

- **三種題型**：單選題、多選題、判斷題
- **難度分級**：簡單、中等、困難三個等級
- **靈活配置**：可選擇題目數量和難度等級
- **即時反饋**：答題後立即顯示正確答案和解析
- **答題記錄**：系統會記錄用戶的答題情況
- **統計功能**：顯示正確率、錯誤率等統計信息

## 數據庫設置

### 1. 創建數據庫表

執行 `quiz_tables.sql` 文件創建相關數據表：

```sql
-- 題目表
create table quiz_question
(
    id bigint auto_increment comment '題目ID' primary key,
    course_id bigint not null comment '課程ID',
    question_text text not null comment '題目內容',
    question_type varchar(10) not null comment '題目類型：single(單選), multiple(多選), judge(判斷)',
    correct_answer varchar(500) not null comment '正確答案',
    explanation text null comment '答案解析',
    difficulty_level tinyint default 1 comment '難度等級：1-簡單，2-中等，3-困難',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間'
);

-- 選項表
create table quiz_option
(
    id bigint auto_increment comment '選項ID' primary key,
    question_id bigint not null comment '題目ID',
    option_text varchar(500) not null comment '選項內容',
    option_key varchar(2) not null comment '選項標識：A, B, C, D等',
    is_correct tinyint default 0 comment '是否正確選項：0-否，1-是',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間'
);

-- 用戶答題記錄表
create table user_quiz_record
(
    id bigint auto_increment comment '記錄ID' primary key,
    user_name varchar(20) not null comment '用戶名',
    question_id bigint not null comment '題目ID',
    user_answer varchar(500) null comment '用戶答案',
    is_correct tinyint not null comment '是否正確：0-錯誤，1-正確',
    answer_time datetime not null comment '答題時間',
    create_time datetime not null comment '創建時間',
    update_time datetime not null comment '修改時間'
);
```

### 2. 插入示例數據

執行 `quiz_sample_data.sql` 文件插入示例題目數據。

## 後端API接口

### 題目相關接口

- `GET /quiz/course/{courseId}` - 獲取課程的所有題目
- `GET /quiz/course/{courseId}/random` - 隨機獲取指定數量的題目
- `GET /quiz/{id}` - 獲取單個題目詳情
- `POST /quiz` - 創建新題目
- `PUT /quiz` - 更新題目
- `DELETE /quiz/{id}` - 刪除題目
- `POST /quiz/{questionId}/submit` - 提交答案

### 請求示例

```javascript
// 獲取隨機題目
GET /quiz/course/1/random?limit=10&difficultyLevel=1

// 提交答案
POST /quiz/1/submit
{
    "answer": "A"
}
```

## 前端使用

### 1. 訪問刷題功能

1. 進入任意課程詳情頁面
2. 點擊"刷題"標籤頁
3. 選擇題目數量和難度等級
4. 點擊"開始刷題"

### 2. 答題流程

1. 閱讀題目內容
2. 選擇答案（單選/多選/判斷）
3. 點擊"提交答案"
4. 查看答案反饋和解析
5. 點擊"下一題"繼續或"查看結果"完成

### 3. 結果查看

答題完成後可以查看：
- 正確題數
- 錯誤題數  
- 正確率
- 重新刷題或返回選擇

## 題目類型說明

### 單選題 (single)
- 只能選擇一個答案
- 正確答案格式：選項標識（如 "A"）
- 選項格式：A. 選項內容

### 多選題 (multiple)
- 可以選擇多個答案
- 正確答案格式：多個選項標識用逗號分隔（如 "A,B,C"）
- 選項格式：A. 選項內容

### 判斷題 (judge)
- 只有正確/錯誤兩個選項
- 正確答案格式：true 或 false
- 選項：正確、錯誤

## 自定義題目

### 添加新題目

可以通過後端API或直接在數據庫中添加新題目：

```sql
-- 添加單選題
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, '題目內容', 'single', 'A', '答案解析', 1, NOW(), NOW());

-- 添加對應選項
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(題目ID, '選項A內容', 'A', 1, NOW(), NOW()),
(題目ID, '選項B內容', 'B', 0, NOW(), NOW()),
(題目ID, '選項C內容', 'C', 0, NOW(), NOW()),
(題目ID, '選項D內容', 'D', 0, NOW(), NOW());
```

## 注意事項

1. 確保用戶已登錄才能使用刷題功能
2. 題目ID必須對應實際存在的課程
3. 選項的option_key必須唯一且符合規範
4. 多選題的正確答案必須按字母順序排列
5. 判斷題的答案只能是"true"或"false"

## 擴展功能

未來可以考慮添加的功能：
- 題目分類管理
- 錯題本功能
- 學習進度追蹤
- 題目收藏功能
- 排行榜功能
- 題目評分和評論
