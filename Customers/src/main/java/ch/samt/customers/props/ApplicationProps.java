package ch.samt.customers.props;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "ch.samt")
@Data
public class ApplicationProps {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.profiles.active}")
    private String activeEnv;

    @Value("${ch.samt.envname}")
    private String environment;

}
