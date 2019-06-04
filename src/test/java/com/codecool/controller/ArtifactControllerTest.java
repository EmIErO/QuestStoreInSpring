package com.codecool.controller;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;
import com.codecool.service.ArtifactService;
import com.codecool.util.AppConfig;
import com.codecool.util.TestContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestContext.class, AppConfig.class})
@WebAppConfiguration //here it ensures that AppConfig.class is loaded as the application context
public class ArtifactControllerTest {

    // this class is the main entry point of our tests, we can execute requests by calling its perform() method
    private MockMvc mockMvc;


    @Autowired
    private ArtifactService artifactServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(artifactServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void listAll_ShouldAddArtifactEntriesToModelAndRenderArtifactsView() throws Exception {
        Artifact first = new ArtifactBuilder()
                .id(1)
                .name("consultation")
                .price(20)
                .description("Consult a mentor")
                .category(ArtifactCategory.INDIVIDUAL)
                .build();

        Artifact second = new ArtifactBuilder()
                .id(2)
                .name("teleport")
                .price(100)
                .description("Lessons outside")
                .category(ArtifactCategory.GROUP)
                .build();

        when(artifactServiceMock.getAllArtifacts()).thenReturn(Arrays.asList(first, second));

        mockMvc.perform(get("/artifacts/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("artifacts"))
                .andExpect(forwardedUrl("WEB-INF/jsp/artifacts.jsp"))
                .andExpect(model().attribute("artifacts", hasSize(2)))
                .andExpect(model().attribute("artifacts", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("name", is("consultation")),
                                hasProperty("price", is(20)),
                                hasProperty("description", is("Consult a mentor")),
                                hasProperty("category", is(ArtifactCategory.INDIVIDUAL))
                        )
                )))
                .andExpect(model().attribute("artifacts", hasItem(
                        allOf(
                                hasProperty("id", is(2)),
                                hasProperty("name", is("teleport")),
                                hasProperty("price", is(100)),
                                hasProperty("description", is("Lessons outside")),
                                hasProperty("category", is(ArtifactCategory.GROUP))
                        )
                )))
                ;

        verify(artifactServiceMock, times(1)).getAllArtifacts();
        verifyNoMoreInteractions(artifactServiceMock);
    }

}