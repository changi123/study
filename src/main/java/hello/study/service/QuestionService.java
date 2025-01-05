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

	
//	// 단어 랜덤 아이디 조회
//	public int randomQuestion() {
//		int num = wordMapper.randomQuestion();
//		return num;
//		
//	}
	
	// 단어 아이디별 정보 조회 
	public QuestionDto selectByQuestionId(int question_id) {
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

	public int wrongAnswer(int question_id) {
		QuestionDto questionDto = wordMapper.selectByQuestionId(question_id);
		int updateCnt = questionDto.getQuestion_cnt()+1;
		questionDto.setQuestion_cnt(updateCnt);
		return wordMapper.wrongAnswer(questionDto);
	}
	
	// 테스트 할 때 문제 정보
	public QuestionDto QuestionInfo(QuestionDto questionDto) {
		return wordMapper.QuestionInfo(questionDto.getQuestion_id(), questionDto.getQuestion_day());
	}
	// 연습 할 때 문제 정보 틀린 횟수 순
	public QuestionDto QuestionPracticeInfo(int question_day) {
		return wordMapper.QuestionPracticeInfo(question_day);
	}
	
	
	// 해당하는 날짜에 문제가 있는지 체크
	public QuestionDto dayCheck(int question_day) {
		return wordMapper.dayCheck(question_day);
	}

	
	









	
}
