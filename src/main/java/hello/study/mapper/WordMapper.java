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
	QuestionDto selectByQuestionId(int question_id);

	ExampleDto exampleDetail(int question_id);

	int wrongAnswer(QuestionDto questionDto);

	// 문제 아이디와 날짜 정보로 문제 조회
	QuestionDto QuestionInfo(@Param("question_id") int question_id , @Param("question_day") int question_day);

	QuestionDto QuestionPracticeInfo(int question_day);
	
	// 해당하는 날짜에 문제가 있는지 체크
	QuestionDto dayCheck(int question_day);

//	void selectQuestion();


}