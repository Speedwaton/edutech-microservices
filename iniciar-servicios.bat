@echo off
echo ========================================
echo INICIANDO SERVICIOS EDUTECH
echo ========================================

echo 1. Iniciando Eureka Server...
start "Eureka" cmd /k "cd /d C:\classroom && run-eureka.bat"
timeout /t 15

echo 2. Iniciando ms-users...
start "Users" cmd /k "cd /d C:\classroom && run-users.bat"
timeout /t 10

echo 3. Iniciando ms-courses...
start "Courses" cmd /k "cd /d C:\classroom && run-courses.bat"
timeout /t 10

echo.
echo ========================================
echo SERVICIOS INICIADOS
echo ========================================
echo.
echo URLs de acceso:
echo - Eureka Dashboard: http://localhost:8761
echo - ms-users Swagger: http://localhost:8002/swagger-ui.html
echo - ms-courses Swagger: http://localhost:8001/swagger-ui.html
echo.
echo Espera 30 segundos mas para que todos los servicios se registren
echo ========================================

pause