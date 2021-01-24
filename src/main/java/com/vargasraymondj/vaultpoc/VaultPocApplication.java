package com.vargasraymondj.vaultpoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.*;
import org.springframework.vault.support.Ciphertext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.vault.core.VaultOperations;


@SpringBootApplication
public class VaultPocApplication {
    private Logger log = LoggerFactory.getLogger(VaultPocApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VaultPocApplication.class, args);
    }

}

@RestController
class TransitTest {

    @Autowired
    private VaultTemplate vaultTemplate;

    @GetMapping
    public String test() {
       String l = vaultTemplate.opsForTransit().encrypt("myTestKey", "jackalope");
       return vaultTemplate.opsForTransit().decrypt("myTestKey", l);
    }

    @PostMapping(value = "/encrypt")
    public Payload encryptPayload(@RequestBody Payload payload){
        payload.setPassword(vaultTemplate.opsForTransit().encrypt("myTestKey", payload.getPassword()));
        return payload;
    }
    @PostMapping(value = "/decrypt")
    public Payload decryptPayload(@RequestBody Payload payload){
        payload.setPassword(vaultTemplate.opsForTransit().decrypt("myTestKey", payload.getPassword()));
        return payload;
    }

}

class Payload {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}