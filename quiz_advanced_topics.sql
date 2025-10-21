-- 高級題目補充腳本
-- 為現有課程添加更多高難度題目

-- ==================== 課程ID 2: Java基礎編程 - 高級題目 ====================

-- Java內存管理
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (2, 'Java中，以下哪個區域存儲對象實例？', 'single', 'B', '堆內存存儲對象實例，棧內存存儲局部變量和方法調用', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '方法區', 'A', 0, NOW(), NOW()),
(@question_id, '堆內存', 'B', 1, NOW(), NOW()),
(@question_id, '棧內存', 'C', 0, NOW(), NOW()),
(@question_id, '程序計數器', 'D', 0, NOW(), NOW());

-- Java多線程
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (2, 'Java多線程中，以下哪些是線程安全的方式？', 'multiple', 'A,B,C', 'synchronized、volatile、Atomic類都是實現線程安全的方式', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'synchronized關鍵字', 'A', 1, NOW(), NOW()),
(@question_id, 'volatile關鍵字', 'B', 1, NOW(), NOW()),
(@question_id, 'Atomic類', 'C', 1, NOW(), NOW()),
(@question_id, '普通變量', 'D', 0, NOW(), NOW());

-- Java設計模式
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (2, '單例模式確保一個類只有一個實例', 'judge', 'true', '單例模式是創建型設計模式，確保一個類只有一個實例並提供全局訪問點', 3, NOW(), NOW());

-- ==================== 課程ID 3: 數據庫設計與優化 - 高級題目 ====================

-- 數據庫分區
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (3, '數據庫分區的主要目的是什麼？', 'single', 'A', '分區的主要目的是提高查詢性能和管理大表數據', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '提高查詢性能', 'A', 1, NOW(), NOW()),
(@question_id, '減少存儲空間', 'B', 0, NOW(), NOW()),
(@question_id, '簡化表結構', 'C', 0, NOW(), NOW()),
(@question_id, '增加安全性', 'D', 0, NOW(), NOW());

-- 數據庫鎖機制
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (3, '數據庫中，以下哪些是鎖的類型？', 'multiple', 'A,B,C', '共享鎖、排他鎖、意向鎖都是數據庫中常見的鎖類型', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '共享鎖(Shared Lock)', 'A', 1, NOW(), NOW()),
(@question_id, '排他鎖(Exclusive Lock)', 'B', 1, NOW(), NOW()),
(@question_id, '意向鎖(Intent Lock)', 'C', 1, NOW(), NOW()),
(@question_id, '讀寫鎖', 'D', 0, NOW(), NOW());

-- 數據庫備份
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (3, '數據庫備份策略中，增量備份比全量備份更節省空間', 'judge', 'true', '增量備份只備份自上次備份以來變化的數據，比全量備份更節省空間', 2, NOW(), NOW());

-- ==================== 課程ID 4: 前端開發技術 - 高級題目 ====================

-- Vue.js高級特性
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (4, 'Vue.js中，以下哪個是組合式API的特點？', 'single', 'B', '組合式API提供更好的邏輯復用和類型推斷', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '更好的性能', 'A', 0, NOW(), NOW()),
(@question_id, '更好的邏輯復用', 'B', 1, NOW(), NOW()),
(@question_id, '更簡單的語法', 'C', 0, NOW(), NOW()),
(@question_id, '更小的包大小', 'D', 0, NOW(), NOW());

-- React基礎
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (4, 'React中，以下哪些是Hook？', 'multiple', 'A,B,C', 'useState、useEffect、useContext都是React的內置Hook', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'useState', 'A', 1, NOW(), NOW()),
(@question_id, 'useEffect', 'B', 1, NOW(), NOW()),
(@question_id, 'useContext', 'C', 1, NOW(), NOW()),
(@question_id, 'useComponent', 'D', 0, NOW(), NOW());

