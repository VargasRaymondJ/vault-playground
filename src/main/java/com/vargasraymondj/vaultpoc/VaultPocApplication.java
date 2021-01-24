package com.vargasraymondj.vaultpoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaultPocApplication {
    private Logger log = LoggerFactory.getLogger(VaultPocApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VaultPocApplication.class, args);
    }

}
