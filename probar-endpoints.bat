@echo off
echo ========================================
echo PRUEBAS DE ENDPOINTS CON CURL
echo ========================================

echo.
echo 1. Probando endpoint GET de cursos...
curl -X GET "http://localhost:8001/api/courses" -H "accept: application/json"
echo.

echo.
echo 2. Probando endpoint GET de usuarios...
curl -X GET "http://localhost:8002/api/users" -H "accept: application/json"
echo.

echo.
echo 3. Probando endpoint GET de curso por ID (con HATEOAS)...
curl -X GET "http://localhost:8001/api/courses/1" -H "accept: application/json"
echo.

echo.
echo 4. Probando creacion de usuario (POST)...
curl -X POST "http://localhost:8002/api/users" ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"testuser\",\"email\":\"test@example.com\",\"firstName\":\"Test\",\"lastName\":\"User\"}"
echo.

echo.
echo 5. Probando creacion de enrollment (POST)...
curl -X POST "http://localhost:8001/api/enrollments" ^
  -H "Content-Type: application/json" ^
  -d "{\"studentId\":1,\"courseId\":1,\"status\":\"ACTIVE\"}"
echo.

echo ========================================
echo PRUEBAS COMPLETADAS
echo ========================================
pause