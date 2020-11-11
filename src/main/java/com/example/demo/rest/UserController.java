package com.example.demo.rest;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private ArrayList<Person> persons;
    private int nextID;

    public UserController() {
        this.persons = new ArrayList<>();
        this.nextID = 1;
    }

    @GetMapping("/{id}")
    // http://localhost:8080/user/{id}
    public String getUserById(
            @PathVariable("id") int id
    ) {
        Person foundPerson = null;
        for(Person p : this.persons) {
            if(p.getId() == id) {
                foundPerson = p;
                break;
            }
        }
        Gson gson = new Gson();
        return gson.toJson(foundPerson);
    }

    @GetMapping
    // GET http://localhost:8080/user
    public String getUser() {
        Gson gson = new Gson();
        return gson.toJson(this.persons);
    }

    @PostMapping
    // POST http://localhost:8080/user
    public String postUser(
            @RequestParam(value = "first_name", defaultValue = "default_first_name") String firstName,
            @RequestParam(value = "last_name", defaultValue = "default_last_name") String lastName,
            @RequestParam(value = "age", defaultValue = "16") int age,
            @RequestParam(value = "is_married", defaultValue = "false") boolean isMarried
    ) {
        int nextId = this.nextID++;
        Person temp = new Person(nextId, firstName, lastName, age, isMarried);
        this.persons.add(temp);
        Gson gson = new Gson();
        return gson.toJson(temp);
    }

    @PutMapping
    // PUT http://localhost:8080/user
    public String putUser(
            @RequestParam(value = "id", defaultValue = "1") int id,
            @RequestParam(value = "first_name", defaultValue = "default_first_name") String firstName,
            @RequestParam(value = "last_name", defaultValue = "default_last_name") String lastName,
            @RequestParam(value = "age", defaultValue = "16") int age,
            @RequestParam(value = "is_married", defaultValue = "false") boolean isMarried
    ) {
        Person foundPerson = null;
        for(Person p : this.persons) {
            if(p.getId() == id) {
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setAge(age);
                p.setMarried(isMarried);
                foundPerson = p;
                break;
            }
        }
        Gson gson = new Gson();
        return gson.toJson(foundPerson);
    }

    @DeleteMapping
    // PUT http://localhost:8080/user
    public String putUser(
            @RequestParam(value = "id", defaultValue = "1") int id
    ) {
        for(Person p : this.persons) {
            if(p.getId() == id) {
                this.persons.remove(p);
                break;
            }
        }
        Gson gson = new Gson();
        return gson.toJson(this.persons);
    }

    public class Person {
        private int id;
        private String firstName;
        private String lastName;
        private int age;
        private boolean isMarried;

        public Person(
                int id,
                String firstName,
                String lastName,
                int age,
                boolean isMarried
        ) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.isMarried = isMarried;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isMarried() {
            return isMarried;
        }

        public void setMarried(boolean married) {
            isMarried = married;
        }
    }
}
