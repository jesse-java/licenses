package com.naldojesse.license.controllers;

import com.naldojesse.license.models.License;
import com.naldojesse.license.models.Person;
import com.naldojesse.license.services.LicenseService;
import com.naldojesse.license.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class LicenseController {

    private final PersonService personService;
    private final LicenseService licenseService;
    public LicenseController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @RequestMapping("/persons/new")
    public String new_person(@ModelAttribute("person") Person person) {
        return "person_new.jsp";
    }

    @RequestMapping("/persons/create")
    public String create_person(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        System.out.println("in create method");
        if (result.hasErrors()) {
            return "person_new.jsp";
        } else {
            personService.addPerson(person);
            return "redirect:/persons/new";
        }
    }

    @RequestMapping("/licenses/new")
    public String new_license(@ModelAttribute("license") License license, Model model) {
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        return "license_new.jsp";
    }

    @RequestMapping("/persons/{id}")
    public String findPersonByIndex(Model model, @PathVariable("id") Long index) {
        Optional<Person> person = personService.findPersonById(index);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
        } else {
            return "redirect:/persons/new";
        }
        return "person_view.jsp";
    }

    @RequestMapping("/licenses/create")
    public String create_license(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Person> persons = personService.allPersons();
            model.addAttribute("persons", persons);
            return "license_new.jsp";
        } else {
            System.out.println("working");
            licenseService.addLicense(license);
            return "redirect:/licenses/new";
        }
    }
}
//}
