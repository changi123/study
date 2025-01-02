package hello.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

//	@Autowired
//	private WordMapper wordMapper;
	
    @PostMapping("/test")
    public QuestionDto wordTest(QuestionDto questionDto) {
    	int nextQuestionId = questionDto.getQuestion_id()+1;
    	questionDto = questionService.selectByQuestionId(nextQuestionId);
    	// 더이상 문제가 없으면 0 있으면 1
    	if( questionDto == null ) {
    		return null ;
    	} else {
    		return questionDto;    		
    	}    	
    }
    
    @PostMapping("/wrongAnswer")
    public int wrongAnswer(QuestionDto questionDto) {
    	return questionService.wrongAnswer(questionDto.getQuestion_id());
    }
    
    
}
