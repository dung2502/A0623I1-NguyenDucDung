package com.example.question.controller;


import com.example.question.model.QuestionContent;
import com.example.question.services.impl.QuestionContentService;
import com.example.question.services.impl.QuestionTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {
    @Autowired
    private QuestionContentService questionContentService;
    @Autowired
    QuestionTypeService questionTypeService;
    @GetMapping("")
    public String getList(Model model, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam (name = "nameSearch",defaultValue = "")String nameSearch){
        model.addAttribute("questionContentList",questionContentService.findByTitle(nameSearch, PageRequest.of(page,4)));
        model.addAttribute("questionTypeList",questionTypeService.getAll());
        return "list";
    }
    @GetMapping("/search")
    private String getPage(Model model,@RequestParam(value = "page", defaultValue = "0")int page,@RequestParam (name = "nameSearch",defaultValue = "") String nameSearch)
    {
        model.addAttribute("questionContentList",questionContentService.findByTitle(nameSearch,PageRequest.of(page,4)));
        model.addAttribute("nameSearch",nameSearch);
        return "list";
    }
    @GetMapping("/save")
    public String toSave(@RequestParam(name = "id",defaultValue = "0") Integer id, Model model){
        if (id==0){
            model.addAttribute("questionContent",new QuestionContent());
        }else {
            model.addAttribute("questionContent",questionContentService.getQuestionContentById(id));
        }
        model.addAttribute("questionTypeList",questionTypeService.getAll());
        model.addAttribute("id",id);
        return "save";
    }
    @PostMapping("/save")
    public  String doSave(@Valid @ModelAttribute("questionContent") QuestionContent questionContent, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("questionTypeList",questionTypeService.getAll());
            return "save";
        }
        questionContent.setStatus(false);
        questionContentService.save(questionContent);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String doDelete(@RequestParam(name = "id") Integer id){
        questionContentService.delete(questionContentService.getQuestionContentById(id));
        return "redirect:/";
    }
}
