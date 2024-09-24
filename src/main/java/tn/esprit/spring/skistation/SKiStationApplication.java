package tn.esprit.spring.skistation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAspectJAutoProxy
@SpringBootApplication
@EntityScan(basePackages = {"tn.esprit.spring.entity"})
@ComponentScan(basePackages = {"tn.esprit.spring.controllers","tn.esprit.spring.services","tn.esprit.spring.config"})
@EnableJpaRepositories(basePackages = {"tn.esprit.spring.repositories"})
public class SKiStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SKiStationApplication.class, args);
    }

}
