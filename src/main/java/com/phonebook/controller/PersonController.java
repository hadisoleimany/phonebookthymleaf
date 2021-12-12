package com.phonebook.controller;

import com.phonebook.model.ContactType;
import com.phonebook.model.Person;
import com.phonebook.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public String getAllPersons(Model model) {
        model.addAttribute("listperson", service.getListPerson());
        return "listAllPerson";
    }

    @GetMapping(value = "/register")
    public String getRegisterPage(Model model) {
        Person person = new Person();
        model.addAttribute("personIns", person);
        return "personform";
    }

    @GetMapping(value = "/showUpdateForm")
    public ModelAndView getRegisterPage(@RequestParam Long personId) {
        ModelAndView view = new ModelAndView("personform");
        Person person = service.getById(personId);
        view.addObject("personIns", person);
        return view;
    }


    @GetMapping(value = "/deletePerson")
    public String deletePerson(@RequestParam Long personId) {
        service.deletePerson(personId);
        return "redirect:/";
    }

    @PostMapping(value = "/save")
    public String addPerson(@ModelAttribute Person person) {
        service.save(person);
        return "redirect:/";
    }

}

