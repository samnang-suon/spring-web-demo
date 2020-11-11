package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    // http://localhost:8080/hello
    public String getHomePage() {
        return "hello";
    }

    // First way to use Model
    @RequestMapping(method = RequestMethod.GET, value = "/model")
    public String getHomePagWithModel(Model model) {
        model.addAttribute("secret", "lorem ipsum");
        return "hello";
    }

    // Second way to use Model
    @ModelAttribute("getHomePagWithModelAttribute")
    public String getHomePagWithModelAttribute() {
        return "lorem ipsum";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/response-body")
    @ResponseBody
    public String getResponseBodyWithoutView() {
        return "<h1>Hello from responseBody()<h1>" +
                "<h2>H2<h2>" +
                "<h3>H3<h3>";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/showForm")
    // http://localhost:8080/hello/showForm
    public String getHomeForm() {
        return "hello-form";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/processForm")
    // http://localhost:8080/hello/processForm
    public String getHomeProcessedForm(
        HttpServletRequest request,
        Model model
    ) {
        String name = request.getParameter("user_name_input");
        model.addAttribute("received_user_name", name);
        return "hello-processed-form";
    }
}
