package com.codecool.util;

import org.mockito.Mockito;
import com.codecool.service.ArtifactService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestContext {

    @Bean
    public ArtifactService artifactService() {
        return Mockito.mock(ArtifactService.class);
    }
}
