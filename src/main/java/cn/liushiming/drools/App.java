package cn.liushiming.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author shiming
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
