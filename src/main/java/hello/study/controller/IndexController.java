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
	@GetMapping("/testChoiceDay")
	String testChoiceDay() {
		return "testChoiceDay";
	}
	@GetMapping("/practiceChoiceDay")
	String testPractice() {
		return "practiceChoiceDay";
	}


	// 영단어 테스트 문제
	@GetMapping("/test")
	String test(QuestionDto questionDto , Model model) {
		questionDto = questionService.QuestionInfo(questionDto);
		ExampleDto exampleDto = questionService.exampleDetail(questionDto.getQuestion_id());
		model.addAttribute("questionDto", questionDto); 
		model.addAttribute("exampleDto", exampleDto); 
		return "wordTest";
	}


	
//	// 영단어 테스트 다음 문제
//	@PostMapping("/test")
//	String testNext(QuestionDto questionDto, Model model) {
//	  	int nextQuestionId = questionDto.getQuestion_id()+1;
//    	questionDto = questionService.selectByQuestionId(nextQuestionId);
//		ExampleDto exampleDto = questionService.exampleDetail(questionDto.getQuestion_id());
//		model.addAttribute("questionDto", questionDto); 
//		model.addAttribute("exampleDto", exampleDto); 
//		return "wordTest";
//	}

	// 단어 연습 문제
	@GetMapping("/practice")	
	String wordpractice(QuestionDto questionDto , Model model) {
		questionDto = questionService.QuestionInfo(questionDto);
		ExampleDto exampleDto = questionService.exampleDetail(questionDto.getQuestion_id());
		model.addAttribute("questionDto", questionDto); 
		model.addAttribute("exampleDto", exampleDto); 
		return "wordPractice";
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
