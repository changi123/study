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


	// 단어 테스트 Day 선택 화면 이동
	@GetMapping("/test-choice-day")
	String testChoiceDay() {
		return "test-choice-day";
	}
	@GetMapping("/practice-choice-day")
	String testPractice() {
		return "practice-choice-day";
	}


	// 영단어 테스트 문제
	@GetMapping("/test")
	String test(QuestionDto questionDto , Model model) {
		questionDto = questionService.QuestionInfo(questionDto);
		ExampleDto exampleDto = questionService.exampleDetail(questionDto.getQuestionId());
		model.addAttribute("questionDto", questionDto); 
		model.addAttribute("exampleDto", exampleDto); 
		return "word-test";
	}



	// 단어 연습 문제
	@GetMapping("/practice")	
	String wordpractice(QuestionDto questionDto , Model model) {
		questionDto = questionService.QuestionInfo(questionDto);
		ExampleDto exampleDto = questionService.exampleDetail(questionDto.getQuestionId());
		model.addAttribute("questionDto", questionDto); 
		model.addAttribute("exampleDto", exampleDto); 
		return "word-practice";
	}

	@GetMapping("word-add")
	public String wordAddPage() {
		return "word-add"; 
	}
	// 단어 주가
	@PostMapping("/word-add")
	public String wordAddSubmit(QuestionDto questionDto, ExampleDto exampleDto) {
		String questionAns = questionDto.getQuestionAns();
		questionAns = questionAns.replaceAll(" ", "");
		questionAns = questionAns.trim();
		questionDto.setQuestionAns(questionAns);
		questionService.addQuestionWithExamples(questionDto, exampleDto);
		return "redirect:/"; 
	}
}
