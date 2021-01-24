package com.vargasraymondj.vaultpoc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VaultConfig {
    @Value("${foo}")
    private String foo;

    public String getFoo() {
        return foo;
    }
}
