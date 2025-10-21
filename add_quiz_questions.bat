@echo off
echo 正在為多個課程添加題目...

echo.
echo 1. 執行基礎題目腳本...
mysql -u root -p520174 learning < "D:\Project\Learning-main\quiz_multi_course.sql"

if %errorlevel% neq 0 (
    echo 基礎題目腳本執行失敗！
    pause
    exit /b 1
)

echo.
echo 2. 執行高級題目腳本...
mysql -u root -p520174 learning < "D:\Project\Learning-main\quiz_advanced_topics.sql"

if %errorlevel% neq 0 (
    echo 高級題目腳本執行失敗！
    pause
    exit /b 1
)

echo.
echo 3. 查看題目統計...
mysql -u root -p520174 learning -e "
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
ORDER BY course_id;"

echo.
echo 題目添加完成！
echo 現在您可以在以下課程中進行刷題練習：
echo   - 課程ID 1: Spring Boot + Vue.js 全棧開發
echo   - 課程ID 2: Java基礎編程  
echo   - 課程ID 3: 數據庫設計與優化
echo   - 課程ID 4: 前端開發技術
echo   - 課程ID 5: 軟件工程
echo   - 課程ID 6: 網絡安全
echo   - 課程ID 7: 人工智能基礎

echo.
echo 請重啟後端服務以使新題目生效！
pause
