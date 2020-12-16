package com.example.azure.wsfake;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeController {
    @GetMapping("/value")
    public Result getResult() {
        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl("https://kv-csp-test-secret.vault.azure.net")
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();

        KeyVaultSecret test = secretClient.getSecret("test");
        return new Result("Foo Bar " + test.getValue());
    }

    @PostMapping("/value/{value}")
    public Result UpdateValue(@PathVariable String value) {
        return new Result(value.toUpperCase());
    }
}
