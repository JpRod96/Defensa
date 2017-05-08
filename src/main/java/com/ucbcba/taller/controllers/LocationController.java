package com.ucbcba.taller.controllers;

import com.ucbcba.taller.entities.Location;
import com.ucbcba.taller.services.LocationService;
import com.ucbcba.taller.services.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by Jp on 25/04/2017.
 */
@Controller
public class LocationController
{
    private LocationService locationService;
    private TerminalService terminalService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }
    /**
     * List all locationss.
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("locations", locationService.listAllLocation());
        return "locations";
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public String showLocation(@PathVariable Integer id, Model model) {
        model.addAttribute("location", locationService.getLocationById(id));
        return "location";
    }


    @RequestMapping(value = "/location/delete/{id}", method = RequestMethod.GET)
    public String deleteLocation(@PathVariable Integer id, Model model) {
        locationService.deleteLocation(id);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/location/new", method = RequestMethod.GET)
    public String newLocation(Model model) {
        model.addAttribute("location", new Location());
        model.addAttribute("terminals",terminalService.listAllTerminal());
        return "locationForm";
    }

    @RequestMapping("location/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("location", locationService.getLocationById(id));
        model.addAttribute("terminals",terminalService.listAllTerminal());
        return "locationForm";
    }

    @RequestMapping(value = "/location", method = RequestMethod.POST)
    public String saveLocation(@Valid Location location, BindingResult bindingResult) {
        /*if (bindingResult.hasErrors()) {
            return "articulos";
        }*/
        locationService.saveLocation(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/location/inclikes/{id}", method = RequestMethod.GET)
    public String likesIncLocation(@PathVariable Integer id) {
        /*if (bindingResult.hasErrors()) {
            return "articulos";
        }*/
        Location location=locationService.getLocationById(id);
        location.incLikes();
        locationService.saveLocation(location);
        return "redirect:/location/{id}";
    }



    @RequestMapping(value = "/location/declikes/{id}", method = RequestMethod.GET)
    public String disLikesIncLocation(@PathVariable Integer id) {
        /*if (bindingResult.hasErrors()) {
            return "articulos";
        }*/
        Location location=locationService.getLocationById(id);
        location.decLikes();
        locationService.saveLocation(location);
        return "redirect:/location/{id}";
    }

    /*@RequestMapping("terminal/map/{id}")
    public String printMap(@PathVariable Integer id, Model model) {
        model.addAttribute("location", locationService.getLocationById(1));
        ArrayList<Integer> lista=new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        model.addAttribute("locations", lista);
        //model.addAttribute("locations", locationService.listAllLocation());
        return "Map";
    }*/
}
