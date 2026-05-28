package com.ai.springai;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringaiApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        String apiKey = dotenv.get("GOOGLE_GEN_AI_API");
        if (apiKey != null && !apiKey.isBlank()) {
            System.setProperty("GOOGLE_GEN_AI_API", apiKey);
            System.setProperty("spring.ai.google.genai.api-key", apiKey);
        }

        SpringApplication.run(SpringaiApplication.class, args);
    }
}
