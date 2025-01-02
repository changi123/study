package hello.study.mapper;

import org.apache.ibatis.annotations.Mapper;

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
	
	// 단어아이디 랜덤으로 뽑기
	int randomQuestion();
	
	// 단어아이디에 따른 단어
	QuestionDto selectByQuestionId(int question_id);

	ExampleDto exampleDetail(int question_id);

//	void selectQuestion();


}