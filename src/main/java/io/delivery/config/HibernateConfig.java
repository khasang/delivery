package io.delivery.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:hibernate.properties"})
public class HibernateConfig {
    private Environment environment;

    @Autowired
<<<<<<< HEAD
    HibernateConfig(Environment environment) {
=======
    HibernateConfig(Environment environment){
>>>>>>> origin/feedback
        this.environment = environment;
    }

    @Bean
<<<<<<< HEAD
    public LocalSessionFactoryBean sessionFactory() {
=======
    public LocalSessionFactoryBean sessionFactory(){
>>>>>>> origin/feedback
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("io.delivery.entity");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        return localSessionFactoryBean;
    }

    @Bean
<<<<<<< HEAD
    public DataSource dataSource() {
=======
    public DataSource dataSource(){
>>>>>>> origin/feedback
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("hibernate.driverClass"));
        dataSource.setUrl(environment.getProperty("hibernate.url"));
        dataSource.setUsername(environment.getProperty("hibernate.username"));
        dataSource.setPassword(environment.getProperty("hibernate.password"));
        return dataSource;
    }

<<<<<<< HEAD
    private Properties hibernateProperties() {
=======
    private Properties hibernateProperties(){
>>>>>>> origin/feedback
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("show_sql", environment.getRequiredProperty("hibernate.show_sql"));
<<<<<<< HEAD
=======
        properties.put("hibernate.cache.region.factory_class", environment.getRequiredProperty("hibernate.cache.region.factory_class"));
>>>>>>> origin/feedback
        return properties;
    }

    @Bean
    @Autowired
<<<<<<< HEAD
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
=======
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
>>>>>>> origin/feedback
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
