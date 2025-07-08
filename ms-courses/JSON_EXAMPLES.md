# 📋 JSON Examples para ms-courses

## 🏷️ **Endpoints disponibles:**
- Base URL: `http://localhost:9002/api`

---

## 📚 **COURSES (`/api/courses`)**

### ✅ **POST - Crear un nuevo curso**
```http
POST http://localhost:9002/api/courses
Content-Type: application/json
```

**JSON Body:**
```json
{
    "title": "Curso Completo de Spring Boot",
    "description": "Aprende Spring Boot desde cero hasta nivel avanzado. Incluye REST APIs, JPA, Security y microservicios.",
    "categoryId": 1,
    "managerId": 1,
    "instructorId": 2,
    "publishDate": "2025-07-15",
    "price": 149.99,
    "image": "spring-boot-course.jpg",
    "status": "ACTIVE"
}
```

### ✅ **PUT - Actualizar un curso existente**
```http
PUT http://localhost:9002/api/courses/1
Content-Type: application/json
```

**JSON Body:**
```json
{
    "title": "Curso Avanzado de Spring Boot - ACTUALIZADO",
    "description": "Versión actualizada del curso con nuevas funcionalidades de Spring Boot 3.x",
    "categoryId": 1,
    "managerId": 1,
    "instructorId": 2,
    "publishDate": "2025-07-15",
    "price": 199.99,
    "image": "spring-boot-advanced.jpg",
    "status": "ACTIVE"
}
```

---

## 🏛️ **COURSE CATEGORIES (`/api/categories`)**

### ✅ **POST - Crear una nueva categoría**
```http
POST http://localhost:9002/api/categories
Content-Type: application/json
```

**JSON Body:**
```json
{
    "name": "Desarrollo Backend",
    "description": "Cursos enfocados en tecnologías de desarrollo backend como Spring, Node.js, Python, etc."
}
```

### ✅ **PUT - Actualizar una categoría**
```http
PUT http://localhost:9002/api/categories/1
Content-Type: application/json
```

**JSON Body:**
```json
{
    "name": "Desarrollo Backend Avanzado",
    "description": "Cursos avanzados de backend incluyendo microservicios, arquitecturas distribuidas y DevOps."
}
```

---

## 📝 **ENROLLMENTS (`/api/enrollments`)**

### ✅ **POST - Inscribir un usuario a un curso**
```http
POST http://localhost:9002/api/enrollments
Content-Type: application/json
```

**JSON Body:**
```json
{
    "userId": 3,
    "courseId": 1,
    "status": "ENROLLED"
}
```

### ✅ **PUT - Actualizar estado de inscripción**
```http
PUT http://localhost:9002/api/enrollments/1
Content-Type: application/json
```

**JSON Body:**
```json
{
    "userId": 3,
    "courseId": 1,
    "status": "COMPLETED"
}
```

---

## 📖 **COURSE CONTENT (`/api/content`)**

### ✅ **POST - Crear contenido de curso**
```http
POST http://localhost:9002/api/content
Content-Type: application/json
```

**JSON Body:**
```json
{
    "courseId": 1,
    "title": "Introducción a Spring Boot",
    "description": "Primeros pasos con Spring Boot y configuración básica",
    "contentType": "VIDEO",
    "contentUrl": "https://example.com/videos/intro-spring-boot.mp4",
    "orderIndex": 1,
    "duration": 1800
}
```

---

## 💬 **COURSE COMMENTS (`/api/comments`)**

### ✅ **POST - Crear comentario en curso**
```http
POST http://localhost:9002/api/comments
Content-Type: application/json
```

**JSON Body:**
```json
{
    "courseId": 1,
    "userId": 3,
    "comment": "Excelente curso, muy bien explicado y con ejemplos prácticos.",
    "rating": 5
}
```

---

## 🧪 **COURSE QUIZ (`/api/quizzes`)**

### ✅ **POST - Crear quiz para curso**
```http
POST http://localhost:9002/api/quizzes
Content-Type: application/json
```

**JSON Body:**
```json
{
    "courseId": 1,
    "title": "Quiz - Conceptos Básicos de Spring Boot",
    "description": "Evaluación de conocimientos básicos sobre Spring Boot",
    "timeLimit": 3600,
    "passingScore": 70,
    "isActive": true
}
```

---

## ❓ **QUIZ QUESTIONS (`/api/quiz-questions`)**

### ✅ **POST - Crear pregunta de quiz**
```http
POST http://localhost:9002/api/quiz-questions
Content-Type: application/json
```

**JSON Body:**
```json
{
    "quizId": 1,
    "questionText": "¿Cuál es la anotación principal para marcar una clase como aplicación Spring Boot?",
    "questionType": "MULTIPLE_CHOICE",
    "options": "@SpringBootApplication,@Application,@SpringApp,@BootApplication",
    "correctAnswer": "@SpringBootApplication",
    "points": 10
}
```

---

## ⚠️ **NOTAS IMPORTANTES:**

### 🔴 **Campos obligatorios que NO deben estar vacíos:**
- **CourseDTO**: `title`, `description`, `categoryId`, `managerId`, `instructorId`, `publishDate`, `price`, `image`, `status`
- **CourseCategoryDTO**: `name`, `description`
- **EnrollmentDTO**: `userId`, `courseId`, `status`

### 📅 **Formato de fechas:**
- Usar formato ISO: `"2025-07-15"` (YYYY-MM-DD)

### 💰 **Formato de precios:**
- Usar números decimales: `149.99` (sin comillas)

### 🔢 **IDs de referencia:**
- Asegúrate de que los IDs (`categoryId`, `managerId`, `instructorId`, `userId`, `courseId`) existan en la base de datos

### 📊 **Estados válidos:**
- **Course status**: `"ACTIVE"`, `"INACTIVE"`, `"DRAFT"`
- **Enrollment status**: `"ENROLLED"`, `"COMPLETED"`, `"CANCELLED"`
- **Content type**: `"VIDEO"`, `"TEXT"`, `"PDF"`, `"QUIZ"`
- **Question type**: `"MULTIPLE_CHOICE"`, `"TRUE_FALSE"`, `"SHORT_ANSWER"`

---

## 🚀 **Ejemplo de secuencia de prueba:**

1. **Crear categoría primero:**
```json
POST /api/categories
{
    "name": "Programación",
    "description": "Cursos de programación"
}
```

2. **Luego crear curso:**
```json
POST /api/courses
{
    "title": "Java Básico",
    "description": "Curso de Java para principiantes",
    "categoryId": 1,
    "managerId": 1,
    "instructorId": 2,
    "publishDate": "2025-07-15",
    "price": 99.99,
    "image": "java-course.jpg",
    "status": "ACTIVE"
}
```

3. **Inscribir usuario:**
```json
POST /api/enrollments
{
    "userId": 3,
    "courseId": 1,
    "status": "ENROLLED"
}
```
