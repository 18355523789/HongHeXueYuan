-- 測試刷題功能數據庫腳本
-- 用於驗證API是否正常工作

-- 檢查表是否存在
SHOW TABLES LIKE 'quiz_%';
SHOW TABLES LIKE 'user_quiz_%';

-- 檢查題目數據
SELECT COUNT(*) as question_count FROM quiz_question;
SELECT COUNT(*) as option_count FROM quiz_option;

-- 查看題目詳情
SELECT 
    q.id,
    q.course_id,
    q.question_text,
    q.question_type,
    q.correct_answer,
    q.difficulty_level,
    COUNT(o.id) as option_count
FROM quiz_question q
LEFT JOIN quiz_option o ON q.id = o.question_id
GROUP BY q.id
ORDER BY q.id;

-- 測試隨機查詢
SELECT * FROM quiz_question 
WHERE course_id = 1 
ORDER BY RAND() 
LIMIT 5;

-- 檢查選項數據
SELECT 
    q.question_text,
    o.option_key,
    o.option_text,
    o.is_correct
FROM quiz_question q
JOIN quiz_option o ON q.id = o.question_id
WHERE q.course_id = 1
ORDER BY q.id, o.option_key;
