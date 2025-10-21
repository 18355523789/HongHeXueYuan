-- 一鍵添加所有課程題目的完整腳本
-- 執行此腳本將為多個課程添加豐富的題目

-- 首先執行基礎題目腳本
source D:/Project/Learning-main/quiz_multi_course.sql;

-- 然後執行高級題目腳本  
source D:/Project/Learning-main/quiz_advanced_topics.sql;

-- 最後查看統計結果
SELECT 
    course_id,
    CASE course_id
        WHEN 1 THEN 'Spring Boot + Vue.js 全棧開發'
        WHEN 2 THEN 'Java基礎編程'
        WHEN 3 THEN '數據庫設計與優化'
        WHEN 4 THEN '前端開發技術'
        WHEN 5 THEN '軟件工程'
        WHEN 6 THEN '網絡安全'
        WHEN 7 THEN '人工智能基礎'
        ELSE '其他課程'
    END as course_name,
    COUNT(*) as total_questions,
    SUM(CASE WHEN question_type = 'single' THEN 1 ELSE 0 END) as single_choice,
    SUM(CASE WHEN question_type = 'multiple' THEN 1 ELSE 0 END) as multiple_choice,
    SUM(CASE WHEN question_type = 'judge' THEN 1 ELSE 0 END) as true_false,
    SUM(CASE WHEN difficulty_level = 1 THEN 1 ELSE 0 END) as easy,
    SUM(CASE WHEN difficulty_level = 2 THEN 1 ELSE 0 END) as medium,
    SUM(CASE WHEN difficulty_level = 3 THEN 1 ELSE 0 END) as hard
FROM quiz_question 
GROUP BY course_id 
ORDER BY course_id;
