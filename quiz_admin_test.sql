-- 題庫管理功能測試腳本
-- 測試管理員後台題庫管理功能

-- 1. 查看現有題目數據
SELECT 
    qq.id,
    qq.course_id,
    c.name as course_name,
    qq.question_text,
    qq.question_type,
    qq.difficulty_level,
    qq.correct_answer,
    qq.create_time
FROM quiz_question qq
LEFT JOIN course c ON qq.course_id = c.id
ORDER BY qq.course_id, qq.create_time DESC;

-- 2. 查看各課程的題目統計
SELECT 
    qq.course_id,
    c.name as course_name,
    COUNT(*) as total_questions,
    SUM(CASE WHEN qq.question_type = 'single' THEN 1 ELSE 0 END) as single_choice,
    SUM(CASE WHEN qq.question_type = 'multiple' THEN 1 ELSE 0 END) as multiple_choice,
    SUM(CASE WHEN qq.question_type = 'judge' THEN 1 ELSE 0 END) as true_false,
    SUM(CASE WHEN qq.difficulty_level = 1 THEN 1 ELSE 0 END) as easy,
    SUM(CASE WHEN qq.difficulty_level = 2 THEN 1 ELSE 0 END) as medium,
    SUM(CASE WHEN qq.difficulty_level = 3 THEN 1 ELSE 0 END) as hard
FROM quiz_question qq
LEFT JOIN course c ON qq.course_id = c.id
GROUP BY qq.course_id, c.name
ORDER BY qq.course_id;

-- 3. 查看題目選項
SELECT 
    qq.id as question_id,
    qq.question_text,
    qo.option_key,
    qo.option_text,
    qo.is_correct
FROM quiz_question qq
LEFT JOIN quiz_option qo ON qq.id = qo.question_id
ORDER BY qq.id, qo.option_key;

-- 4. 測試新增題目（示例）
-- 注意：實際測試時請根據需要修改課程ID
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (1, '測試題目：Spring Boot的主要特點是什麼？', 'single', 'A', 'Spring Boot提供了自動配置和快速開發的能力', 2, NOW(), NOW());

-- 獲取剛插入的題目ID
SET @test_question_id = LAST_INSERT_ID();

-- 為測試題目添加選項
INSERT INTO quiz_option (question_id, option_key, option_text, is_correct, create_time, update_time) VALUES
(@test_question_id, 'A', '自動配置和快速開發', 1, NOW(), NOW()),
(@test_question_id, 'B', '只能開發Web應用', 0, NOW(), NOW()),
(@test_question_id, 'C', '不支持數據庫', 0, NOW(), NOW()),
(@test_question_id, 'D', '只能使用Java', 0, NOW(), NOW());

-- 5. 驗證新增的題目
SELECT 
    qq.id,
    qq.course_id,
    qq.question_text,
    qq.question_type,
    qq.correct_answer,
    qq.explanation,
    qq.difficulty_level
FROM quiz_question qq
WHERE qq.id = @test_question_id;

SELECT 
    qo.option_key,
    qo.option_text,
    qo.is_correct
FROM quiz_option qo
WHERE qo.question_id = @test_question_id
ORDER BY qo.option_key;

-- 6. 測試更新題目
UPDATE quiz_question 
SET question_text = '更新後的測試題目：Spring Boot框架的主要優勢是什麼？',
    explanation = 'Spring Boot通過自動配置大大簡化了Spring應用的開發過程'
WHERE id = @test_question_id;

-- 7. 測試刪除題目（清理測試數據）
-- 先刪除選項
DELETE FROM quiz_option WHERE question_id = @test_question_id;
-- 再刪除題目
DELETE FROM quiz_question WHERE id = @test_question_id;

-- 8. 最終統計
SELECT 
    '題庫管理功能測試完成' as status,
    COUNT(*) as total_questions,
    COUNT(DISTINCT course_id) as courses_with_questions
FROM quiz_question;
