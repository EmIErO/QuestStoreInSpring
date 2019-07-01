package com.codecool.controller;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;
import com.codecool.model.wrapper.ListWrapper;
import com.codecool.service.ArtifactService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

// Pointless is in this case, view resolvers are define in webAppContext, which is not loaded here
// => no response body is generated
public class ArtifactControllerStandaloneTest {

    // this class is the main entry point of our tests, we can execute requests by calling its perform() method
    private MockMvc mockMvc;


    @Mock
    private ArtifactService artifactServiceMock;

    @InjectMocks
    private ArtifactController artifactController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(artifactController).build();
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
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("artifacts"))
                .andExpect(model().attribute("artifactsWrapper", instanceOf(ListWrapper.class)))
//                .andExpect(content().contentType("application/json"))
                ;

        verify(artifactServiceMock, times(1)).getAllArtifacts();
        verifyNoMoreInteractions(artifactServiceMock);
    }

}