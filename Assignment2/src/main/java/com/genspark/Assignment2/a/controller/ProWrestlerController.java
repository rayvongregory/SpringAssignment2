package com.genspark.Assignment2.a.controller;

import com.genspark.Assignment2.a.entity.ProWrestler;
import com.genspark.Assignment2.a.requests.ProWrestlerRequest;
import com.genspark.Assignment2.a.services.ProWrestlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/pro-wrestlers")
@RestController
public class ProWrestlerController {

    @Autowired
    private ProWrestlerService service;

    @GetMapping("/")
    public List<ProWrestler> getAllProWrestlers() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ProWrestler getProWrestlerById(@PathVariable(value = "id") int id) {
        return service.get(id);
    }

    @GetMapping("/name/{name}")
    public List<ProWrestler> getProWrestlerByName(@PathVariable(value = "name") String name) {
        return service.getByName(name);
    }

    @GetMapping("/finisher/{finisher}")
    public List<ProWrestler> getProWrestlerByFinisher(@PathVariable(value = "finisher") String finisher) {
        return service.getByFinisher(finisher);
    }

    @GetMapping("/active")
    public List<ProWrestler> getActiveProWrestlers() {
        return service.getActiveProWrestlers();
    }

    @GetMapping("/inactive")
    public List<ProWrestler> getInactiveProWrestlers() {
        return service.getInactiveProWrestlers();
    }

    @PutMapping("/edit-ring-name/{id}")
    public String editProWrestlerNameById(@RequestBody ProWrestlerRequest proWrestlerRequest, @PathVariable(value = "id") int id) {
        try {
            service.editRingName(proWrestlerRequest, id);
            return "Ring name of pro wrestler with id: " + id + " has been updated";
        } catch (NoSuchElementException e) {
            return "Pro wrestler with id: " + id + " was not found.";
        }
    }

    @PutMapping("/edit-finisher/{id}")
    public String editProWrestlerFinisherById(@RequestBody ProWrestlerRequest proWrestlerRequest, @PathVariable(value = "id") int id) {
        try {
            service.editFinisher(proWrestlerRequest, id);
            return "Finisher of pro wrestler with id: " + id + " has been updated";
        } catch (NoSuchElementException e) {
            return "Pro wrestler with id: " + id + " was not found.";
        }
    }

    @PutMapping("/edit-active-status/{id}")
    public String editProWrestlerActiveStatusById(@RequestBody ProWrestlerRequest proWrestlerRequest, @PathVariable(value = "id") int id) {
        try {
            service.editActiveStatus(proWrestlerRequest, id);
            return "Active status of pro wrestler with id: " + id + " has been updated";
        } catch (NoSuchElementException e) {
            return "Pro wrestler with id: " + id + " was not found.";
        }
    }

    @PostMapping("/new")
    public ProWrestler addNewProWrestlerWithDefaultActiveStatus(@RequestBody ProWrestlerRequest proWrestlerRequest) {
        return service.addNewProWrestler(proWrestlerRequest);
    }

    @PostMapping("/new/{active-status}")
    public ProWrestler addNewProWrestlerWithSpecifiedActiveStatus(@RequestBody ProWrestlerRequest proWrestlerRequest, @PathVariable(value = "active-status") boolean activeStatus) {
        return service.addNewProWrestler(proWrestlerRequest, activeStatus);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProWrestlerById(@PathVariable(value = "id") int id) {
        try {
            String name = service.get(id).getRingName();
            service.deleteProWrestler(id);
            return name + " has been removed from the database";
        } catch (NoSuchElementException e) {
            return "Pro wrestler with id: " + id + " was not found.";
        }
    }
}