-- Web性能優化
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (4, '前端性能優化中，代碼分割可以減少初始加載時間', 'judge', 'true', '代碼分割將代碼分成多個塊，可以按需加載，減少初始加載時間', 2, NOW(), NOW());

-- ==================== 課程ID 5: 軟件工程 - 高級題目 ====================

-- 微服務架構
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (5, '微服務架構中，以下哪些是服務間通信方式？', 'multiple', 'A,B,C', 'REST API、消息隊列、RPC都是微服務間常見的通信方式', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'REST API', 'A', 1, NOW(), NOW()),
(@question_id, '消息隊列', 'B', 1, NOW(), NOW()),
(@question_id, 'RPC', 'C', 1, NOW(), NOW()),
(@question_id, '數據庫共享', 'D', 0, NOW(), NOW());

-- DevOps實踐
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (5, 'DevOps中，CI/CD的主要目標是自動化軟件交付流程', 'judge', 'true', 'CI/CD(持續集成/持續部署)的主要目標是自動化軟件交付流程', 2, NOW(), NOW());

-- ==================== 課程ID 6: 網絡安全 ====================

-- 網絡安全基礎
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (6, '以下哪個是常見的網絡攻擊類型？', 'single', 'A', 'SQL注入是常見的網絡攻擊類型，通過惡意SQL代碼攻擊數據庫', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'SQL注入', 'A', 1, NOW(), NOW()),
(@question_id, 'HTML注入', 'B', 0, NOW(), NOW()),
(@question_id, 'CSS注入', 'C', 0, NOW(), NOW()),
(@question_id, 'JavaScript注入', 'D', 0, NOW(), NOW());

-- 加密技術
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (6, '以下哪些是對稱加密算法？', 'multiple', 'A,B', 'AES和DES都是對稱加密算法，使用相同的密鑰進行加密和解密', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'AES', 'A', 1, NOW(), NOW()),
(@question_id, 'DES', 'B', 1, NOW(), NOW()),
(@question_id, 'RSA', 'C', 0, NOW(), NOW()),
(@question_id, 'ECC', 'D', 0, NOW(), NOW());

-- HTTPS協議
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (6, 'HTTPS協議在HTTP基礎上增加了SSL/TLS加密', 'judge', 'true', 'HTTPS是HTTP的安全版本，通過SSL/TLS協議提供加密和身份驗證', 2, NOW(), NOW());

-- ==================== 課程ID 7: 人工智能基礎 ====================

-- 機器學習基礎
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (7, '機器學習中，以下哪個是監督學習的特點？', 'single', 'B', '監督學習使用標註數據進行訓練，學習輸入和輸出之間的映射關係', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '無需標註數據', 'A', 0, NOW(), NOW()),
(@question_id, '使用標註數據', 'B', 1, NOW(), NOW()),
(@question_id, '只處理圖像', 'C', 0, NOW(), NOW()),
(@question_id, '只處理文本', 'D', 0, NOW(), NOW());

-- 深度學習
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (7, '深度學習中，以下哪些是常見的激活函數？', 'multiple', 'A,B,C', 'ReLU、Sigmoid、Tanh都是深度學習中常用的激活函數', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'ReLU', 'A', 1, NOW(), NOW()),
(@question_id, 'Sigmoid', 'B', 1, NOW(), NOW()),
(@question_id, 'Tanh', 'C', 1, NOW(), NOW()),
(@question_id, 'Linear', 'D', 0, NOW(), NOW());

-- 神經網絡
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (7, '神經網絡中，反向傳播算法用於訓練網絡參數', 'judge', 'true', '反向傳播是神經網絡訓練的核心算法，用於計算梯度並更新網絡參數', 3, NOW(), NOW());

-- ==================== 最終統計 ====================

-- 查看所有課程的題目統計
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
    SUM(CASE WHEN difficulty_level = 3 THEN 1 ELSE 0 END) as hard,
    ROUND(AVG(difficulty_level), 2) as avg_difficulty
FROM quiz_question 
GROUP BY course_id 
ORDER BY course_id;
