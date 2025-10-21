@echo off
echo 正在重啟學習平台服務...

echo.
echo 1. 停止現有服務...
taskkill /f /im java.exe 2>nul

echo.
echo 2. 等待服務停止...
timeout /t 3 /nobreak >nul

echo.
echo 3. 啟動Nacos（如果未啟動）...
echo 請確保Nacos已啟動在 localhost:8848

echo.
echo 4. 啟動服務...
echo 請按順序啟動以下服務：
echo   - learning-auth (端口 8846)
echo   - learning-gateway (端口 8080)  
echo   - learning-user (端口 8410)
echo   - learning-course (端口 8420)
echo   - learning-trade (端口 8440)
echo   - learning-file (端口 8430)

echo.
echo 5. 檢查服務狀態...
echo 訪問以下URL檢查服務是否正常：
echo   - 網關健康檢查: http://localhost:8080/api/health
echo   - 課程服務健康檢查: http://localhost:8420/health
echo   - 刷題調試頁面: http://localhost:3000/quiz/debug

echo.
echo 重啟完成！請檢查服務日誌確認所有服務正常啟動。
pause
