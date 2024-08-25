package com.jkcreation.Collegify.controller;

import com.jkcreation.Collegify.entity.College;
import com.jkcreation.Collegify.entity.Contact;
import com.jkcreation.Collegify.entity.Cutoff;
import com.jkcreation.Collegify.repository.CollegeRepository;
import com.jkcreation.Collegify.repository.CutoffRepository;
import com.jkcreation.Collegify.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private CutoffRepository cutoffRepository;

    @Autowired
    private ContactService contactService;

    // ** COLLEGE OPERATIONS **

    @GetMapping("/colleges")
    public String listColleges(Model model) {
        model.addAttribute("colleges", collegeRepository.findAll());
        return "admin/colleges";
    }
    @GetMapping("/contacts")
    public String viewContacts(Model model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "admin/admin-contacts";
    }



    @GetMapping("/colleges/new")
    public String showAddCollegeForm(Model model) {
        model.addAttribute("college", new College());
        return "admin/add-college";
    }

    @PostMapping("/colleges")
    public String addCollege(@ModelAttribute College college) {
        collegeRepository.save(college);
        return "redirect:/admin/colleges";
    }

    @GetMapping("/colleges/edit/{id}")
    public String showEditCollegeForm(@PathVariable("id") Long id, Model model) {
        College college = collegeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found"));
        model.addAttribute("college", college);
        return "admin/edit-college";
    }

    @PostMapping("/colleges/{id}")
    public String updateCollege(@PathVariable("id") Long id, @ModelAttribute College college) {
        if (!collegeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found");
        }
        college.setId(id);
        collegeRepository.save(college);
        return "redirect:/admin/colleges";
    }

    @GetMapping("/colleges/delete/{id}")
    public String deleteCollege(@PathVariable("id") Long id) {
        if (!collegeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found");
        }
        collegeRepository.deleteById(id);
        return "redirect:/admin/colleges";
    }

    // ** CUTOFF OPERATIONS **

    @GetMapping("/cutoffs")
    public String listCutoffs(Model model) {
        model.addAttribute("cutoffs", cutoffRepository.findAll());
        return "admin/cutoffs";
    }

    @GetMapping("/cutoffs/new")
    public String showAddCutoffForm(Model model) {
        model.addAttribute("cutoff", new Cutoff());
        model.addAttribute("colleges", collegeRepository.findAll());
        return "admin/add-cutoff";
    }

    @PostMapping("/cutoffs")
    public String addCutoff(@ModelAttribute Cutoff cutoff) {
        cutoffRepository.save(cutoff);
        return "redirect:/admin/cutoffs";
    }

    @GetMapping("/cutoffs/edit/{id}")
    public String showEditCutoffForm(@PathVariable("id") Long id, Model model) {
        Cutoff cutoff = cutoffRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cutoff not found"));
        model.addAttribute("cutoff", cutoff);
        model.addAttribute("colleges", collegeRepository.findAll());
        return "admin/edit-cutoff";
    }

    @PostMapping("/cutoffs/{id}")
    public String updateCutoff(@PathVariable("id") Long id, @ModelAttribute Cutoff cutoff) {
        if (!cutoffRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cutoff not found");
        }
        cutoff.setId(id);
        cutoffRepository.save(cutoff);
        return "redirect:/admin/cutoffs";
    }

    @GetMapping("/cutoffs/delete/{id}")
    public String deleteCutoff(@PathVariable("id") Long id) {
        if (!cutoffRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cutoff not found");
        }
        cutoffRepository.deleteById(id);
        return "redirect:/admin/cutoffs";
    }
}