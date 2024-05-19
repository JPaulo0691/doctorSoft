package com.br.doctorsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.br.doctorsoft.repository")
public class DoctorSoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorSoftApplication.class, args);
    }

}
