package hello.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.study.dto.ExampleDto;
import hello.study.dto.QuestionDto;
import hello.study.service.QuestionService;

@Controller
public class WordController {
    @Autowired
    private  QuestionService questionService;


    @GetMapping("word/test")
    public String wordTest() {
        return "word_test"; 
    }
    @GetMapping("word/add")
    public String wordAddPage() {
    	return "word_add"; 
    }

    @PostMapping("word/add")
    public String wordAddSubmit(QuestionDto questionDto, ExampleDto exampleDto) {
    	  questionService.addQuestionWithExamples(questionDto, exampleDto);
    	
    	return "redirect:/word/test"; 
    }
}
