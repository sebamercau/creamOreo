package com.smercau.creamOreo.DbConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mediaResManagerFactory", transactionManagerRef = "mediaResTransactionManager", basePackages = {
        "com.smercau.creamOreo.Repository.Oreo" })
public class H2Config {

    @Autowired
    private Environment enviroment;


    @Bean(name="mediaResDatasource")
    public DataSource mediaResDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(enviroment.getProperty("h2db.datasource.url"));
        dataSource.setUsername(enviroment.getProperty("h2db.datasource.username"));
        dataSource.setPassword(enviroment.getProperty("h2db.datasource.password"));
        dataSource.setDriverClassName(enviroment.getProperty("h2db.datasource.driverClassName"));

        return dataSource;
    }


    @Bean(name="mediaResManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(mediaResDatasource());
        emf.setPackagesToScan("com.smercau.creamOreo.Entity.Oreo");
        HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(hjva);

        /*Map<String, Objects> propierties = new HashMap<>();
        propierties.put("hibernate.show-sql",enviroment.getProperty("h2db.h2.console.enabled"));*/

        return emf;

    }


    @Bean(name="mediaResTransactionManager")
    public PlatformTransactionManager platformTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return jpaTransactionManager;
    }

}

