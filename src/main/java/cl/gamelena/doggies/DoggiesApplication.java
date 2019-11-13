package cl.gamelena.doggies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cl.gamelena.doggies")
public class DoggiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoggiesApplication.class, args);
    }
}
