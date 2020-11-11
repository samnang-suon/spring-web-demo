/*
************************************************************************************************************************
    Tutorial from:
    https://www.journaldev.com/21429/spring-component
************************************************************************************************************************
*/
package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component("mc")
public class MathComponent {
    public int add(int x, int y) {
        return x + y;
    }
}
