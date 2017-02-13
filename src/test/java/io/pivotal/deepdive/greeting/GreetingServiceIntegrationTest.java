package io.pivotal.deepdive.greeting;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingServiceIntegrationTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void shouldReturnValidGreeting_whenPersonIsFound() throws Exception {
        String greeting = greetingService.getGreeting(1);

        assertThat(greeting, Matchers.is("HELLO RAUL"));
    }

    @Test
    public void shouldReturnAnonymousGreeting_whenPersonIsNotFound() throws Exception {
        String greeting = greetingService.getGreeting(24);

        assertThat(greeting, Matchers.is("HELLO ANONYMOUS"));
    }

}
