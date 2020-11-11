/*
************************************************************************************************************************
    Tutorial from:
    http://zetcode.com/springboot/component/
************************************************************************************************************************
*/
package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private RandomNameGenerator randGenerator;

    @Override
    public void run(String... args) {
        System.out.println("============================== BEGIN MY RUNNER ==============================");
        System.out.println("========== GENERATING RANDOM NAMES ==========");
        System.out.println(randGenerator.generate());
        System.out.println(randGenerator.generate());
        System.out.println(randGenerator.generate());

        System.out.println("========== MATH COMPONENT ==========");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.component"); // Need this. Otherwise 'A component required a bean named 'mc' that could not be found.'
        context.refresh();

        // MathComponent ms = context.getBean(MathComponent.class);
        // Or
        MathComponent ms = (MathComponent) context.getBean("mc");

        int result = ms.add(1, 2);
        System.out.println("Addition of 1 and 2 = " + result);
        context.close();
        System.out.println("============================== END MY RUNNER ==============================");
    }
}
