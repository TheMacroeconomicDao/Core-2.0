package gyber.org.mainCore.data.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;
//
//@Configuration
//@EnableJpaRepositories(basePackages = "gyber.org.mainCore.data")
public class SpringJPAConfig {



//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("abcdef");
//        dataSource.setUrl(
//                "jdbc:mysql://localhost:3306/userdaotest?createDatabaseIfNotExist=true");
//
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        em.setPackagesToScan("gyber.org.mainCore.data");
//        em.setJpaProperties(properties());
//
//
//        return em;
//    }
//    @Bean
//    public Properties properties(){
//
//        Properties jpaProperties = new Properties();
//
//        jpaProperties.put("spring.jpa.hibernate.ddl-auto" , "update");
////        jpaProperties.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
////        jpaProperties.put("spring.jpa.show-sql", true);
//
//
//        return jpaProperties;
//
//    }


//

}
