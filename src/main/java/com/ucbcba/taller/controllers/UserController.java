package com.ucbcba.taller.controllers;


import com.ucbcba.taller.entities.User;
import com.ucbcba.taller.services.CompanyService;
import com.ucbcba.taller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Jp on 26/04/2017.
 */
@Controller
public class UserController
{
    private UserService UserService;
    private CompanyService companyService;

    @Autowired
    public void setUserService(UserService UserService) {
        this.UserService = UserService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * List all users.
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", UserService.listAllUser());
        return "users";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", UserService.getUserById(id));
        return "user";
    }


    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id, Model model) {
        UserService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", UserService.listAllUser());
        model.addAttribute("allcompanies", companyService.listAllCompany());
        return "userForm";
    }

    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("user", UserService.getUserById(id));
        model.addAttribute("users", UserService.listAllUser());
        model.addAttribute("allcompanies", companyService.listAllCompany());
        return "userForm";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        /*if (bindingResult.hasErrors()) {
            return "articulos";
        }*/
        UserService.saveUser(user);
        return "redirect:/users";
    }
}
