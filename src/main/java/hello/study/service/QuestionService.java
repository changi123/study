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

	
	// 단어 랜덤 아이디 조회
	public int randomQuestion() {
		int num = wordMapper.randomQuestion();
		return num;
		
	}
	
	// 랜덤 아이디 단어 정보 조회 
	public QuestionDto randomQuestionInfo(int question_id) {
		return wordMapper.selectByQuestionId(question_id);
		
	}
	
	@Transactional
	public void addQuestionWithExamples(QuestionDto question, ExampleDto exampleDto) {
		
		wordMapper.insertQuestion(question);
		
		int questionNum = wordMapper.selectRecentQuestion();
		
		exampleDto.setQuestion_id(questionNum);
		wordMapper.insertExample(exampleDto);
	}

	// 단어에 대한 예문 조회
	public ExampleDto exampleDetail(int question_id) {
		return wordMapper.exampleDetail(question_id);
	}








	
}
