package io.pivotal.deepdive.greeting;

import io.pivotal.deepdive.person.Person;
import io.pivotal.deepdive.person.PersonNotFoundException;
import io.pivotal.deepdive.person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    private PersonRepository personRepository;

    @Autowired
    public GreetingService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public String getGreeting(int personId) {
        String name;
        try {
            Person person = personRepository.findById(personId);
            name = person.getName();
        } catch (PersonNotFoundException e) {
            logger.warn("PersonId not found: " + personId,  e);
            name = "anonymous";
        }

        name = name.toUpperCase();

        return "HELLO " + name;
    }
}
