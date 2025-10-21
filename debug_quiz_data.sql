-- 檢查數據庫中的題目數據
SELECT 'quiz_question表記錄數' as table_name, COUNT(*) as count FROM quiz_question
UNION ALL
SELECT 'quiz_option表記錄數' as table_name, COUNT(*) as count FROM quiz_option
UNION ALL
SELECT 'user_quiz_record表記錄數' as table_name, COUNT(*) as count FROM user_quiz_record;

-- 檢查課程ID=1的題目
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
WHERE q.course_id = 1
GROUP BY q.id
ORDER BY q.id;

-- 測試隨機查詢（模擬API調用）
SELECT * FROM quiz_question 
WHERE course_id = 1 
ORDER BY RAND() 
LIMIT 5;
