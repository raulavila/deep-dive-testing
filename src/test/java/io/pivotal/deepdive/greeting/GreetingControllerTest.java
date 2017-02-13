package io.pivotal.deepdive.greeting;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GreetingControllerTest {

    @Mock
    private GreetingService greetingService;

    private GreetingController greetingController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        greetingController = new GreetingController(greetingService);

        mockMvc = MockMvcBuilders
                        .standaloneSetup(greetingController)
                        .build();

    }

    @Test
    public void shouldReturnGreetingMessageBuiltByGreetingService() throws Exception {
        when(greetingService.getGreeting(1)).thenReturn("Greeting!");

        mockMvc.perform(get("/greeting/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Greeting!"));
    }
}
