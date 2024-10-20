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
        people.add(new Person(++PEOPLE_COUNT, "Katty", 35, "katty@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sally", 23, "sally@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Frank", 34, "frank1111@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Colin", 45, "cilinushka@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Stan", 12, "stanlee@mail.ru"));
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

    public void update(int id, Person updatedPerson) {
        Person personToUpdated = show(id);
        personToUpdated.setName(updatedPerson.getName());
        personToUpdated.setAge(updatedPerson.getAge());
        personToUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }

}
