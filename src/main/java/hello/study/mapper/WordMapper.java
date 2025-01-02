package hello.study.mapper;

import org.apache.ibatis.annotations.Mapper;

import hello.study.dto.ExampleDto;
import hello.study.dto.QuestionDto;

@Mapper
public interface WordMapper {


	void insertQuestion(QuestionDto questionDto);

	void selectQuestion();


//	void insertExample(ExampleDto exampleDto);
}