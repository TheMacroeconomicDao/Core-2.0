package gyber.org.mainCore.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//@ConfigurationProperties(prefix = "spring.datasource")
//@PropertySource("application.properties")
public class PersistenceDataSourceProperties extends DataSourceProperties{

    public PersistenceDataSourceProperties set$Name(@Value("${}") String dataBaseName) {
        super.setName(dataBaseName);
        return this;

    }

    public PersistenceDataSourceProperties set$Username(String username) {
        super.setUsername(username);
        return this;
    }

    public PersistenceDataSourceProperties set$DriverClassName(String driverClassName) {
        super.setDriverClassName(driverClassName);
        return this;
    }


    public PersistenceDataSourceProperties set$Url(String url) {
        super.setUrl(url);
        return this;
    }


    public PersistenceDataSourceProperties set$Password(String password) {
        super.setPassword(password);
        return this;
    }

    public DataSourceProperties build(){
        return this;
    }



}
