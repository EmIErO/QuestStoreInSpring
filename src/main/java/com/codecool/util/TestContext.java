package com.codecool.util;

import org.mockito.Mockito;
import com.codecool.service.ArtifactService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestContext {

    @Bean
    //@Primary
    public ArtifactService artifactServiceMock() {
        return Mockito.mock(ArtifactService.class);
    }
}
