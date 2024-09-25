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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "twinsRegistroFaenaCustomManagerFactory", transactionManagerRef = "twinsRegistroFaenaCustomTransactionManager", basePackages = {
"com.smercau.creamOreo.Repository.TwinsCustom" })
public class SqlServerConfig {

    @Autowired
    private Environment enviroment;

    @Bean(name="twinsRegistroFaenaCustomDatasource")
    public DataSource twinsRegistroFaenaCustomDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(enviroment.getProperty("sqlserver.datasource.url"));
        dataSource.setUsername(enviroment.getProperty("sqlserver.datasource.username"));
        dataSource.setPassword(enviroment.getProperty("sqlserver.datasource.password"));
        dataSource.setDriverClassName(enviroment.getProperty("sqlserver.datasource.driver-class-name"));

        return dataSource;
    }


    @Bean(name="twinsRegistroFaenaCustomManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(twinsRegistroFaenaCustomDatasource());
        emf.setPackagesToScan("com.smercau.creamOreo.Entity.Twins");
        HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(hjva);

        /*Map<String, Object> propierties = new HashMap<>();
        propierties.put("hibernate.show-sql",enviroment.getProperty("mysql.jpa.show-sql"));
        propierties.put("hibernate.dialect",enviroment.getProperty("mysql.jpa.database-platform"));

        emf.setJpaPropertyMap(propierties);*/

        return emf;

    }

    @Bean(name="twinsRegistroFaenaCustomTransactionManager")
    public PlatformTransactionManager platformTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return jpaTransactionManager;
    }

}

