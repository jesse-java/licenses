package com.naldojesse.license.controllers;

import com.naldojesse.license.models.License;
import com.naldojesse.license.models.Person;
import com.naldojesse.license.services.LicenseService;
import com.naldojesse.license.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LicenseController {
    private final PersonService personService;
    private final LicenseService licenseService;
//    public LicenseController(PersonService personService) {
//        this.personService = personService;
//    }
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
    public String new_license(@ModelAttribute("license") License license) {
        return "license_new.jsp";
    }

//    @RequestMapping("/persons/{id}")
//    public String show_person() {
//        return;
//    }

    @RequestMapping("/licenses/create")
    public String create_license(@Valid @ModelAttribute("license") License license) {

        return "";
    }
}
//}
