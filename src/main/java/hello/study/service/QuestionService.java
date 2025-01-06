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

	
	// 단어 아이디별 정보 조회 
	public QuestionDto selectByQuestionId(int questionId) {
		return wordMapper.selectByQuestionId(questionId);
		
	}
	
	@Transactional
	public void addQuestionWithExamples(QuestionDto question, ExampleDto exampleDto) {
		
		wordMapper.insertQuestion(question);
		
		int questionNum = wordMapper.selectRecentQuestion();
		
		exampleDto.setQuestionId(questionNum);
		wordMapper.insertExample(exampleDto);
	}

	// 단어에 대한 예문 조회
	public ExampleDto exampleDetail(int questionId) {
		return wordMapper.exampleDetail(questionId);
	}

	public int wrongAnswer(int questionId) {
		QuestionDto questionDto = wordMapper.selectByQuestionId(questionId);
		int updateCnt = questionDto.getQuestionCnt()+1;
		questionDto.setQuestionCnt(updateCnt);
		return wordMapper.wrongAnswer(questionDto);
	}
	
	// 테스트 할 때 문제 정보
	public QuestionDto QuestionInfo(QuestionDto questionDto) {
		return wordMapper.questionInfo(questionDto.getQuestionId(), questionDto.getQuestionDay());
	}
	// 연습 할 때 문제 정보 틀린 횟수 순
	public QuestionDto QuestionPracticeInfo(int questionDay) {
		return wordMapper.questionPracticeInfo(questionDay);
	}
	
	
	// 해당하는 날짜에 문제가 있는지 체크
	public QuestionDto dayCheck(int questionDay) {
		return wordMapper.dayCheck(questionDay);
	}

	public Integer selectIdDayDesc(int questionId, int questionDay) {
		return wordMapper.selectIdDayDesc(questionId,questionDay);
	}

	
	









	
}
