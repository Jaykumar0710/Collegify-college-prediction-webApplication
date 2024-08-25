package com.jkcreation.Collegify.controller;

import com.jkcreation.Collegify.entity.Cutoff;
import com.jkcreation.Collegify.entity.StudentInput;
import com.jkcreation.Collegify.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private PredictionService predictionService;



    @GetMapping("/contact")
    public  String contact(){
        return "contact";
    }

    @GetMapping("/team")
    public String team(){
        return "team";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/predict")
    public String showPredictionForm(Model model) {
        model.addAttribute("studentInput", new StudentInput());
        return "predict";
    }

    @PostMapping("/predict")
    public String predictColleges(@ModelAttribute StudentInput studentInput, Model model) {
        List<Cutoff> predictedCutoffs = predictionService.predictColleges(
                studentInput.getPercentile(),
                studentInput.getDepartment(),
                studentInput.getCategory());

        model.addAttribute("cutoffs", predictedCutoffs);
        return "results";


    }
}
