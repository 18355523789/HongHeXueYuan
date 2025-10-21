-- 為多個課程添加題目的完整腳本
-- 課程ID 1: Spring Boot + Vue.js 全棧開發
-- 課程ID 2: Java基礎編程
-- 課程ID 3: 數據庫設計與優化

-- ==================== 課程ID 2: Java基礎編程 ====================

-- Java基礎單選題
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (2, 'Java中，以下哪個關鍵字用於定義類？', 'single', 'A', 'class關鍵字用於定義類，這是Java面向對象編程的基礎', 1, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'class', 'A', 1, NOW(), NOW()),
(@question_id, 'interface', 'B', 0, NOW(), NOW()),
(@question_id, 'object', 'C', 0, NOW(), NOW()),
(@question_id, 'type', 'D', 0, NOW(), NOW());

-- Java多選題
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (2, 'Java中的基本數據類型包括哪些？', 'multiple', 'A,B,C', 'Java的基本數據類型包括byte、short、int、long、float、double、char、boolean', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'int', 'A', 1, NOW(), NOW()),
(@question_id, 'double', 'B', 1, NOW(), NOW()),
(@question_id, 'boolean', 'C', 1, NOW(), NOW()),
(@question_id, 'String', 'D', 0, NOW(), NOW());

-- Java判斷題
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (2, 'Java是一種編譯型語言', 'judge', 'true', 'Java是編譯型語言，源代碼先編譯成字節碼，然後由JVM解釋執行', 1, NOW(), NOW());

-- Java異常處理
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (2, 'Java中，以下哪個是運行時異常？', 'single', 'B', 'NullPointerException是運行時異常，不需要在方法簽名中聲明', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'IOException', 'A', 0, NOW(), NOW()),
(@question_id, 'NullPointerException', 'B', 1, NOW(), NOW()),
(@question_id, 'SQLException', 'C', 0, NOW(), NOW()),
(@question_id, 'FileNotFoundException', 'D', 0, NOW(), NOW());

-- Java集合框架
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (2, 'Java集合框架中，以下哪些是List接口的實現？', 'multiple', 'A,C', 'ArrayList和LinkedList都是List接口的實現，Vector也是但選項中沒有', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'ArrayList', 'A', 1, NOW(), NOW()),
(@question_id, 'HashSet', 'B', 0, NOW(), NOW()),
(@question_id, 'LinkedList', 'C', 1, NOW(), NOW()),
(@question_id, 'HashMap', 'D', 0, NOW(), NOW());

-- ==================== 課程ID 3: 數據庫設計與優化 ====================

-- 數據庫基礎
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (3, '關係型數據庫中，以下哪個是主鍵的特徵？', 'single', 'A', '主鍵必須唯一且不能為空，這是數據庫設計的基本原則', 1, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '唯一且不能為空', 'A', 1, NOW(), NOW()),
(@question_id, '可以為空', 'B', 0, NOW(), NOW()),
(@question_id, '可以重複', 'C', 0, NOW(), NOW()),
(@question_id, '必須是數字', 'D', 0, NOW(), NOW());

-- SQL查詢優化
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (3, '以下哪些方法可以提高SQL查詢性能？', 'multiple', 'A,B,C', '索引、查詢優化、分頁都是提高SQL查詢性能的有效方法', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '創建適當的索引', 'A', 1, NOW(), NOW()),
(@question_id, '優化查詢語句', 'B', 1, NOW(), NOW()),
(@question_id, '使用分頁查詢', 'C', 1, NOW(), NOW()),
(@question_id, '增加表字段', 'D', 0, NOW(), NOW());

-- 數據庫事務
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (3, '數據庫事務的ACID特性中，A代表原子性', 'judge', 'true', 'ACID分別代表原子性(Atomicity)、一致性(Consistency)、隔離性(Isolation)、持久性(Durability)', 2, NOW(), NOW());

