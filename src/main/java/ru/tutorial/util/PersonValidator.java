package ru.tutorial.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tutorial.dao.PersonDAO;
import ru.tutorial.models.Person;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if(personDAO.show(person.getId()) != null) return;

        if (personDAO.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email address is already in use");
        }
    }
}
