package io.pivotal.deepdive.person;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PersonRepositoryTest {

    private final PersonRepository personRepository = new PersonRepository();

    @Test
    public void shouldReturnPerson_whenValidPersonIdIsUsed() throws Exception {
        Person person = personRepository.findById(1);

        assertThat(person.getName(), is("Raul"));
        assertThat(person.getAge(), is(22));
    }

    @Test(expected = PersonNotFoundException.class)
    public void shouldThrowPersonNotFoundException_whenPersonIdDoesNotExist() throws Exception {
        personRepository.findById(8);
    }
}
