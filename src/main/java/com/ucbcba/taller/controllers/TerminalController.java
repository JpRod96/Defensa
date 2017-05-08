package com.ucbcba.taller.controllers;

import com.ucbcba.taller.entities.Location;
import com.ucbcba.taller.entities.Terminal;
import com.ucbcba.taller.services.CategoryService;
import com.ucbcba.taller.services.TerminalService;
import com.ucbcba.taller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Jp on 25/04/2017.
 */
@Controller
public class TerminalController
{
    private TerminalService terminalService;
    private CategoryService categoryService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * List all terminals.
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/terminals", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("terminals", terminalService.listAllTerminal());
        return "terminals";
    }

    @RequestMapping(value = "/terminal/{id}", method = RequestMethod.GET)
    public String showTerminal(@PathVariable Integer id, Model model) {
        model.addAttribute("terminal", terminalService.getTerminalById(id));
        return "terminal";
    }


    @RequestMapping(value = "/terminal/delete/{id}", method = RequestMethod.GET)
    public String deleteTerminal(@PathVariable Integer id, Model model) {
        terminalService.deleteTerminal(id);
        return "redirect:/terminals";
    }

    @RequestMapping(value = "/terminal/new", method = RequestMethod.GET)
    public String newTerminal(Model model) {
        model.addAttribute("terminal", new Terminal());
        model.addAttribute("categories", categoryService.listAllCategory());
        model.addAttribute("users", userService.listAllUser());
        return "terminalForm";
    }

    @RequestMapping("terminal/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("terminal", terminalService.getTerminalById(id));
        model.addAttribute("categories", categoryService.listAllCategory());
        model.addAttribute("users", userService.listAllUser());
        return "terminalForm";
    }

    @RequestMapping("terminal/map/{id}")
    public String printMap(@PathVariable Integer id, Model model) {
        ArrayList<Double> lats=getAllLats(terminalService.getTerminalById(id).getLocations());
        ArrayList<Double> lngs=getAllLngs(terminalService.getTerminalById(id).getLocations());
        model.addAttribute("lats", lats);
        model.addAttribute("lngs", lngs);
        //model.addAttribute("tamaño", lngs.size());
        return "Map";
    }

    private ArrayList<Double> getAllLats(Iterable<Location> locations)
    {
        Set<Location> loc=(Set<Location>)locations;
        ArrayList<Double>salida = new ArrayList<Double>();
        for(Location l:loc)
        {
            salida.add(l.getLat().doubleValue());
        }
        return salida;
    }

    private ArrayList<Double> getAllLngs(Iterable<Location> locations)
    {
        Set<Location> loc=(Set<Location>)locations;
        ArrayList<Double>salida = new ArrayList<Double>();
        for(Location l:loc)
        {
            salida.add(l.getLng().doubleValue());
        }
        return salida;
    }

    @RequestMapping(value = "/terminal", method = RequestMethod.POST)
    public String saveTerminal(@Valid Terminal terminal, BindingResult bindingResult) {
        /*if (bindingResult.hasErrors()) {
            return "articulos";
        }*/
        terminalService.saveTerminal(terminal);
        return "redirect:/terminals";
    }
}
