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
	private int questionId; // 문제아이디
	private String questionWord; // 문제단어
	private String questionAns; // 문제정답
	private int questionCnt; // 틀린횟수
	private int questionDay  ; // 포함 Day
}
