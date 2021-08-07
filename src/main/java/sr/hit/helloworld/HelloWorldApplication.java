package sr.hit.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sr.hit.helloworld.config.FirebaseProperties;

@SpringBootApplication
@EnableConfigurationProperties(FirebaseProperties.class)
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
