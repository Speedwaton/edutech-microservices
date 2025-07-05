@echo off
echo ========================================
echo PRUEBAS AUTOMATIZADAS COMPLETAS
echo ========================================

echo.
echo Verificando que los servicios esten ejecutandose...
timeout /t 5

echo.
echo ========================================
echo 1. PRUEBAS BASICAS DE ENDPOINTS
echo ========================================

echo.
echo 1.1 GET /api/courses (Lista de cursos)
curl -s -o nul -w "Status: %%{http_code}\n" "http://localhost:8001/api/courses"

echo.
echo 1.2 GET /api/users (Lista de usuarios)  
curl -s -o nul -w "Status: %%{http_code}\n" "http://localhost:8002/api/users"

echo.
echo ========================================
echo 2. PRUEBAS DE HATEOAS
echo ========================================

echo.
echo 2.1 GET /api/courses/1 (Debe incluir _links)
curl -X GET "http://localhost:8001/api/courses/1" -H "accept: application/json" | findstr "_links"
if %errorlevel% equ 0 (
    echo ✅ HATEOAS detectado en courses
) else (
    echo ❌ HATEOAS NO detectado en courses
)

echo.
echo 2.2 GET /api/users/1 (Debe incluir _links)
curl -X GET "http://localhost:8002/api/users/1" -H "accept: application/json" | findstr "_links"
if %errorlevel% equ 0 (
    echo ✅ HATEOAS detectado en users
) else (
    echo ❌ HATEOAS NO detectado en users
)

echo.
echo ========================================
echo 3. PRUEBAS DE SWAGGER
echo ========================================

echo.
echo 3.1 Swagger UI ms-courses
curl -s -o nul -w "Status: %%{http_code}\n" "http://localhost:8001/swagger-ui.html"

echo.
echo 3.2 Swagger UI ms-users
curl -s -o nul -w "Status: %%{http_code}\n" "http://localhost:8002/swagger-ui.html"

echo.
echo 3.3 OpenAPI JSON ms-courses
curl -s -o nul -w "Status: %%{http_code}\n" "http://localhost:8001/v3/api-docs"

echo.
echo 3.4 OpenAPI JSON ms-users
curl -s -o nul -w "Status: %%{http_code}\n" "http://localhost:8002/v3/api-docs"

echo.
echo ========================================
echo 4. PRUEBAS DE CREACION (POST)
echo ========================================

echo.
echo 4.1 POST /api/enrollments (Campos automaticos)
curl -X POST "http://localhost:8001/api/enrollments" ^
  -H "Content-Type: application/json" ^
  -d "{\"studentId\":1,\"courseId\":1,\"status\":\"ACTIVE\"}" ^
  -w "\nStatus: %%{http_code}\n"

echo.
echo ========================================
echo 5. URLS DE ACCESO DIRECTO
echo ========================================
echo.
echo 📋 SWAGGER UIs:
echo - ms-courses: http://localhost:8001/swagger-ui.html
echo - ms-users: http://localhost:8002/swagger-ui.html
echo.
echo 🔗 ENDPOINTS CON HATEOAS:
echo - http://localhost:8001/api/courses/1
echo - http://localhost:8001/api/course-categories/1
echo - http://localhost:8001/api/enrollments/1
echo - http://localhost:8002/api/users/1
echo.
echo 📊 EUREKA DASHBOARD:
echo - http://localhost:8761
echo.
echo ========================================
echo PRUEBAS COMPLETADAS
echo ========================================

pause