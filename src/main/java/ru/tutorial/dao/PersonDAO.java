package ru.tutorial.dao;

import org.springframework.stereotype.Component;
import ru.tutorial.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Katty"));
        people.add(new Person(++PEOPLE_COUNT, "Sally"));
        people.add(new Person(++PEOPLE_COUNT, "Frank"));
        people.add(new Person(++PEOPLE_COUNT, "Colin"));
        people.add(new Person(++PEOPLE_COUNT, "Stan"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
       return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
