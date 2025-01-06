package hello.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.study.dto.ExampleDto;
import hello.study.dto.QuestionDto;
import hello.study.mapper.WordMapper;
import hello.study.service.QuestionService;


@RestController
@RequestMapping("/api/word")
public class RestApiController {
	@Autowired
	private  QuestionService questionService;


	// 다음 문제가 있는지 여부 체크
	@PostMapping("/next-check")
	public QuestionDto wordTest(QuestionDto questionDto) {
		int nextQuestionId = questionDto.getQuestionId()+1;
		questionDto = questionService.selectByQuestionId(nextQuestionId);
		// 더이상 문제가 없으면 0 있으면 1
		if( questionDto == null ) {
			return null ;
		} else {
			return questionDto;    		
		}    	
	}
	// 	문제가 있는 날짜인지 체크
	@PostMapping("/day-check")
	public QuestionDto dayCheck(QuestionDto questionDto) {
		questionDto = questionService.dayCheck(questionDto.getQuestionDay());
		return questionDto;    		

	}

	// 오답 횟수 증가 
	@PostMapping("/wrong-answer")
	public int wrongAnswer(QuestionDto questionDto) {
		return questionService.wrongAnswer(questionDto.getQuestionId());
	}


}
