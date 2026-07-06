package com.example.ems.config;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.beans.factory.ObjectProvider;

@Configuration
public class JpaBuilderConfig {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(
            JpaProperties jpaProperties,
            ObjectProvider<PersistenceUnitManager> persistenceUnitManager) {
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        return new EntityManagerFactoryBuilder(
                jpaVendorAdapter,
                jpaProperties.getProperties(),
                persistenceUnitManager.getIfAvailable());
    }
}
