package hello.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.study.dto.ExampleDto;
import hello.study.dto.QuestionDto;
import hello.study.mapper.WordMapper;
import hello.study.service.QuestionService;


@Controller
@RequestMapping("/word")
public class IndexController {
	@Autowired
	private  QuestionService questionService;

	@Autowired
	private WordMapper wordMapper;


	@GetMapping("/test")
	String wordTest(@RequestParam("question_id") int question_id , Model model) {

		QuestionDto questionDto = questionService.randomQuestionInfo(question_id);
		ExampleDto exampleDto = questionService.exampleDetail(question_id);
		model.addAttribute("questionDto", questionDto); 
		model.addAttribute("exampleDto", exampleDto); 
		return "word_test";
	}

	@GetMapping("/add")
	public String wordAddPage() {
		return "word_add"; 
	}
	@PostMapping("/add")
	public String wordAddSubmit(QuestionDto questionDto, ExampleDto exampleDto) {
		questionService.addQuestionWithExamples(questionDto, exampleDto);
		return "index"; 
	}
}
