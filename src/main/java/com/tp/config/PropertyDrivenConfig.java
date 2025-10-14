package com.tp.config;

import com.tp.dao.IDao;
import com.tp.metier.MetierImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Map;

@Configuration
@PropertySource("classpath:app.properties")
public class PropertyDrivenConfig {

    // Injection de tous les beans IDao indexés par id de bean
    private final Map<String, IDao> candidates;

    public PropertyDrivenConfig(Map<String, IDao> candidates) {
        this.candidates = candidates;
    }

    @Value("${dao.target:dao}")
    private String target;

    @Bean(name = "dao")
    @DependsOn("propertySourcesPlaceholderConfigurer")
    public IDao selectedDao() {
        IDao bean = candidates.get(target);
        if (bean == null) {
            throw new IllegalArgumentException("Implémentation inconnue: " + target + " (dao|dao2|daoFile|daoApi)");
        }
        return bean;
    }

    // Résolution des placeholders @Value sans Spring Boot
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
