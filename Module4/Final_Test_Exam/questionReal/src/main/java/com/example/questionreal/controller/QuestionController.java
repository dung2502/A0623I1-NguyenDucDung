package com.example.questionreal.controller;

import com.example.questionreal.model.QuestionContent;
import com.example.questionreal.service.impl.QuestionContentService;
import com.example.questionreal.service.impl.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {
    @Autowired
    private QuestionContentService questionContentService;
    @Autowired
    QuestionTypeService questionTypeService;

    @GetMapping("/questions")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam ( name = "nameSearch", defaultValue = "") String nameSearch){
        model.addAttribute("questionContentList", questionContentService.findByTitle(nameSearch, PageRequest.of(page, 5)));
        model.addAttribute("questionTypeList", questionTypeService.getAll());
        return"/question/list";
    }

}
