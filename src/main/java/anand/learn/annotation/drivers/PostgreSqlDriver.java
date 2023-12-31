package anand.learn.annotation.drivers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:postgresqldatabase.properties")
public class PostgreSqlDriver implements DataBaseDriver {

    @Value("${database-name}")
    private String databaseName;
    @Value("${disable-statement-pooling}")
    private String disableStatementPooling;



    public String getInfo() {
        return "[ Driver: postgres" +
                ", databaseName: " + databaseName +
                ", disableStatementPooling: " + disableStatementPooling +
                " ]";
    }
}
