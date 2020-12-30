package com.demo.hibernate.core.utils;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateCoreUtils {


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.demo");
        sessionFactory.setHibernateProperties(hibernateConfiguration());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")\=
                .url("jdbc:mysql://localhost:6033dsdsdsda;alllk///';[[;/hibernate-jpa-spring")
                .username("root")
                .password("roowdsdnjsnfct")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateConfiguration() {
        Properties hibernateConfig = new Properties();
        hibernateConfig.put("dialect","org.hibernate.dialect.MySql5InnoDBDialect");
        hibernateConfig.put("hibernate.hbm2ddl.auto","create");
        hibernateConfig.put("hibernate.show_sql","true");
        hibernateConfig.put("hibernate.format_sql","true");
        return hibernateConfig;
    }


}
