package com.astrategy.pokemine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class PokemineApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemineApplication.class, args);
    }

}


