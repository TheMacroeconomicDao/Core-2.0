package gyber.org.mainCore.data.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "gyber.org.mainCore.data")
public class SpringJPAConfig {



//    @Bean
//    public PersistenceDataSourceProperties persistenceDataSourceProperties(){
////        return new PersistenceDataSourceProperties()
////                .initializeDataSourceBuilder()
////                .
//    }


    @Bean
    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .url("jdbc:mysql://localhost:3306/userdaotest")
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .username("root")
//                .password("abcdef")
//                .build();
        return new DataSourceProperties()
                        .initializeDataSourceBuilder()
                        .url("jdbc:mysql://localhost:3306/userdaotest")
                        .driverClassName("com.mysql.cj.jdbc.Driver")
                        .username("root")
                        .password("abcdef")
                        .build();
    }


    @Bean
    public DataSourceProperties dataSourceProperties(){

        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/userdaotest");
        dataSourceProperties.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceProperties.setUsername("root");
        dataSourceProperties.setPassword("abcdef");

        return dataSourceProperties;
    }





    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setPackagesToScan("gyber.org.mainCore.data");

//        Properties jpaProperties = new Properties();
//        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        jpaProperties.put("hibernate.show_sql", true);

        //em.setPersistenceUnitName("mysql");
//        em.setJpaProperties(jpaProperties);


        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }


//

}
