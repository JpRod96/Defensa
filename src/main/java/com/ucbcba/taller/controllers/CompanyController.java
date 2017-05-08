package com.ucbcba.taller.controllers;

import com.ucbcba.taller.entities.Company;
import com.ucbcba.taller.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Jp on 28/04/2017.
 */
@Controller
public class CompanyController
{
    private CompanyService companyService;
    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * List all companiess.
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("companies", companyService.listAllCompany());
        return "companies";
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public String showCompany(@PathVariable Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "company";
    }


    @RequestMapping(value = "/company/delete/{id}", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable Integer id, Model model) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

    @RequestMapping(value = "/company/new", method = RequestMethod.GET)
    public String newCompany(Model model) {
        model.addAttribute("company", new Company());
        return "companyForm";
    }

    @RequestMapping("company/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "companyForm";
    }


    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public String saveCompany(@Valid Company company, BindingResult bindingResult) {
        /*if (bindingResult.hasErrors()) {
            return "articulos";
        }*/
        companyService.saveCompany(company);
        return "redirect:/companies";
    }
}
