package com.example.ems.config;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

    @Bean
    public HibernatePropertiesCustomizer hibernateStatisticsCustomizer() {
        return hibernateProperties -> hibernateProperties.put("hibernate.generate_statistics", "true");
    }
}
