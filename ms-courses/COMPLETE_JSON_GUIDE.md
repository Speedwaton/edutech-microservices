# 🎯 JSON Examples COMPLETOS para ms-courses (ACTUALIZADO)

## 🚀 **Base URL: `http://localhost:9002`**

---

## 📚 **COURSES - `/api/courses`**

### ✅ **POST - Crear nuevo curso**
```json
{
    "title": "Spring Boot para Principiantes",
    "description": "Curso completo de Spring Boot desde cero con ejemplos prácticos",
    "categoryId": 1,
    "managerId": 1,
    "instructorId": 2,
    "publishDate": "2025-07-15",
    "price": 99.99,
    "image": "spring-boot-beginners.jpg",
    "status": "ACTIVE"
}
```

### ✅ **PUT - Actualizar curso**
```json
{
    "title": "Spring Boot Avanzado - Actualizado",
    "description": "Versión actualizada con Spring Boot 3.x y microservicios",
    "categoryId": 1,
    "managerId": 1,
    "instructorId": 2,
    "publishDate": "2025-07-15",
    "price": 149.99,
    "image": "spring-boot-advanced.jpg",
    "status": "ACTIVE"
}
```

---

## 🏛️ **COURSE CATEGORIES - `/api/course-categories`**

### ✅ **POST - Crear nueva categoría**
```json
{
    "name": "Desarrollo Backend",
    "description": "Cursos de tecnologías backend como Spring, Node.js, Python Django"
}
```

### ✅ **PUT - Actualizar categoría**
```json
{
    "name": "Backend Avanzado",
    "description": "Cursos avanzados de backend incluyendo microservicios y arquitecturas distribuidas"
}
```

---

## 📝 **ENROLLMENTS - `/api/enrollments`**

### ✅ **POST - Crear inscripción**
```json
{
    "userId": 3,
    "courseId": 1,
    "status": "ENROLLED"
}
```

### ✅ **PUT - Actualizar inscripción**
```json
{
    "userId": 3,
    "courseId": 1,
    "status": "COMPLETED"
}
```

---

## 📖 **COURSE CONTENTS - `/api/course-contents`**

### ✅ **POST - Crear contenido de curso**
```json
{
    "title": "Introducción a Spring Boot",
    "description": "Conceptos básicos y configuración inicial de Spring Boot",
    "courseId": 1,
    "orderIndex": 1,
    "url": "https://example.com/videos/intro-spring-boot.mp4",
    "contentType": "VIDEO",
    "duration": 1800
}
```

### ✅ **PUT - Actualizar contenido**
```json
{
    "title": "Introducción a Spring Boot - Actualizado",
    "description": "Conceptos básicos actualizados para Spring Boot 3.x",
    "courseId": 1,
    "orderIndex": 1,
    "url": "https://example.com/videos/intro-spring-boot-v3.mp4",
    "contentType": "VIDEO",
    "duration": 2100
}
```

---

## 💬 **COURSE COMMENTS - `/api/course-comments`**

### ✅ **POST - Crear comentario**
```json
{
    "courseId": 1,
    "userId": 3,
    "commentText": "Excelente curso, muy bien explicado y con ejemplos prácticos. Lo recomiendo totalmente.",
    "rating": 5
}
```

### ✅ **PUT - Actualizar comentario**
```json
{
    "courseId": 1,
    "userId": 3,
    "commentText": "Excelente curso, muy bien explicado. Actualicé mi reseña después de completarlo.",
    "rating": 5
}
```

---

## 🧪 **COURSE QUIZZES - `/api/course-quizzes`**

### ✅ **POST - Crear quiz**
```json
{
    "courseId": 1,
    "title": "Quiz - Conceptos Básicos de Spring Boot",
    "description": "Evaluación de conocimientos básicos sobre Spring Boot y sus características principales",
    "quizType": "FINAL_EXAM",
    "timeLimit": 3600,
    "passingScore": 70,
    "isActive": true
}
```

### ✅ **PUT - Actualizar quiz**
```json
{
    "courseId": 1,
    "title": "Quiz Final - Spring Boot Completo",
    "description": "Evaluación completa de todos los temas del curso de Spring Boot",
    "quizType": "FINAL_EXAM",
    "timeLimit": 5400,
    "passingScore": 75,
    "isActive": true
}
```

---

## ❓ **COURSE QUIZ QUESTIONS - `/api/course-quiz-questions`**

### ✅ **POST - Crear pregunta de quiz**
```json
{
    "quizId": 1,
    "questionText": "¿Cuál es la anotación principal para marcar una clase como aplicación Spring Boot?",
    "optionA": "@SpringBootApplication",
    "optionB": "@Application",
    "optionC": "@SpringApp",
    "optionD": "@BootApplication",
    "optionE": null,
    "correctOption": "A",
    "orderIndex": 1
}
```

### ✅ **POST - Crear pregunta verdadero/falso**
```json
{
    "quizId": 1,
    "questionText": "Spring Boot incluye un servidor web embebido por defecto",
    "optionA": "Verdadero",
    "optionB": "Falso",
    "optionC": null,
    "optionD": null,
    "optionE": null,
    "correctOption": "A",
    "orderIndex": 2
}
```

