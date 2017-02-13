package io.pivotal.deepdive;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DeepDiveApplicationEndToEndTest {

    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnGreetingForValidPersonId() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/greeting/1", String.class);

        String greeting = responseEntity.getBody();

        assertThat(greeting, Matchers.is("HELLO RAUL"));
    }

    @Test
    public void shouldReturnAnonymousGreetingForNotFoundPersonId() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/greeting/10", String.class);

        String greeting = responseEntity.getBody();

        assertThat(greeting, Matchers.is("HELLO ANONYMOUS"));
    }

}
