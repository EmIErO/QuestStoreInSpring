package com.codecool.controller;

import com.codecool.service.ArtifactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RunWith(SpringRunner.class)
@EnableWebMvc(ArtifactController.class)  //here it ensures that AppConfig is loaded as the application context
public class ArtifactControllerTest {

    // this class is the main entry point of our tests, we can execute requests by calling its perform() method
    private MockMvc mockMvc;


    @Autowired
    private ArtifactService artifactServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void seyUp() {
        Mockito.reset(artifactServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


}