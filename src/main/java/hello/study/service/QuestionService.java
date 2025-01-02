package hello.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.study.dto.ExampleDto;
import hello.study.dto.QuestionDto;
import hello.study.mapper.WordMapper;

@Service
public class QuestionService {
	@Autowired
	private WordMapper wordMapper;

	@Transactional
	public void addQuestionWithExamples(QuestionDto question, ExampleDto exampleDto) {
		// Question을 먼저 추가

//		wordMapper.insertQuestion(question);
		wordMapper.selectQuestion();
		
		// Question이 삽입된 후 자동으로 생성된 ID를 ExampleDto에 설정하여 추가
		//	        exampleDto.setQuestionId(question.getId());
		//	        wordMapper.insertExample(exampleDto);
	}
}
