package gyber.org.mainCore.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@PropertySource("application.properties")
public class PersistenceDataSourceProperties extends DataSourceProperties {

//    @Override
//    public void setName(@Value("${}") String name) {
//        super.setName(name);
//    }


}
