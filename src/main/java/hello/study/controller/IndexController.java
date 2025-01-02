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


	@GetMapping("/testChoiceDay")
	String testChoiceDay() {
		return "word_testDay";
	}
	@GetMapping("/testPractice")
	String testPractice() {
		return "word_practiceDay";
	}
	
	
	@GetMapping("/test")
	String wordTest(@RequestParam("question_day") int question_day , Model model) {
		QuestionDto questionDto = questionService.QuestionInfo(question_day);
		ExampleDto exampleDto = questionService.exampleDetail(questionDto.getQuestion_id());
		model.addAttribute("questionDto", questionDto); 
		model.addAttribute("exampleDto", exampleDto); 
		return "word_test";
	}
	
	@GetMapping("/practice")
	String wordpractice(@RequestParam("question_day") int question_day , Model model) {
//		QuestionDto questionDto = questionService.QuestionPracticeInfo(question_day);
//		ExampleDto exampleDto = questionService.exampleDetail(questionDto.getQuestion_id());
//		model.addAttribute("questionDto", questionDto); 
//		model.addAttribute("exampleDto", exampleDto); 
		QuestionDto questionDto = questionService.QuestionInfo(question_day);
		ExampleDto exampleDto = questionService.exampleDetail(questionDto.getQuestion_id());
		model.addAttribute("questionDto", questionDto); 
		model.addAttribute("exampleDto", exampleDto); 
		return "word_practice";
	}

	@GetMapping("/add")
	public String wordAddPage() {
		return "word_add"; 
	}
	@PostMapping("/add")
	public String wordAddSubmit(QuestionDto questionDto, ExampleDto exampleDto) {
		questionService.addQuestionWithExamples(questionDto, exampleDto);
		return "redirect:/"; 
	}
}
