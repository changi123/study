package hello.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hello.study.dto.ExampleDto;
import hello.study.dto.QuestionDto;

@Mapper
public interface WordMapper {

	// 단어 추가
	void insertQuestion(QuestionDto questionDto);

	// 단어에 대한 예문 추가
	void insertExample(ExampleDto exampleDto);

	
	// 추가된 단어 아이디 가져오기
	int selectRecentQuestion();
	
	// 단어아이디에 따른 단어
	QuestionDto selectByQuestionId(int questionId);

	ExampleDto exampleDetail(int questionId);

	int wrongAnswer(QuestionDto questionDto);

	// 문제 아이디와 날짜 정보로 문제 조회
	QuestionDto questionInfo(@Param("questionId") int questionId , @Param("questionDay") int questionDay);

	QuestionDto questionPracticeInfo(int questionDay);
	
	// 해당하는 날짜에 문제가 있는지 체크
	QuestionDto dayCheck(int questionDay);

	Integer selectIdDayDesc(@Param("questionId") int questionId, @Param("questionDay") int questionDay);

	// 먼저 이미 있는 데이터인지 확인
	int cntCheck(String questionWord);

	// 틀린 횟수 문제가 있는지 체크
	int wrongCntCheck();
	
	// 틀린 횟수 정렬 문제
	QuestionDto wrongPactice(int questionId);

	// 최대 Day 조회
	int selectMaxDay();



}