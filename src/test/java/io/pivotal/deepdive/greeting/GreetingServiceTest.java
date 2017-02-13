package io.pivotal.deepdive.greeting;

import io.pivotal.deepdive.person.Person;
import io.pivotal.deepdive.person.PersonNotFoundException;
import io.pivotal.deepdive.person.PersonRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class GreetingServiceTest {

    @Mock
    private PersonRepository personRepository;

    private GreetingService greetingService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        greetingService = new GreetingService(personRepository);
    }

    @Test
    public void shouldReturnValidGreeting_whenPersonIsFound() throws Exception {
        Person person = new Person("Raul", 22);

        when(personRepository.findById(1)).thenReturn(person);

        String greeting = greetingService.getGreeting(1);

        assertThat(greeting, Matchers.is("HELLO RAUL"));
    }

    @Test
    public void shouldReturnAnonymousGreeting_whenPersonIsNotFound() throws Exception {
        when(personRepository.findById(1)).thenThrow(PersonNotFoundException.class);

        String greeting = greetingService.getGreeting(1);

        assertThat(greeting, Matchers.is("HELLO ANONYMOUS"));
    }
}
