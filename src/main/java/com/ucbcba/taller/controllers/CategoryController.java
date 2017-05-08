package com.ucbcba.taller.controllers;

import com.ucbcba.taller.entities.Category;
import com.ucbcba.taller.services.CategoryService;
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
public class CategoryController
{
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * List all categories.
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("categories", categoryService.listAllCategory());
        return "categories";
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public String showTerminal(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "category";
    }


    @RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
    public String deleteTerminal(@PathVariable Integer id, Model model) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/category/new", method = RequestMethod.GET)
    public String newTerminal(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @RequestMapping("category/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "categoryForm";
    }


    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String saveTerminal(@Valid Category terminal, BindingResult bindingResult) {
        /*if (bindingResult.hasErrors()) {
            return "articulos";
        }*/
        categoryService.saveCategory(terminal);
        return "redirect:/categories";
    }
}
