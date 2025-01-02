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

	@Autowired
	private WordMapper wordMapper;
	
    @GetMapping("/test")
    public int wordTest() {
        return wordMapper.randomQuestion();
    }
    
}
