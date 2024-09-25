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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "twinsRegistroFaenaManagerFactory", transactionManagerRef = "twinsRegistroFaenaTransactionManager", basePackages = {
        "com.smercau.creamOreo.Repository.Twins" })
public class MySqlConfig {

    @Autowired
    private Environment enviroment;

    @Primary
    @Bean(name="twinsRegistroFaenaDatasource")
    public DataSource twinsRegistroFaenaDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(enviroment.getProperty("mysql.datasource.url"));
        dataSource.setUsername(enviroment.getProperty("mysql.datasource.username"));
        dataSource.setPassword(enviroment.getProperty("mysql.datasource.password"));
        dataSource.setDriverClassName(enviroment.getProperty("mysql.datasource.driver-class-name"));

        return dataSource;
    }

    @Primary
    @Bean(name="twinsRegistroFaenaManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(twinsRegistroFaenaDatasource());
        emf.setPackagesToScan("com.smercau.creamOreo.Entity.Twins");
        HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(hjva);
        /*Map<String, Objects> propierties = new HashMap<>();
        propierties.put("hibernate.dialect","");*/

        return emf;

    }

    @Primary
    @Bean(name="twinsRegistroFaenaTransactionManager")
    public PlatformTransactionManager platformTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return jpaTransactionManager;
    }

}
