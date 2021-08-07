package sr.hit.helloworld.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "firebase")
public class FirebaseProperties {
    private String user;
    private String pwd;

}