### ✅ **POST - Crear pregunta de respuesta corta**
```json
{
    "quizId": 1,
    "questionText": "¿Qué puerto usa por defecto una aplicación Spring Boot?",
    "optionA": null,
    "optionB": null,
    "optionC": null,
    "optionD": null,
    "optionE": null,
    "correctAnswer": "8080",
    "orderIndex": 3
}
```

---

## 🔧 **ENDPOINTS COMPLETOS DISPONIBLES:**

### **Courses:**
- `GET /api/courses` - Listar cursos
- `GET /api/courses/{id}` - Obtener curso
- `POST /api/courses` - Crear curso
- `PUT /api/courses/{id}` - Actualizar curso
- `DELETE /api/courses/{id}` - Eliminar curso

### **Course Categories:**
- `GET /api/course-categories` - Listar categorías
- `GET /api/course-categories/{id}` - Obtener categoría
- `POST /api/course-categories` - Crear categoría
- `PUT /api/course-categories/{id}` - Actualizar categoría
- `DELETE /api/course-categories/{id}` - Eliminar categoría

### **Enrollments:**
- `GET /api/enrollments` - Listar inscripciones
- `GET /api/enrollments/{id}` - Obtener inscripción
- `POST /api/enrollments` - Crear inscripción
- `PUT /api/enrollments/{id}` - Actualizar inscripción
- `DELETE /api/enrollments/{id}` - Eliminar inscripción

### **Course Contents:**
- `GET /api/course-contents` - Listar contenidos
- `GET /api/course-contents/{id}` - Obtener contenido
- `POST /api/course-contents` - Crear contenido
- `PUT /api/course-contents/{id}` - Actualizar contenido
- `DELETE /api/course-contents/{id}` - Eliminar contenido

### **Course Comments:**
- `GET /api/course-comments` - Listar comentarios
- `GET /api/course-comments/{id}` - Obtener comentario
- `POST /api/course-comments` - Crear comentario
- `PUT /api/course-comments/{id}` - Actualizar comentario
- `DELETE /api/course-comments/{id}` - Eliminar comentario

---

## ⚠️ **VALIDACIONES IMPORTANTES:**

### **🔴 Campos obligatorios por DTO:**

**CourseDTO:**
- `title` (máx 200 chars)
- `description` (máx 800 chars)
- `categoryId` (debe existir)
- `managerId` (debe existir en ms-users)
- `instructorId` (debe existir en ms-users)
- `publishDate` (formato: "2025-07-15")
- `price` (decimal > 0)
- `image` (string)
- `status` (máx 50 chars)

**CourseCommentDTO:**
- `courseId` (debe existir)
- `userId` (debe existir en ms-users)
- `commentText` (máx 800 chars)
- `rating` (entero 0-5)

**CourseContentDTO:**
- `title` (máx 200 chars)
- `description` (máx 800 chars)
- `courseId` (debe existir)
- `orderIndex` (entero)
- `url` (string)
- `contentType` (máx 50 chars)

**CourseQuizDTO:**
- `courseId` (debe existir)
- `title` (máx 200 chars)
- `description` (máx 800 chars)
- `quizType` (máx 50 chars)

**CourseQuizQuestionDTO:**
- `quizId` (debe existir)
- `questionText` (máx 800 chars)
- `optionA` (máx 800 chars, opcional)
- `optionB` (máx 800 chars, opcional)
- `optionC` (máx 800 chars, opcional)
- `optionD` (máx 800 chars, opcional)
- `optionE` (máx 800 chars, opcional)
- `correctAnswer` (máx 800 chars, para preguntas de texto libre)
- `correctOption` (1 char, letra A-E para preguntas de opción múltiple)
- `orderIndex` (entero, obligatorio)

---

## 📊 **VALORES VÁLIDOS:**

### **Estados de curso:**
- `"ACTIVE"` - Activo
- `"INACTIVE"` - Inactivo
- `"DRAFT"` - Borrador

### **Estados de inscripción:**
- `"ENROLLED"` - Inscrito
- `"COMPLETED"` - Completado
- `"CANCELLED"` - Cancelado

### **Tipos de contenido:**
- `"VIDEO"` - Video
- `"TEXT"` - Texto
- `"PDF"` - Documento PDF
- `"QUIZ"` - Cuestionario

### **Tipos de quiz:**
- `"PRACTICE"` - Práctica
- `"MIDTERM"` - Parcial
- `"FINAL_EXAM"` - Examen final

### **Tipos de pregunta:**
- `"MULTIPLE_CHOICE"` - Opción múltiple
- `"TRUE_FALSE"` - Verdadero/Falso
- `"SHORT_ANSWER"` - Respuesta corta

---

## 🚀 **SECUENCIA RECOMENDADA PARA TESTING:**

### 1. **Crear categoría:**
```http
POST /api/course-categories
```

### 2. **Crear curso:**
```http
POST /api/courses
```

### 3. **Crear contenido:**
```http
POST /api/course-contents
```

### 4. **Crear quiz:**
```http
POST /api/course-quizzes
```

### 5. **Crear preguntas:**
```http
POST /api/course-quiz-questions
```

### 6. **Crear inscripción:**
```http
POST /api/enrollments
```

### 7. **Crear comentario:**
```http
POST /api/course-comments
```
