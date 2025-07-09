# Diagrama de Arquitectura - Edutech Microservicios

## Arquitectura del Sistema

```
┌─────────────────────────────────────────────────────────────────┐
│                         CLIENTE / POSTMAN                       │
│                    (Pruebas y Consumo de APIs)                  │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                      API GATEWAY                                │
│                   (Puerto: 8080)                                │
│               [Balanceador de Carga]                            │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                   EUREKA SERVER                                 │
│               PUERTO 8761                               │
│              [Service Discovery & Registry]                     │
└─────────────────────────┬───────────────────────────────────────┘
                          │
         ┌────────────────┼────────────────┬─────────────────┐
         │                │                │                 │
         ▼                ▼                ▼                 ▼
┌──────────────┐ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐
│  MS-USERS    │ │ MS-COURSES   │ │  MS-GRADES   │ │ MS-PAYMENTS  │
│ Puerto: 9002 │ │ Puerto: 9001 │ │ Puerto: 9003 │ │ Puerto: 9004 │
│              │ │              │ │              │ │              │
│ • Users      │ │ • Courses    │ │ • Student    │ │ • Payments   │
│ • Roles      │ │ • Categories │ │   Marks      │ │ • Transactions│
│ • Auth       │ │ • Quizzes    │ │ • Grades     │ │ • Billing    │
└──────────────┘ └──────────────┘ └──────────────┘ └──────────────┘
         │                │                │                 │
         └────────────────┼────────────────┼─────────────────┘
                          │                │
                          ▼                ▼
                 ┌──────────────┐ ┌──────────────┐
                 │ MS-SUPPORT   │ │   COMMON     │
                 │ Puerto: 9005 │ │   MODULE     │
                 │              │ │              │
                 │ • Tickets    │ │ • DTOs       │
                 │ • Help Desk  │ │ • Shared     │
                 │ • Issues     │ │   Classes    │
                 └──────────────┘ └──────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                   MySQL DATABASE                                │
│                     (Puerto: 3306)                              │
│                      Base: edutech                              │
│                                                                 │
│ Tablas:                                                         │
│ • user, role                                                    │
│ • course, course_category                                       │
│ • student_mark                                                  │
│ • payment                                                       │
│ • support_ticket                                                │
└─────────────────────────────────────────────────────────────────┘
```

## Flujo de Comunicación

1. **Cliente** → Envía peticiones HTTP a los microservicios
2. **Eureka Server** → Registra y descubre servicios automáticamente  
3. **Microservicios** → Se comunican entre sí usando Spring Cloud
4. **Base de Datos** → Almacena toda la información del sistema

## Tecnologías Utilizadas

- **Backend**: Spring Boot 3.5.3, Spring Cloud
- **Base de Datos**: MySQL 8.0
- **Service Discovery**: Netflix Eureka
- **ORM**: JPA/Hibernate
- **Build Tool**: Maven
- **Java Version**: 21

## Endpoints Principales

### MS-Users (9002)
- `GET/POST/PUT/DELETE /api/users`
- `GET/POST/PUT/DELETE /api/roles`

### MS-Courses (9001)  
- `GET/POST/PUT/DELETE /api/courses`
- `GET/POST/PUT/DELETE /api/course-categories`

### MS-Grades (9003)
- `GET/POST/PUT/DELETE /api/student-marks`
- `GET /api/student-marks/student/{id}`
- `GET /api/student-marks/quiz/{id}`

### MS-Payments (9004)
- `GET/POST/PUT/DELETE /api/payments`

### MS-Support (9005)
- `GET/POST/PUT/DELETE /api/support-tickets`
- `GET /api/support-tickets/user/{id}`
- `GET /api/support-tickets/status/{status}`
