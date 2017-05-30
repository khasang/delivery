package io.delivery.config;

import io.delivery.by.belavia.webservices.ClientBelaviaAirlines;
import io.delivery.dao.*;
import io.delivery.dao.impl.*;
import io.delivery.entity.*;
import io.delivery.model.Answer;
import io.delivery.model.BackupCreator;
import io.delivery.model.NewsCreator;
import io.delivery.model.TableCreator;
import io.delivery.model.impl.BackupCreatorIml;
import io.delivery.model.impl.NewsCreatorImpl;
import io.delivery.net.webservicex.ClientWeather;
import io.delivery.service.*;
import io.delivery.service.impl.*;
import net.yandex.speller.services.spellservice.Client;
import org.russianpost.ClientRussianPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
@PropertySource(value = {"classpath:auth.properties"})
@PropertySource(value = {"classpath:backup.properties"})
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(dataSource());
        jdbcImpl.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        jdbcImpl.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcImpl;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public CreateTable createTable() {
        return new CreateTableImpl(jdbcTemplate());
    }

    @Bean
    public InsertUser insertUser() {
        return new InsertUserImpl(jdbcTemplate());
    }

    @Bean
    public UpdateTable updateTable() {
        return new UpdateTableImpl(jdbcTemplate());
    }

    @Bean
    public SelectTable selectTable() {
        return new SelectTableImpl(jdbcTemplate());
    }

    @Bean
    public PreparedSQL preparedSQL() {
        return new PreparedSQLImpl(jdbcTemplate());
    }

    @Bean
    public DumpDB dumpDB() {
        return new DumpDbImpl();
    }

    @Bean
    public Test test() {
        return new TestImpl("test");
    }

    @Bean
    public Answer answer() {
        return new Answer();
    }

    @Bean
    public DocumentDao documentDao() {
        return new DocumentDaoImpl(Document.class);
    }

    @Bean
    public NewsCreator newsCreator() {
        return new NewsCreatorImpl(jdbcTemplate());
    }

    @Bean
    public NewsDao newsDao() {
        return new NewsDaoImpl(News.class);
    }

    @Bean
    public NoRegistrationCustomerDao noRegistrationCustomerDao() {
        return new NoRegistrationCustomerDaoImpl(NoRegistrationCustomer.class);
    }

    @Bean
    public OfficeDao officeDao() {
        return new OfficeDaoImpl(Office.class);
    }

    @Bean
    public CustomerDao customerDao() {
        return new CustomerDaoImpl(Customer.class);
    }

    @Bean
    UserDao userDao() {
        return new UserDaoIml(User.class);
    }

    @Bean
    public BackupCreator backupCreator() {
        return new BackupCreatorIml();
    }

    @Bean
    public Client client() {
        return new Client();
}

     @Bean       
    public OrderDao orderDao() {
        return new OrderDaoImpl(Order.class);
    }

    @Bean
    public CountryClient countryClient() {
        return new CountryClient();

    }

    @Bean
    public ClientBelaviaAirlines clientBelavia(){
        return new ClientBelaviaAirlines();}

    @Bean
    public ClientWeather clientWeather() {
        return new ClientWeather();
    }

	@Bean
    public ClientRussianPost clientRussianPost() {
        return new ClientRussianPost();
    }
}

