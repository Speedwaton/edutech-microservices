package com.edutech.users.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.edutech.users.mapper",
    "com.edutech.users.service",
    "com.edutech.users.controller",
    "com.edutech.users.repository"
})
public class MapperConfiguration {
    // Esta configuración asegura que Spring escanee todas las clases generadas por MapStruct
}
