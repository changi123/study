package hello.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
	private int question_id; // 문제아이디
	private String question_word; // 문제단어
	private String question_ans; // 문제정답
	private int question_cnt; // 틀린횟수
	private int question_day  ; // 포함 Day
}
