/*
************************************************************************************************************************
    Tutorial from:
    http://zetcode.com/springboot/component/
************************************************************************************************************************
*/
package com.example.demo.component;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomNameGenerator {

    public String generate() {

        var names = List.of("Peter", "Roland", "Lucy", "Robert", "Jane");

        var r = new Random();
        int i = r.nextInt(names.size());

        return names.get(i);
    }
}
