package hello.study.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


	// 최대Day 조회
	@PostMapping("/maxDay")
	public int maxDay() {
		return questionService.selectMaxDay();
	}
	// 다음 문제가 있는지 여부 체크
	@PostMapping("/next-check")
	public QuestionDto wordTest(QuestionDto questionDto) {
		Integer nextQuestionId = questionService.selectIdDayDesc(questionDto.getQuestionId(),questionDto.getQuestionDay());
		if( nextQuestionId == null ) {
			return null;
		} else {
			return  questionService.selectByQuestionId(nextQuestionId);
		}
	}
	// 	문제가 있는 날짜인지 체크
	@PostMapping("/day-check")
	public QuestionDto dayCheck(QuestionDto questionDto) {
		questionDto = questionService.dayCheck(questionDto.getQuestionDay());
		return questionDto;    		

	}

	// 틀린 횟수 문제 존재 여부 체크
	@PostMapping("/test-wrong")	
	public int testWrong() {
		int wrongCnt = questionService.wrongCntCheck();
		return wrongCnt;
	}
	
	// 다음 틀린 횟수 문제가 있는지 여부 체크
	@PostMapping("/wrong-next-check")
	public QuestionDto wrongNextCheck(QuestionDto questionDto) {
		questionDto = questionService.wrongPactice(questionDto.getQuestionId());
		return questionDto;
	}
	// 오답 횟수 증가 
	@PostMapping("/wrong-answer")
	public int wrongAnswer(QuestionDto questionDto) {
		return questionService.wrongAnswer(questionDto.getQuestionId());
	}
	// 추가사항 저장 
	@PostMapping("/additional-information")
	public int additionalInformation(@RequestParam("wordAddString") String wordAddString, QuestionDto questionDto, ExampleDto exampleDto) {
		if (wordAddString.length() == 0) {
			return 1; 
		}
		
		// 실수로 띄어쓰기만 오는 경우가 있다..
		// 공백 기준으로 쪼개고 만약 글자를 하나라도 만나면 true 주고 INSERT 하자
		boolean flag = false;
		String [] arr = wordAddString.split("");
		String pattern = "[a-zA-Z]";
		for( String s : arr) {
			if( s.matches(pattern)) {
				flag = true;
				break;
			}
		}
		if( flag ) {			
			questionService.additionalInformation(wordAddString,questionDto,exampleDto);
		}
		return 1;
	}
	


}