-- 數據庫正規化
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (3, '數據庫正規化的主要目的是什麼？', 'single', 'B', '正規化的主要目的是減少數據冗餘，提高數據一致性和存儲效率', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '提高查詢速度', 'A', 0, NOW(), NOW()),
(@question_id, '減少數據冗餘', 'B', 1, NOW(), NOW()),
(@question_id, '增加存儲空間', 'C', 0, NOW(), NOW()),
(@question_id, '簡化表結構', 'D', 0, NOW(), NOW());

-- 數據庫索引
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (3, '以下哪些是數據庫索引的類型？', 'multiple', 'A,B,C', 'B+樹索引、哈希索引、位圖索引都是常見的數據庫索引類型', 3, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'B+樹索引', 'A', 1, NOW(), NOW()),
(@question_id, '哈希索引', 'B', 1, NOW(), NOW()),
(@question_id, '位圖索引', 'C', 1, NOW(), NOW()),
(@question_id, '文本索引', 'D', 0, NOW(), NOW());

-- ==================== 課程ID 4: 前端開發技術 ====================

-- HTML基礎
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (4, 'HTML中，以下哪個標籤用於創建超鏈接？', 'single', 'A', 'a標籤用於創建超鏈接，href屬性指定鏈接地址', 1, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '<a>', 'A', 1, NOW(), NOW()),
(@question_id, '<link>', 'B', 0, NOW(), NOW()),
(@question_id, '<href>', 'C', 0, NOW(), NOW()),
(@question_id, '<url>', 'D', 0, NOW(), NOW());

-- CSS樣式
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (4, 'CSS中，以下哪些是定位屬性？', 'multiple', 'A,B,C', 'position、top、left都是CSS的定位相關屬性', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, 'position', 'A', 1, NOW(), NOW()),
(@question_id, 'top', 'B', 1, NOW(), NOW()),
(@question_id, 'left', 'C', 1, NOW(), NOW()),
(@question_id, 'color', 'D', 0, NOW(), NOW());

-- JavaScript基礎
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (4, 'JavaScript中，var和let的區別是作用域不同', 'judge', 'true', 'var具有函數作用域，let具有塊級作用域', 2, NOW(), NOW());

-- ==================== 課程ID 5: 軟件工程 ====================

-- 軟件開發模型
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (5, '以下哪個是敏捷開發的特點？', 'single', 'B', '敏捷開發強調快速迭代和客戶反饋，適應需求變化', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '文檔優先', 'A', 0, NOW(), NOW()),
(@question_id, '快速迭代', 'B', 1, NOW(), NOW()),
(@question_id, '嚴格計劃', 'C', 0, NOW(), NOW()),
(@question_id, '階段性交付', 'D', 0, NOW(), NOW());

-- 軟件測試
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (5, '軟件測試中，以下哪些是測試類型？', 'multiple', 'A,B,C', '單元測試、集成測試、系統測試都是軟件測試的重要類型', 2, NOW(), NOW());

SET @question_id = LAST_INSERT_ID();
INSERT INTO quiz_option (question_id, option_text, option_key, is_correct, create_time, update_time) VALUES
(@question_id, '單元測試', 'A', 1, NOW(), NOW()),
(@question_id, '集成測試', 'B', 1, NOW(), NOW()),
(@question_id, '系統測試', 'C', 1, NOW(), NOW()),
(@question_id, '代碼審查', 'D', 0, NOW(), NOW());

-- 版本控制
INSERT INTO quiz_question (course_id, question_text, question_type, correct_answer, explanation, difficulty_level, create_time, update_time) 
VALUES (5, 'Git是分佈式版本控制系統', 'judge', 'true', 'Git是分佈式版本控制系統，每個開發者都有完整的代碼歷史', 1, NOW(), NOW());

-- ==================== 統計信息 ====================

-- 查看各課程的題目數量
SELECT 
    course_id,
    COUNT(*) as question_count,
    SUM(CASE WHEN question_type = 'single' THEN 1 ELSE 0 END) as single_choice,
    SUM(CASE WHEN question_type = 'multiple' THEN 1 ELSE 0 END) as multiple_choice,
    SUM(CASE WHEN question_type = 'judge' THEN 1 ELSE 0 END) as true_false,
    AVG(difficulty_level) as avg_difficulty
FROM quiz_question 
GROUP BY course_id 
ORDER BY course_id;
