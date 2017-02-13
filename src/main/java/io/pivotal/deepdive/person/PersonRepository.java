package io.pivotal.deepdive.person;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {

    private Map<Integer, Person> personById = new HashMap<>();

    public PersonRepository() {
        personById.put(1, new Person("Raul", 22));
        personById.put(2, new Person("Mo", 17));
    }

    public Person findById(int personId) {
        if (!personById.containsKey(personId)) {
            throw new PersonNotFoundException();
        }

        return personById.get(personId);
    }
}
